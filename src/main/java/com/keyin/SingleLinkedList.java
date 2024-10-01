package com.keyin;

public class SingleLinkedList {
    // Node class to represent each element of the linked list
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Head of the linked list
    private Node head;

    // 0. Method to delete a node if the link doesn't exist
    public void delete(int value) {
        if (head == null) {
            System.out.println("The list is empty. No nodes to delete.");
            return;
        }

        // Search for the node to delete
        Node current = head;
        Node previous = null;

        while (current != null && current.data != value) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("The value " + value + " was not found in the list.");
        } else {
            if (previous == null) {
                // The node to delete is the head
                head = head.next;
            } else {
                previous.next = current.next;
            }
            System.out.println("Node with value " + value + " has been deleted.");
        }
    }

    // 1. Method to delete at the beginning
    public void deleteAtBeginning() {
        if (head == null) {
            System.out.println("The list is empty. Nothing to delete.");
            return;
        }
        head = head.next;
        System.out.println("The first node has been deleted.");
    }

    // 2. Method to delete at the end
    public void deleteAtEnd() {
        if (head == null) {
            System.out.println("The list is empty. Nothing to delete.");
            return;
        }

        if (head.next == null) {
            head = null;
            System.out.println("The last node has been deleted.");
            return;
        }

        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }

        current.next = null;
        System.out.println("The last node has been deleted.");
    }

    // 3. Method to delete anywhere in the list (given position)
    public void deleteAtPosition(int position) {
        if (position < 0) {
            System.out.println("Invalid position.");
            return;
        }

        if (head == null) {
            System.out.println("The list is empty. Nothing to delete.");
            return;
        }

        if (position == 0) {
            head = head.next;
            System.out.println("Node at position " + position + " has been deleted.");
            return;
        }

        Node current = head;
        Node previous = null;

        int index = 0;
        while (current != null && index != position) {
            previous = current;
            current = current.next;
            index++;
        }

        if (current == null) {
            System.out.println("The position " + position + " does not exist in the list.");
        } else {
            previous.next = current.next;
            System.out.println("Node at position " + position + " has been deleted.");
        }
    }

    // Method to add a new node at the end of the list (for testing)
    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Method to print the linked list
    public void printList() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Main method to test the linked list deletion methods
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();

        // Adding nodes to the list
        list.append(10);
        list.append(20);
        list.append(30);
        list.append(40);
        list.append(50);

        System.out.println("Original List:");
        list.printList();

        // Delete at the beginning
        list.deleteAtBeginning();
        System.out.println("After deleting at the beginning:");
        list.printList();

        // Delete at the end
        list.deleteAtEnd();
        System.out.println("After deleting at the end:");
        list.printList();

        // Delete at position 1
        list.deleteAtPosition(1);
        System.out.println("After deleting at position 1:");
        list.printList();

        // Delete a node with value (that may not exist)
        list.delete(100);
        list.delete(20);
        System.out.println("After deleting node with value 20:");
        list.printList();
    }
}
