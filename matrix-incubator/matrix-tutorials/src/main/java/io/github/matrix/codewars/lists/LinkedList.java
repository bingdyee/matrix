package io.github.matrix.codewars.lists;


import io.github.matrix.codewars.common.Node;

import java.awt.*;
import java.util.Comparator;
import java.util.Objects;

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
     * Merge two sorted linked list into one
     *
     * @param first linked list
     * @param second linked list
     * @param <E>  element type
     * @return merged linked list
     */
    public static<E extends Comparable<E>> Node<E> mergeLists(Node<E> first, Node<E> second) {
        if (first == null && second == null) {
            return null;
        }
        Node<E> merged = new Node<>();
        Node<E> temp = merged;
        while (first != null  && second != null) {
            if (first.val.compareTo(second.val) < 0) {
                temp.next = first;
                temp = first;
                first  = first.next;
            } else {
                temp.next = second;
                temp = second;
                second = second.next;
            }
        }
        while (first != null) {
            temp.next = first;
            temp = first;
            first = first.next;
        }

        while (second != null) {
            temp.next = second;
            temp = second;
            second = second.next;
        }
        return merged.next;
    }

}
