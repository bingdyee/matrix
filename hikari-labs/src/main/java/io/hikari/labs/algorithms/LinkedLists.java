package io.hikari.labs.algorithms;

/**
 * @author Noa Swartz
 * @date 2020-04-08
 */
public class LinkedLists {

    public static Node reverseLinkedList(Node head) {
        Node cur = head;
        Node prev = null;
        while (cur != null) {
            Node temp = cur.getNext();
            cur.setNext(prev);
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    public static boolean exitLoop(Node head) {
        Node fast = head, slow = head;
        while (slow != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next ;
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static Node enterPoint(Node head) {
        Node fast = head, slow = head;
        while (slow != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next ;
            if(slow == fast) {
                break;
            }
        }
        if (slow == null || fast.next == null) { return null; }
        Node tmp0 = head;
        Node tmp1 = slow;
        while (tmp0 != tmp1) {
            tmp0 = tmp0.next;
            tmp1 = tmp1.next;
        }
        return tmp0;
    }

    public static int loopLinkedLength(Node head) {
        Node fast = head, slow = head;
        while (slow != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next ;
            if(slow == fast) {
                break;
            }
        }
        Node tmp = slow;
        int len = 1;
        while(slow.next != tmp) {
            slow = slow.next;
            ++len;
        }
        return len;
    }


    public static final class Node {
        private Integer data;
        private Node next;

        public Node() { }

        public Node(Integer data) {
            this(data, null);
        }

        public Node(Integer data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Integer getData() {
            return data;
        }

        public Node setData(int data) {
            this.data = data;
            return this;
        }

        public Node getNext() {
            return next;
        }

        public Node setNext(Node next) {
            this.next = next;
            return this;
        }

        @Override
        public String toString() {
            String str = this.data + "";
            Node next = this.next;
            while (next != null) {
                str += "->" + next.data;
                next = next.next;
            }
            return str;
        }
    }



}

