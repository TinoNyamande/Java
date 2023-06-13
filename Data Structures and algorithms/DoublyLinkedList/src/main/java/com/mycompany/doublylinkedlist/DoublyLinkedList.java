/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.doublylinkedlist;

/**
 *
 * @author hp i5
 */
public class DoublyLinkedList {

    Node head;

    static class Node {

        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            next = null;
            prev = null;
        }
    }

    public void printList() {
        String list = "";
        Node currentNode = head;
        if (currentNode == null) {
            System.out.println("[]");
        } else {
            while (currentNode != null) {
                list = list + currentNode.data + "<->";
                currentNode = currentNode.next;
            }
            System.out.println(list + "null");
        }
    }

    public void addFirst(Node node) {
        if (head == null) {
            head = node;
        } else {
            head.prev = node;
            node.next = head;
            head = node;
        }
    }

    public void addLast(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = node;
            node.prev = currentNode;
        }
    }

    public void remove(Node node) {
        
        if (head.data == node.data) {
            head = head.next;
        }
    
        else {
            Node currentNode = head;
            while (currentNode.next != null) {
            if (currentNode.next.next == null) {
                this.removeLast();
                break;
            }
            else if (currentNode.next.data == node.data) {
                    currentNode.next = node.next;
                    node.next.prev = currentNode;
                    break;
                }
                currentNode = currentNode.next;

            }
        }
    }
    

    public void removeLast() {
        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        Node last = currentNode.prev;
        last.next = null;
    }

    public static void main(String[] args) {
        DoublyLinkedList l = new DoublyLinkedList();
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        l.addFirst(five);
        l.addFirst(four);
        l.addFirst(three);
        l.addFirst(two);
        l.addFirst(one);
        l.addLast(six);
        l.remove(six);
        l.printList();
    }
}
