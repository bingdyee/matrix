package io.github.matrix.codewars.lists;

import io.github.matrix.codewars.common.Node;
import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * @author Noa Swartz
 * @date 2020/12/11
 */
public class LinkedListTest {

    private static final Random RANDOM = new Random();

    private static final int SPAN = 5;

    @Test
    public void testReverseList() {
        Node<Integer> head = randomLinkedList(9, false);
        System.err.println("Pre: " + head);
        Node<Integer> result = LinkedList.reverseList(head);
        System.err.println("Post: " + result);
    }

    @Test
    public void testMergeLists() {
        Node<Integer> first = randomLinkedList(5, true);
        Node<Integer> second = randomLinkedList(5, true);
        System.err.println("First: " + first);
        System.err.println("Second: " + second);
        Node<Integer> result = LinkedList.mergeLists(first, second);
        System.err.println("Merged: " + result);
    }

    private Node<Integer> randomLinkedList(int num, boolean sorted) {
        int first = RANDOM.nextInt(SPAN);
        int bound = SPAN * num;
        Node<Integer> node = new Node<>(first);
        Node<Integer> current = node;
        for (int i = 1; i < num; ++i) {
            first = sorted ? first + (int)(Math.random() * SPAN) + 1 : RANDOM.nextInt(bound);
            current.next = new Node<>(first);
            current = current.next;
        }
        return node;
    }

}
