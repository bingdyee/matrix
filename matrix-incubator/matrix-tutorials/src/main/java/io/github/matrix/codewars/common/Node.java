package io.github.matrix.codewars.common;


/**
 * @author Noa Swartz
 * @date 2020/12/11
 */
public class Node<E> {

    public E val;
    public Node<E> next;
    public Node<E> prev;

    public Node() { }

    public Node(E item) {
        this(item, null, null);
    }

    public Node (E item, Node<E> next) {
        this(item, next, null);
    }

    public Node (E item, Node<E> next, Node<E> prev) {
        this.val = item;
        this.next = next;
        this.prev = prev;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder(val + "");
        Node<E> current = this.next;
        while (current != null) {
            str.append("->").append(current.val);
            current = current.next;
        }
        return str.toString();
    }

}
