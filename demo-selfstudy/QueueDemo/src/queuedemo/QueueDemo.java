/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuedemo;

/**
 *
 * @author leyen
 */
 class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
        
        
    }
    class Queue {
        Node head, tail;

        public Queue() {
        }
        
        void enqueue(int x) {
            Node node = new Node(x);
            if (isEmpty()) {
                head = tail = node;
            }
            tail.next = node;
            tail = node;
        }
        
        int dequeue() {
            Node deque = head;
            head.next = head;    
            return deque.data;
        }
        
        boolean isEmpty() {
            return head == null;
        }
        
        void clear() {
            while (head != null) {
                dequeue();
            }
        }
        
        int first() {
            return head.data;
        }
        
        void traverse() {
            while(head != null) {
                System.out.println(head.data + " -> ");
                head = head.next;
            }          
        }
        void convertRealNLessThan1ToBinary(double num) {
            double remainder = 1;
            int bit;
            if (num > 0 && num < 1) {
                while (remainder != 0) {
                    num = num * 2;
                    remainder = num % 1;
                    bit = (int)num / 1;
                    enqueue(bit);
                    num = remainder;
                }
            }
            while(head != null) {
                System.out.print(head.data);
                head = head.next;
            }   
            System.out.println("");
        }
    }
public class QueueDemo {
   
    public static void main(String[] args) {
        // TODO code application logic here
//        Queue q = new Queue();
//        
//        for (int i = 0; i < 100; i++) {
//            q.enqueue(i+1);
//        }
//        
//        q.traverse();
        Queue q2 = new Queue();
        q2.convertRealNLessThan1ToBinary(0.625);
    }
    
}
