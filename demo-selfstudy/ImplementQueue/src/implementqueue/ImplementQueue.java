/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementqueue;

import java.util.ArrayList;

/**
 *
 * @author leyen
 */
class MyQueue {

    ArrayList<Integer> Arr;

    public MyQueue() {
        Arr = new ArrayList<>();
    }

    public boolean isEmpty() {
        return Arr.isEmpty();
    }

    public void enqueue(int x) {
        Arr.add(x);
    }

    public int dequeue() {
        return Arr.remove(0);
    }

}

class CirArrQueue {

    int arr[];
    int front, rear;
    int numEle;

    public CirArrQueue(int size) {
        arr = new int[size];
        front = 0;
        rear = -1;
        numEle = 0;
    }

    boolean isEmpty() {
        return numEle == 0;
    }

    boolean isFull() {
        return numEle == arr.length;
    }

    void resetQueue() {
        front = 0;
        rear = -1;
    }

    public void enQueue(int x) {
        if (isFull()) {
            System.out.println("The queue is full");
            return;
        }       
        rear = (rear + 1) % arr.length;
        arr[rear] = x;
        System.out.println("Inserted: " + x);
        numEle++;
    }

    public int deQueue() {
        if (isEmpty()) {
            System.out.println("The queue is empty");
            return -1;
        }
        int frontEle = arr[front];
        front = (front + 1) % arr.length;
        numEle--;
        if (numEle == 0) {
            resetQueue();
        }
        return frontEle;
    }

    void display() {
        /* Function to display status of Circular Queue */
        int i;
        if (isEmpty()) {
            System.out.println("Empty Queue");
        } else {
            System.out.println("Front -> " + front);
            System.out.println("Items -> ");
            for (i = front; i != rear; i = (i + 1) % arr.length) {
                System.out.print(arr[i] + " ");
            }          
            System.out.println(arr[rear]);            
            System.out.println("Rear -> " + rear);
        }
    }
}

    public class ImplementQueue {

        /**
         * @param args the command line arguments
         */
        public static void main(String[] args) {
//            // TODO code application logic here
//            CirArrQueue q = new CirArrQueue(5);
//            // Fails because front = -1
//            q.deQueue();
//
//            q.enQueue(1);
//            q.enQueue(2);
//            q.enQueue(3);
//            q.enQueue(4);
//            q.enQueue(5);
//
//            // Fails to enqueue because front == 0 && rear == SIZE - 1
//            q.enQueue(6);
//
//            q.display();
//
//            int elem = q.deQueue();
//
//            if (elem != -1) {
//                System.out.println("Deleted Element is " + elem);
//            }
//            q.display();
//
//            q.enQueue(7);
//
//            q.display();
//
//            // Fails to enqueue because front == rear + 1
//            q.enQueue(8);
              

        }
        
       

    }
