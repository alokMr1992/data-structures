package com.data.structures.java.linkedlist.single;

import java.util.Scanner;

public class SingleLinkedListDemo {

    public static void main(String[] args) {
        int choice, data, element, position;
        Scanner scanner = new Scanner(System.in);
        SingleLinkedList list = new SingleLinkedList();
        list.createList();

        while (true) {
            System.out.println();
            System.out.println("1. Display List.");
            System.out.println("2. Count the nodes.");
            System.out.println("3. Search for an element.");
            System.out.println("4. Insert at the beginning.");
            System.out.println("5. Insert at the end.");
            System.out.println("6. Insert after specific node.");
            System.out.println("7. Insert before specific node.");
            System.out.println("8. Insert at specific position.");
            System.out.println("9. Delete first node.");
            System.out.println("10. Delete last node.");
            System.out.println("11. Delete specific node.");
            System.out.println("12. Reverse List.");
            System.out.println("13. Bubble sort by exchanging data.");
            System.out.println("14. Bubble sort by exchanging links.");
            System.out.println("15. Quit.");

            System.out.print("Enter you choice : ");
            choice = scanner.nextInt();

            if (choice == 15) {
                break;
            }

            switch (choice) {
                case 1 :
                    list.displayList();
                    break;
                case 2 :
                    int count = list.countNodes();
                    System.out.print("Node count is : " + count);
                    break;
                case 3 :
                    System.out.print("Enter the element to be searched : ");
                    element = scanner.nextInt();
                    position = list.search(element);
                    System.out.print(element + " found at position " + position);
                    break;
                case 4 :
                    System.out.print("Enter the element to be inserted : ");
                    data = scanner.nextInt();
                    list.insertAtBeginning(data);
                    break;
                case 5 :
                    System.out.print("Enter the element to be inserted : ");
                    data = scanner.nextInt();
                    list.insertAtEnd(data);
                    break;
                case 6 :
                    System.out.print("Enter the element to be inserted : ");
                    data = scanner.nextInt();
                    System.out.print("Enter the element after which new node has to be inserted : ");
                    element = scanner.nextInt();
                    list.insertAfter(data, element);
                    break;
                case 7 :
                    System.out.print("Enter the element to be inserted : ");
                    data = scanner.nextInt();
                    System.out.print("Enter the element before which new node has to be inserted : ");
                    element = scanner.nextInt();
                    list.insertBefore(data, element);
                    break;
                case 8 :
                    System.out.print("Enter the element to be inserted : ");
                    data = scanner.nextInt();
                    System.out.print("Enter the position at which new node has to be inserted : ");
                    position = scanner.nextInt();
                    list.insertAtPosition(data, position);
                    break;
                case 9 :
                    list.deleteFirst();
                    break;
                case 10 :
                    list.deleteLast();
                    break;
                case 11 :
                    System.out.print("Enter the element to be deleted : ");
                    element = scanner.nextInt();
                    list.deleteSpecific(element);
                    break;
                case 12 :
                    list.reverseList();
                    break;
                case 13 :
                    list.bubbleSortByData();
                    break;
                case 14 :
                    list.bubbleSortByLinks();
                    break;
                default :
                    System.out.println("Wrong choice.");
            }
            System.out.println();
        }
        scanner.close();
        System.out.println("Exiting...");
    }
}