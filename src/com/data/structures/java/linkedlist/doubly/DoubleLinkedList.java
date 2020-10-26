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

    public void deleteFirst() {
        if (null == start) {
            System.out.print("List is empty...");
            return;
        }
        if (null == start.next) {
            start = null;
            return;
        }
        start = start.next;
        start.prev = null;
    }

    public void deleteLast() {
        if (null == start) {
            System.out.print("List is empty...");
            return;
        }
        if (null == start.next) {
            start = null;
            return;
        }
        DoubleLinkedListNode temp = start;
        while (null != temp.next) {
            temp = temp.next;
        }
        temp.prev.next = null;
    }

    public void deleteNode(int data) {
        if (null == start) {
            System.out.print("List is empty...");
            return;
        }
        if (null == start.next) {
            if (start.info == data) {
                start = null;
            } else {
                System.out.print(data + " is not present in the list.");
            }
            return;
        }
        if (start.info == data) {
            start = start.next;
            start.prev = null;
            return;
        }
        DoubleLinkedListNode temp = start.next;
        while (null != temp) {
            if (temp.info == data) {
                break;
            }
            temp = temp.next;
        }
        if (null == temp) {
            System.out.print(data + " is not present in the list.");
        } else {
            temp.prev.next = temp.next;
            if (null != temp.next) {
                temp.next.prev = temp.prev;
            }
        }
    }

    public void reverseList() {
        if (null == start) {
            System.out.print("List is empty...");
            return;
        }

        DoubleLinkedListNode backward = start;
        DoubleLinkedListNode forward = backward.next;
        backward.next = null;
        backward.prev = forward;

        while (null != forward) {
            forward.prev = forward.next;
            forward.next = backward;
            backward = forward;
            forward = forward.prev;
        }
        start = backward;
    }
}