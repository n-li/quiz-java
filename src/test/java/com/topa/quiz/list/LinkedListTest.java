package com.topa.quiz.list;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class LinkedListTest {

    @Test
    public void testAddElement(){
        IntLinkedList linkedList = new IntLinkedList();
        linkedList.add(1);
        assertEquals(1, linkedList.size());
    }

    @Test
    public void testAddElementToNonEmptyList(){
        IntLinkedList linkedList = new IntLinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        assertEquals(3, linkedList.size());
    }

    @Test
    public void testGetElement(){
        IntLinkedList linkedList = new IntLinkedList();
        linkedList.add(1);
        assertEquals(1, linkedList.get(0));
    }

    @Test
    public void testGetElementFromTheMiddle() {
        IntLinkedList linkedList = new IntLinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        assertEquals(2, linkedList.get(1));
    }

    @Test
    public void testGetLastElement() {
        IntLinkedList linkedList = new IntLinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        assertEquals(3, linkedList.get(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetElementFromEmptyList() {
        IntLinkedList linkedList = new IntLinkedList();
        linkedList.get(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetOutOfBoundsElementFromNonEmptyList() {
        IntLinkedList linkedList = new IntLinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.get(2);
    }

    @Test
    public void testRemoveFirstElement() {
        IntLinkedList linkedList = new IntLinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        int removedValue = linkedList.remove(0);
        assertEquals("Invalid removed value", 1, removedValue);
        assertEquals("Invalid list size after remove", 2, linkedList.size());
        checkListElements(linkedList, 2, 3);
    }

    @Test
    public void testRemoveElementFromTheMiddle() {
        IntLinkedList linkedList = new IntLinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        int removedValue = linkedList.remove(1);
        assertEquals("Invalid removed value", 2, removedValue);
        assertEquals("Invalid list size after remove", 2, linkedList.size());
        checkListElements(linkedList, 1, 3);
    }

    @Test
    public void testRemoveLastElement() {
        IntLinkedList linkedList = new IntLinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        int removedValue = linkedList.remove(2);
        assertEquals("Invalid removed value", 2, linkedList.size());
        assertEquals("Invalid list size after remove", 3, removedValue);
        checkListElements(linkedList, 1, 2);
    }

    @Test
    public void testRemoveTailElement() {
        IntLinkedList linkedList = new IntLinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        int removedValue = linkedList.removeLast();
        assertEquals("Invalid removed value", 2, linkedList.size());
        assertEquals("Invalid list size after remove", 3, removedValue);
        checkListElements(linkedList, 1, 2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveFromEmptyList() {
        IntLinkedList linkedList = new IntLinkedList();
        linkedList.remove(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveTailElementFromEmptyList() {
        IntLinkedList linkedList = new IntLinkedList();
        linkedList.removeLast();
    }

    @Test
    public void testRemoveElementsByValue() {
        IntLinkedList linkedList = new IntLinkedList();
        linkedList.add(3);
        linkedList.add(2);
        linkedList.add(4);
        linkedList.add(1);
        linkedList.add(5);
        linkedList.add(6);
        int count = linkedList.removeGreaterThan(3);
        assertEquals("Invalid number of removed elements", 3, count);
        assertEquals("Invalid list size after remove", 3, linkedList.size());
        checkListElements(linkedList, 3, 2, 1);
    }

    @Test
    public void testRemoveElementsByValue_expectNoElementRemoved() {
        IntLinkedList linkedList = new IntLinkedList();
        linkedList.add(3);
        linkedList.add(2);
        linkedList.add(4);
        linkedList.add(1);
        linkedList.add(5);
        linkedList.add(6);
        int count = linkedList.removeGreaterThan(10);
        assertEquals("Invalid number of removed elements", 0, count);
        assertEquals("Invalid list size after remove", 6, linkedList.size());
        checkListElements(linkedList, 3, 2, 4, 1, 5, 6);
    }

    private void checkListElements(IntLinkedList list, int ... expectedElements) {
        for (int i=0; i < expectedElements.length; i ++) {
            assertEquals("Invalid element in list", expectedElements[i], list.get(i));
        }
    }
}
