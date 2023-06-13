/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.circularlinkedlist;

/**
 *
 * @author hp i5
 */
public class CircularLinkedList {

    Node head;

    static class Node {

        int data;
        Node next;
        Node prev;

        Node(int d) {
            data = d;
            next = null;
            prev = null;
        }
    }

    public void printList() {
        String mylist = "";
        Node n = head;
        while (n != null) {
            mylist = mylist + n.data + "->";
            n = n.next;
        }
        System.out.println(mylist);
    }

    public void addFirst(Node node) {
        Node currentNode = head;
        node.next = head;
        head = node;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = head;
    }

    public void addLast(Node node) {
        if (head == null) {
            head = node;
        }
        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        head.prev = node;
        currentNode.next = node;
    }

    public void addAfterNode(Node target, Node node) {
        Node currentNode = head;
        if (head == null) {
            System.out.println("List is empty");
        } else {
            while (currentNode.next != null) {
                if (currentNode == target) {
                    node.next = currentNode.next;
                    currentNode.next = node;
                    break;
                }
                currentNode = currentNode.next;
            }
        }
    }

    public void addBeforeNode(Node target, Node node) {
        Node prevNode = head;
        if (head == null) {
            System.out.println("List is empty");
        }
        if (head.data == target.data) {
            this.addFirst(node);
        } else {
            while (prevNode.next != null) {
                if (prevNode.next == target) {
                    //node.next = currentNode.next;
                    //currentNode.next = node;
                    node.next = prevNode.next;
                    prevNode.next = node;
                    break;
                }
                prevNode = prevNode.next;
            }
        }
    }

    public void remove(Node node) {
        if (head == null) {
            System.out.println("List is empty");
        }
        if (head.data == node.data) {
            head = head.next;

        }
        Node currentNode = head;
        while (currentNode.next != null) {
            if (currentNode.next == node) {
                currentNode.next = node.next;
            }
            currentNode = currentNode.next;
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
