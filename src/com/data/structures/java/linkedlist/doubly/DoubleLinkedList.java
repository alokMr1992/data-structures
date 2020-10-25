package com.data.structures.java.linkedlist.doubly;

import java.util.Scanner;

public class DoubleLinkedList {

    private DoubleLinkedListNode start;

    public DoubleLinkedList() {
        start = null;
    }

    public void createList() {
        System.out.println("Creation of list...");
        int i, numberOfNodes, data;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of nodes : ");
        numberOfNodes = scanner.nextInt();

        if (numberOfNodes <= 0) {
            return;
        }

        for (i = 1; i <= numberOfNodes; i++) {
            System.out.print("Enter the element to be inserted : ");
            data = scanner.nextInt();
            insertAtEnd(data);
        }
    }

    public void displayList() {
        if (null == start) {
            System.out.print("*** List is empty***");
            return;
        }

        DoubleLinkedListNode temp = start;
        System.out.print("List is : ");
        while (null != temp) {
            System.out.print(temp.info + " ");
            temp = temp.next;
        }
    }

    public void insertAtBeginning(int data) {
        DoubleLinkedListNode node = new DoubleLinkedListNode(data);
        if (null == start) {
            start = node;
            return;
        }
        node.next = start;
        start.prev = node;
        start = node;
    }

    public void insertAtEnd(int data) {
        DoubleLinkedListNode node = new DoubleLinkedListNode(data);
        if (null == start) {
            start = node;
            return;
        }
        DoubleLinkedListNode temp = start;
        while (null != temp.next) {
            temp = temp.next;
        }
        temp.next = node;
        node.prev = temp;
    }
}
