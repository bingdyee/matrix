package io.github.matrix.codewars.lists;

import io.github.matrix.codewars.common.Node;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * @author Noa Swartz
 * @date 2020/12/11
 */
public class LinkedListTest {

    public static final Logger logger = LoggerFactory.getLogger(LinkedListTest.class);

    private static final Random RANDOM = new Random();

    private static final int SPAN = 5;

    @Test
    public void testReverseList() {
        Node<Integer> head = randomLinkedList(9, false);
        logger.info("pre: {}", head);
        Node<Integer> result = LinkedList.reverseList(head);
        logger.info("post: {}", result);
    }

    @Test
    public void testMergeLists() {
        Node<Integer> first = randomLinkedList(5, true);
        Node<Integer> second = randomLinkedList(5, true);
        logger.info("First: {}", first);
        logger.info("Second: {}", second);
        Node<Integer> result = LinkedList.mergeLists(first, second);
        logger.info("Merged: {}", result);
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
