package io.hikari.labs.mio.common;

/**
 * @author Noa Swartz
 * @date 2020-04-10
 */
public class BitMap {

    public static final int DEFAULT_CAPACITY = 1024;

    private byte[] bits;
    private int capacity;

    public BitMap() {
        this(DEFAULT_CAPACITY);
    }

    public BitMap(int size) {
        this.capacity = indexOf(size) + 1;
        this.bits = new byte[this.capacity];
    }

    public void add(int num) {
        grow(num);
        bits[indexOf(num)] |= (0x80 >> position(num));
    }

    public void remove(int num) {
        if (indexOf(num) < bits.length) {
            bits[indexOf(num)] &= ~(0x80 >> position(num));
        }
    }

    public boolean contains(int num) {
        return indexOf(num) < bits.length && (bits[indexOf(num)] & (0x80 >> position(num))) != 0;
    }

    private int indexOf(int num) {
        return num >> 3;
    }

    private int position(int num) {
        return num & 0x07;
    }

    private void grow(int num) {
        int newCapacity = indexOf(num) + 1;
        if (newCapacity > capacity) {
            byte[] bytes = new byte[newCapacity];
            System.arraycopy(bits, 0, bytes, 0, bits.length);
            bits = bytes;
            capacity = newCapacity;
        }
    }

    private String showAt(int index) {
        String binary = Integer.toBinaryString(Byte.toUnsignedInt(bits[index]));
        return binary.length() < 8 ?
                String.format("%0" + (8 - binary.length() % 8) + "d%s", 0, binary) :
                binary;
    }

}
