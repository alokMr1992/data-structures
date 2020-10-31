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
}
