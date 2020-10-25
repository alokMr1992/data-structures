package com.data.structures.java.linkedlist.doubly;

public class DoubleLinkedListNode {

    public DoubleLinkedListNode prev;
    public int info;
    public DoubleLinkedListNode next;

    public DoubleLinkedListNode(int info) {
        this.info = info;
        this.prev = null;
        this.next = null;
    }
}