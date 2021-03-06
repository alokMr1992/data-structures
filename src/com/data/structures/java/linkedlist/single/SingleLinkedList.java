package com.data.structures.java.linkedlist.single;

import java.util.Scanner;

public class SingleLinkedList {

    private SingleLinkedListNode start;

    public SingleLinkedList() {
        start = null;
    }

    public void createList() {
        System.out.println("Creation of list....");
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
        SingleLinkedListNode temp;
        if (null == start) {
            System.out.print("*** List is empty ***");
            return;
        }
        System.out.print("List is : ");
        temp = start;
        while (null != temp) {
            System.out.print(temp.info + " ");
            temp = temp.link;
        }
    }

    public int countNodes(){
        SingleLinkedListNode temp;
        int nodeCount = 0;
        if (null == start) {
            return nodeCount;
        }
        temp = start;
        while (null != temp) {
            nodeCount++;
            temp = temp.link;
        }
        return nodeCount;
    }

    public int search(int element) {
        SingleLinkedListNode temp;
        int position = 1;
        temp = start;
        while (null != temp) {
            if (temp.info == element){
                break;
            }
            position++;
            temp = temp.link;
        }
        if (null == temp) {
            position = -1;
        }
        return position;
    }

    public void insertAtBeginning(int data) {
        SingleLinkedListNode node = new SingleLinkedListNode(data);
        node.link = start;
        start = node;
    }

    public void insertAtEnd(int data) {
        SingleLinkedListNode node = new SingleLinkedListNode(data);

        if (null == start) {
            start = node;
        } else {
            SingleLinkedListNode temp = start;
            while (null != temp.link) {
                temp = temp.link;
            }
            temp.link = node;
        }
    }

    public void insertAfter(int data, int nodeValue) {
        if (null == start) {
            System.out.print("List is empty...");
            return;
        }
        SingleLinkedListNode temp = start;
        while (null != temp) {
            if (temp.info == nodeValue) {
                break;
            }
            temp = temp.link;
        }
        if (null == temp) {
            System.out.print(nodeValue + " does not exist in the list.");
        } else {
            SingleLinkedListNode node = new SingleLinkedListNode(data);
            node.link = temp.link;
            temp.link = node;
        }
    }

    public void insertBefore(int data, int nodeValue) {
        if (null == start) {
            System.out.print("List is empty...");
            return;
        }
        SingleLinkedListNode node = new SingleLinkedListNode(data);
        if (start.info == nodeValue) {
            node.link = start;
            start = node;
            return;
        }
        SingleLinkedListNode temp = start;
        while (null != temp.link) {
            if (temp.link.info == nodeValue) {
                break;
            }
            temp = temp.link;
        }
        if (null == temp.link) {
            System.out.print(nodeValue + " does not exist in the list.");
        } else {
            node.link = temp.link;
            temp.link = node;
        }
    }

    public void insertAtPosition(int data, int position) {
        if(position <= 0) {
            System.out.print("Cannot insert at position : " + position);
            return;
        }
        if (null == start) {
            System.out.print("List is empty...");
            return;
        }
        SingleLinkedListNode node = new SingleLinkedListNode(data);
        if (position == 1) {
            node.link = start;
            start = node;
            return;
        }
        int i;
        SingleLinkedListNode temp = start;
        for (i = 1; i < position - 1 && null != temp.link; i++) {
            temp = temp.link;
        }
        if (null == temp.link) {
            System.out.print("You can only insert up to : " + i + " position.");
        } else {
            node.link = temp.link;
            temp.link = node;
        }
    }

    public void deleteFirst() {
        if (null == start) {
            System.out.print("List is empty...");
            return;
        }
        start = start.link;
    }

    public void deleteLast() {
        if (null == start) {
            System.out.print("List is empty...");
            return;
        }
        if (null == start.link) {
            start = null;
            return;
        }
        SingleLinkedListNode temp = start;
        while (null != temp.link.link) {
            temp = temp.link;
        }
        temp.link = null;
    }

    public void deleteSpecific(int nodeValue) {
        if (null == start) {
            System.out.print("List is empty...");
            return;
        }
        if (start.info == nodeValue) {
            start = start.link;
            return;
        }
        SingleLinkedListNode temp = start;
        while (null != temp.link) {
            if (temp.link.info == nodeValue) {
                break;
            }
            temp = temp.link;
        }
        if (null == temp.link) {
            System.out.print(nodeValue + " does not exist in the list.");
        } else {
            temp.link = temp.link.link;
        }
    }

    public void reverseList() {
        if (null == start) {
            System.out.print("List is empty...");
        }
        SingleLinkedListNode previous, current, next;
        previous = null;
        current = start;
        while (null != current) {
            next = current.link;
            current.link = previous;
            previous = current;
            current = next;
        }
        start = previous;
    }

    public void bubbleSortByData() {
        SingleLinkedListNode end, temp, nextTemp;

        for (end = null; end != start.link; end = temp) {
            for (temp = start; temp.link != end; temp = temp.link) {
                nextTemp = temp.link;
                if (temp.info > nextTemp.info) {
                    int aux = temp.info;
                    temp.info = nextTemp.info;
                    nextTemp.info = aux;
                }
            }
        }
    }

    public void bubbleSortByLinks() {
        SingleLinkedListNode end, temp, nextTemp, previousTemp, aux;

        for (end = null; end != start.link; end = temp) {
            for (previousTemp = temp = start; temp.link != end; previousTemp = temp, temp = temp.link) {
                nextTemp = temp.link;
                if (temp.info > nextTemp.info) {
                    temp.link = nextTemp.link;
                    nextTemp.link = temp;
                    if (temp != start) {
                        previousTemp.link = nextTemp;
                    } else {
                        start = nextTemp;
                    }
                    aux = temp;
                    temp = nextTemp;
                    nextTemp = aux;
                }
            }
        }
    }
}