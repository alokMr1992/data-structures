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

    public void insertAfter(int data, int element) {
        if (null == start) {
            System.out.println("List is empty...");
            return;
        }

        DoubleLinkedListNode node = new DoubleLinkedListNode(data);
        DoubleLinkedListNode temp = start;
        while (null != temp) {
            if (temp.info == element) {
                break;
            }
            temp = temp.next;
        }

        if (null == temp) {
            System.out.print(element + " doesn't exist in the list...");
        } else {
            node.prev = temp;
            node.next = temp.next;
            if (null != temp.next) {
                temp.next.prev = node;
            }
            temp.next = node;
        }
    }

    public void insertBefore(int data, int element) {
        if (null == start) {
            System.out.println("List is empty...");
            return;
        }

        DoubleLinkedListNode node = new DoubleLinkedListNode(data);

        if (start.info == element) {
            node.next = start;
            start.prev = node;
            start = node;
            return;
        }

        DoubleLinkedListNode temp = start;
        while (null != temp) {
            if (temp.info == element) {
                break;
            }
            temp = temp.next;
        }

        if (null == temp) {
            System.out.print(element + " doesn't exist in the list...");
        } else {
            node.prev = temp.prev;
            node.next = temp;
            temp.prev.next = node;
            temp.prev = node;
        }
    }
}