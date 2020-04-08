package io.hikari.labs.test.algorithms;

import io.hikari.labs.algorithms.LinkedLists;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Noa Swartz
 * @date 2020-04-08
 */
public class LinkedListsTest {

    @Test
    public void testReverseLinkedList() {
        LinkedLists.Node head = new LinkedLists.Node(1, new LinkedLists.Node(2, new LinkedLists.Node(3)));
        LinkedLists.Node result = LinkedLists.reverseLinkedList(head);
        Assert.assertEquals(result.toString(), "3->2->1");
    }

}
