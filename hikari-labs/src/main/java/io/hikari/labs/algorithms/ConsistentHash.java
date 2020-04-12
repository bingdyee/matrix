package io.hikari.labs.algorithms;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.*;

/**
 * Consistent Hash
 *
 * @author Noa Swartz
 * @date 2020-04-12
 */
public class ConsistentHash<T> {

    private final int replicasNum;
    private final SortedMap<Long, T> circle = new TreeMap<>();

    public ConsistentHash(int replicasNum, Collection<T> nodes) {
        this.replicasNum = replicasNum;
        nodes.forEach(this::add);
    }

    public void add(T node) {
        for (int i = 0; i < this.replicasNum; ++i) {
            Long hash = hash(node.toString() + i);
            circle.put(hash, node);
        }
    }

    public void remove(T node) {
        for (int i = 0; i < this.replicasNum; ++i) {
            Long hash = hash(node.toString() + i);
            circle.remove(hash);
        }
    }

    public T get(String key) {
        if (circle.isEmpty()) {
            return null;
        }
        long hash = hash(key);
        if (!circle.containsKey(hash)) {
            SortedMap<Long, T> tailMap = circle.tailMap(hash);
            hash = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
        }
        return circle.get(hash);
    }

    /**
     * MurMurHash
     *
     * @param key
     * @return
     */
    public static Long hash(String key) {
        ByteBuffer buf = ByteBuffer.wrap(key.getBytes());
        ByteOrder byteOrder = buf.order();
        buf.order(ByteOrder.LITTLE_ENDIAN);
        int seed = 0x1234ABCD;
        long m = 0xc6a4a7935bd1e995L;
        int r = 47;
        long h = seed ^ (buf.remaining() * m);
        long k;
        while (buf.remaining() >= 8) {
            k = buf.getLong();
            k *= m;
            k ^= k >>> r;
            k *= m;
            h ^= k;
            h *= m;
        }
        if (buf.remaining() > 0) {
            ByteBuffer finish = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);
            finish.put(buf).rewind();
            h ^= finish.getLong();
            h *= m;
        }
        h ^= h >>> r;
        h *= m;
        h ^= h >>> r;
        buf.order(byteOrder);
        return h;
    }

    public static void main(String[] args) {
        String ipPrefix = "192.168.0.";
        Map<String, Integer> map = new HashMap<>();
        List<Node> nodes = new ArrayList<>();
        for (int i = 1; i < 11; ++i) {
            map.put(ipPrefix + i, 0);
            Node node = new Node(ipPrefix + i, "node-" + i);
            nodes.add(node);
        }
        ConsistentHash<Node> consistentHash = new ConsistentHash<>(500, nodes);
        for (int i = 0; i < 5000; ++i) {
            String data = UUID.randomUUID().toString() + i;
            Node node = consistentHash.get(data);
            map.put(node.getIp(), map.get(node.getIp()) + 1);
        }
        for (int i = 1; i < 11; ++i) {
            System.err.println(String.format("%s%d节点记录条数: %d", ipPrefix, i, map.get(ipPrefix + i)));
        }

    }

}

class Node {

    private String ip;
    private String name;

    public Node() {}

    public Node(String ip, String name) {
        this.ip = ip;
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return ip;
    }

}