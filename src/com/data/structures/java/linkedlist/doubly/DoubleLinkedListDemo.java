package com.data.structures.java.linkedlist.doubly;

import java.util.Scanner;

public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        int choice, data;
        Scanner scanner = new Scanner(System.in);
        DoubleLinkedList list = new DoubleLinkedList();
        list.createList();

        while (true) {
            System.out.println();
            System.out.println("1. Display List.");
            System.out.println("2. Insert at the beginning.");
            System.out.println("3. Insert at the end.");
            System.out.println("4. Insert after specific node.");
            System.out.println("5. Insert before specific node.");
            System.out.println("6. Insert in empty list.");
            System.out.println("7. Delete first node.");
            System.out.println("8. Delete last node.");
            System.out.println("9. Delete specific node.");
            System.out.println("10. Reverse List.");
            System.out.println("11. Quit.");

            System.out.print("Enter you choice : ");
            choice = scanner.nextInt();

            if (choice == 11) {
                break;
            }

            switch (choice) {
                case 1:
                    list.displayList();
                    break;
                case 2 :
                    System.out.print("Enter the element to be inserted : ");
                    data = scanner.nextInt();
                    list.insertAtBeginning(data);
                    break;
            }
            System.out.println();
        }
        scanner.close();
        System.out.println("Exiting...");
    }
}
