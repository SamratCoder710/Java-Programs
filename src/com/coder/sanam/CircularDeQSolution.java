package com.coder.sanam;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

public class CircularDeQSolution {

    static class Node{
        int data;
        Node prevNode;
        Node nextNode;

        public Node(int data){
            this.data = data;
            this.prevNode = null;
            this.nextNode = null;
        }
    }

    static class MyCircularDeque {
        int size;
        int capacity;
        Node head;
        Node tail;

        public MyCircularDeque(int k) {
           this.size = 0;
           this.capacity = k;
           this.head = null;
           this.tail = null;
        }

        public boolean insertFront(int value) {
            if(isFull()) return false;
            Node newNode = new Node(value);
            if(isEmpty()){
                head = newNode;
                tail = newNode;
                head.nextNode = head;
                head.prevNode = head;
            }else{
                newNode.nextNode = head;
                newNode.prevNode = tail;
                head.prevNode = newNode;
                tail.nextNode = newNode;
                head = newNode;
            }
            size++;
            return true;
        }

        public boolean insertLast(int value) {
            if(isFull()) return false;
            Node newNode = new Node(value);
            if(isEmpty()){
                head = newNode;
                tail = newNode;
                head.nextNode = head;
                head.prevNode = head;
            }else{
                newNode.prevNode = tail;
                newNode.nextNode = head;
                tail.nextNode = newNode;
                head.prevNode = newNode;
                tail = newNode;
            }
            size++;
            return true;
        }

        public boolean deleteFront() {
            if(isEmpty()) return false;

            if (size == 1) {
                head = null;
                tail = null;
            } else {
                head = head.nextNode;
                head.prevNode = tail;
                tail.nextNode = head;
            }
            size--;
            return true;
        }

        public boolean deleteLast() {
            if(isEmpty()) return false;

            if (size == 1) {
                head = null;
                tail = null;
            } else {
                tail = tail.prevNode;
                tail.nextNode = head;
                head.prevNode = tail;
            }

            size--;
            return true;
        }

        public int getFront() {
            if(isEmpty()) return -1;
            return head.data;
        }

        public int getRear() {
            if(isEmpty()) return -1;
            return tail.data;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == capacity;
        }
    }

    public static void main(String[] args) {
        MyCircularDeque myCircularDeque = new MyCircularDeque(3);
        myCircularDeque.insertLast(1);  // return True
        myCircularDeque.insertLast(2);  // return True
        myCircularDeque.insertFront(3); // return True
        myCircularDeque.insertFront(4); // return False, the queue is full.
        myCircularDeque.getRear();      // return 2
        myCircularDeque.isFull();       // return True
        myCircularDeque.deleteLast();   // return True
        myCircularDeque.insertFront(4); // return True
        myCircularDeque.getFront();     // return 4

    }
}
