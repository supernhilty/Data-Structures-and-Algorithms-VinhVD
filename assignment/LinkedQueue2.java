/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fptu.demo.listvariance;

/**
 *
 * @author vinhvo
 */
/**
 * Realization of a FIFO queue as an adaptation of a SinglyLinkedList.
 */
public class LinkedQueue2<E extends Comparable<E>> implements Queue<E> {

    private SinglyLinkedList<E> list = new SinglyLinkedList<>();
    private Node<E> rear, front;

    @Override
    public int size() {
        // write your code here
        if (!isEmpty()) {
            return list.size();
        }
        return 0;
    }

    @Override
    public boolean isEmpty() {
        // write your code here
        if (!list.isEmpty()) {
            return false;
        }
        return true;
    }

    @Override
    public void enqueue(E e) {
        // write your code here
        list.addLast(e);
    }

    @Override
    public E first() {
        // write your code here
        if (!isEmpty()) {
            return list.getFirst();
        }
        return null;
    }

    @Override
    public E dequeue() {
        // write your code here
        if (!isEmpty()) {
            return list.removeFirst();
        }
        return null;
    }

    @Override
    public void reverse() {
        // write your code here
       if (!isEmpty()) {
            SinglyLinkedList<E> reverseList = new SinglyLinkedList<>();

            while (first() != null) {
                reverseList.addFirst(dequeue());
            }
            list = reverseList;
        }

    }

    
}
