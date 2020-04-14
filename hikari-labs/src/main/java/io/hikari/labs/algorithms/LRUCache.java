package io.hikari.labs.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Noa Swartz
 * @date 2020-04-11
 */
public class LRUCache<K, V> {

    private int capacity;
    private LinkedNode<K, V> head;
    private LinkedNode<K, V> tail;
    private Map<K, LinkedNode<K, V>> cacheMap;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new HashMap<>();
        this.head = new LinkedNode<>();
        this.tail = new LinkedNode<>();
        head.next = tail;
        tail.pre = head;
    }

    public V get(K key) {
        if (cacheMap.containsKey(key)) {
            LinkedNode<K, V> node = cacheMap.get(key);
            move2top(node);
            return node.value;
        }
        return null;
    }

    public void put(K key, V value) {
        if (!cacheMap.containsKey(key)) {
            if (cacheMap.size() == capacity) {
                // delete last node
                LinkedNode<K, V> last = tail.pre;
                last.pre.next = tail;
                tail.pre = last.pre;
                cacheMap.remove(last.key);
            }
            LinkedNode<K, V> temp = head.next;
            LinkedNode<K, V> node = new LinkedNode<>(key, value);
            head.next = node;
            node.pre = head;
            node.next = temp;
            temp.pre = node;
            cacheMap.put(key, node);
        } else {
            LinkedNode<K, V> node = cacheMap.get(key);
            node.value = value;
            move2top(node);
        }
    }

    /**
     * Move to top
     *
     * @param node target node
     */
    private void move2top(LinkedNode<K, V> node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        LinkedNode<K, V> temp = head.next;
        head.next = node;
        node.pre = head;
        node.next = temp;
    }

    static final class LinkedNode<K, V> {

        K key;
        V value;
        LinkedNode<K, V> pre;
        LinkedNode<K, V> next;

        public LinkedNode() { }

        public LinkedNode(K k, V v) {
            this.key = k;
            this.value = v;
        }

    }

}
