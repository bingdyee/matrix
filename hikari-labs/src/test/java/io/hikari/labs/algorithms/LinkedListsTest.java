package io.hikari.labs.algorithms;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Noa Swartz
 * @date 2020-04-08
 */
public class LinkedListsTest {

    private LinkedLists.Node createLoopLinkedList() {
        LinkedLists.Node head = new LinkedLists.Node(0);
        LinkedLists.Node node0 = new LinkedLists.Node(1);
        LinkedLists.Node node1 = new LinkedLists.Node(2);
        LinkedLists.Node node2 = new LinkedLists.Node(3);
        LinkedLists.Node node3 = new LinkedLists.Node(4);
        LinkedLists.Node node4 = new LinkedLists.Node(5);
        head.setNext(node0);
        node0.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node2);
        return head;
    }

    private LinkedLists.Node createLinkedList() {
        LinkedLists.Node head = new LinkedLists.Node(0);
        LinkedLists.Node node1 = new LinkedLists.Node(1);
        LinkedLists.Node node2 = new LinkedLists.Node(2);
        LinkedLists.Node node3 = new LinkedLists.Node(3);
        LinkedLists.Node node4 = new LinkedLists.Node(4);
        LinkedLists.Node node5 = new LinkedLists.Node(5);
        LinkedLists.Node node6 = new LinkedLists.Node(6);
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        return head;
    }


    @Test
    public void testReverseLinkedList() {
        LinkedLists.Node head = createLinkedList();
        LinkedLists.Node result = LinkedLists.reverseLinkedList(head);
        Assert.assertEquals(result.toString(), "6->5->4->3->2->1->0");
    }

    @Test
    public void testExitLoop() {
        LinkedLists.Node head = createLoopLinkedList();
        Assert.assertTrue(LinkedLists.exitLoop(head));
    }

    @Test
    public void testEnterPoint() {
        LinkedLists.Node head = createLoopLinkedList();
        LinkedLists.Node enterPoint = LinkedLists.enterPoint(head);
        Assert.assertNotNull(enterPoint);
        Assert.assertEquals(enterPoint.getData().intValue(), 3);
    }

    @Test
    public void testLoopLinkedLength() {
        LinkedLists.Node head = createLoopLinkedList();
        System.err.println(LinkedLists.loopLinkedLength(head));
        Assert.assertEquals(LinkedLists.loopLinkedLength(head), 3);
        /**
         * 由于扩容是按两倍进行扩，即 N 扩为 N + N，因此就会存在低位部分 0 - (N-1)，以及高位部分 N - (2N-1)， 所以这里分为 loHead (low Head) 和 hiHead (high head)。
         *
         * 通过上面的分析，不难发现循环的产生是因为新链表的顺序跟旧的链表是完全相反的，所以只要保证建新链时还是按照原来的顺序的话就不会产生循环。
         *
         * JDK8是用 head 和 tail 来保证链表的顺序和之前一样，这样就不会产生循环引用（JDK8以前是颠倒顺序的）。
         *
         */
    }

}
