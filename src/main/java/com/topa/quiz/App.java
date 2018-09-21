package com.topa.quiz;

import com.topa.quiz.list.IntLinkedList;

/**
 * Demo app
 *
 */
public class App {

    public static void main( String[] args ) {

        IntLinkedList linkedList = new IntLinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(7);

        System.out.println("List size is " + linkedList.size());
        printList(linkedList);

        linkedList.removeLast();
        System.out.println("After deleting tail element size is " + linkedList.size());
        printList(linkedList);

        linkedList.removeGreaterThan(4);
        System.out.println("After deleting numbers greater than 4 size is " + linkedList.size());
        printList(linkedList);


    }

    private static void printList(IntLinkedList linkedList) {
        for (int i=0; i < linkedList.size(); i ++) {
            System.out.println("index: " + i + ", value: " + linkedList.get(i));
        }
    }
}
