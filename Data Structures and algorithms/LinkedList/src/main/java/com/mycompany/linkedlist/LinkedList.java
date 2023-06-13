/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.linkedlist;

/**
 *
 * @author hp i5
 */
public class LinkedList {

    Node head;

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public void printList() {
        String mylist = "";
        Node n = head;
        while (n != null) {
            mylist = mylist + n.data + "->";
            n = n.next;
        }
        mylist = mylist + "null";
        System.out.println(mylist);
    }

    public void addFirst(Node node) {
        node.next = head;
        head = node;
    }

    public void addLast(Node node) {
        if (head == null) {
            head = node;
        }
        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
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
        while(currentNode.next != null){
            if (currentNode.next == node){
                currentNode.next = node.next;
            }
            currentNode = currentNode.next;
        }
    }

    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.addFirst(new Node(5));
        l1.addFirst(new Node(4));
        l1.addFirst(new Node(3));
        l1.addFirst(new Node(2));
        l1.addFirst(new Node(1));
        Node six = new Node(6);
        Node ten = new Node(10);
        l1.addLast(six);
        l1.addLast(new Node(8));
        l1.addAfterNode(six, new Node(7));
        l1.addLast(ten);
        l1.addBeforeNode(ten, new Node(9));
        l1.remove(six);
        l1.printList();
    }
}
