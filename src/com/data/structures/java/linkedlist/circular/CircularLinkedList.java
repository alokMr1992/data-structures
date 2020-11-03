package com.data.structures.java.linkedlist.circular;

import java.util.Scanner;

public class CircularLinkedList {

    private CircularLinkedListNode last;

    public CircularLinkedList() {
        last = null;
    }

    public void createList() {
        System.out.println("Creation of list : ");
        int i, numberOfNodes, data;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of nodes : ");
        numberOfNodes = scanner.nextInt();

        if (numberOfNodes <= 0){
            return;
        }

        for (i = 1; i <= numberOfNodes; i++) {
            System.out.print("Enter the element to be inserted : ");
            data = scanner.nextInt();
            insertAtEnd(data);
        }
    }

    public void displayList() {
        if (null ==  last) {
            System.out.print("List is empty...");
            return;
        }

        CircularLinkedListNode temp = last.link;

        do {
            System.out.print(temp.info + " ");
            temp = temp.link;
        } while (temp != last.link);
    }

    public void insertAtBeginning(int data) {
        if (null == last) {
            insertInEmptyList(data);
            return;
        }

        CircularLinkedListNode temp = new CircularLinkedListNode(data);
        temp.link = last.link;
        last.link = temp;
    }

    public void insertAtEnd(int data) {
        if (null == last) {
            insertInEmptyList(data);
            return;
        }

        CircularLinkedListNode temp = new CircularLinkedListNode(data);
        temp.link = last.link;
        last.link = temp;
        last = temp;
    }

    private void insertInEmptyList(int data) {
        CircularLinkedListNode temp = new CircularLinkedListNode(data);
        last = temp;
        last.link = last;
    }

    public void insertAfter(int data, int element) {
        if (null == last) {
            System.out.print("List is empty...");
            return;
        }
        CircularLinkedListNode temp = last.link;
        do {
            if (temp.info == element) {
                break;
            }
            temp = temp.link;
        } while (temp != last.link);

        if (temp == last.link && temp.info != element) {
            System.out.print(element + " is not present in the list.");
        } else {
            CircularLinkedListNode node = new CircularLinkedListNode(data);
            node.link = temp.link;
            temp.link = node;
            if (temp == last) {
                last = node;
            }
        }
    }

    public void deleteFirst() {
        if (null == last) {
            System.out.print("List is empty...");
            return;
        }
        if (last.link == last) {
            last = null;
            return;
        }
        last.link = last.link.link;
    }

    public void deleteLast() {
        if (null == last) {
            System.out.print("List is empty...");
            return;
        }
        if (last.link == last) {
            last = null;
            return;
        }
        CircularLinkedListNode temp = last.link;
        while (temp.link != last) {
            temp = temp.link;
        }
        temp.link = last.link;
        last = temp;
    }

    public void deleteNode(int data) {
        if (null == last) {
            System.out.print("List is empty...");
            return;
        }
        if (last.link == last && last.info == data) {
            last = null;
            return;
        }
        if (last.link.info == data) {
            last.link = last.link.link;
            return;
        }

        CircularLinkedListNode temp = last.link;
        while (temp.link != last.link) {
            if (temp.link.info == data) {
                break;
            }
            temp = temp.link;
        }
        if (temp.link == last.link) {
            System.out.print(data + " is not present in the list.");
        } else {
            temp.link = temp.link.link;
            if (last.info == data) {
                last = temp;
            }
        }
    }
}
