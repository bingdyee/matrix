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
    }

}
