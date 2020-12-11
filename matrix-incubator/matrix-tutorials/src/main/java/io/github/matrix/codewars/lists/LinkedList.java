package io.github.matrix.codewars.lists;


import io.github.matrix.codewars.common.Node;

import java.awt.*;

/**
 *
 * Lists、Algorithms
 *
 * @author Noa Swartz
 * @date 2020/12/11
 */
public class LinkedList {

    /**
     * Reverse linked list
     *
     * @param node linked list
     * @param <E> element type
     * @return Reversed linked list
     */
    public static <E> Node<E> reverseList(Node<E> node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node<E> head = null, next;
        while (node != null) {
            next = node.next;
            node.next = head;
            head = node;
            node = next;
        }
        return head;
    }

    /**
     * @TODO Merge two sorted linked list into one
     *
     * @param first linked list
     * @param second linked list
     * @param <E>  element type
     * @return merged linked list
     */
    public static <E> Node<E> mergeLists(Node<E> first, Node<E> second) {
        if (first == null || second == null) {
            return null;
        }

        return first;
    }

}
