/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singlylinkedlist;

/**
 *
 * @author leyen
 */
class Node {

    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return data + "";
    }

}

class RefNODE {

    Node node;

    public RefNODE(Node node) {
        this.node = node;
    }
}

class LinkedList {

    Node Head;
    Node Tail;

    public LinkedList() {
        this.Head = this.Tail = null;
    }

    public LinkedList(int a[]) {
        this.Head = this.Tail = null;
        for (int x : a) {
            addToTail(x);
        }
    }

    public boolean isEmpty() {
        return this.Head == null;
    }

    public void insertAfter(Node new_ele, Node pred) {
        if (pred == null) {
            new_ele.next = Head;
            Head = new_ele;
        } else {
            new_ele.next = pred.next;
            pred.next = new_ele;
        }
        if (pred == Tail) {
            Tail = new_ele;
        }
    }

    public void addToTail(int x) {
        insertAfter(new Node(x), Tail);
    }

    public void addToHead(int x) {
        insertAfter(new Node(x), null);
    }

    @Override
    public String toString() {
        String s = "";
        for (Node t = Head; t != null; t = t.next) {
            s += (t + " ");
        }
        return s;
    }

    public boolean isAscendingSorted() {
        Node t = Head;
        while (t.next != null) {
            if (t.data > t.next.data) {
                return false;
            }
            t = t.next;
        }
        return true;
    }

    public void reverse() {
        Node tmp = Head.next;
        Tail = Head.next = null;
        while (tmp != null) {
            Node nextTmp = tmp.next; //giữ lại sau thằng tmp
            insertAfter(tmp, null);
            tmp = nextTmp;
        }
    }

    public Node search(int x, RefNODE pred) {
        Node curr = Head;
        //pred.node = null;
        while (curr != null && curr.data != x) {
            pred.node = curr;
            curr = curr.next;
        }
        return curr;
    }

    void removeAfter(Node pred) {
        Node tmp; //nút cần xóa
        if (pred != null) {
            tmp = pred.next;
            pred.next = tmp.next;
        } else { //xóa nút đầu
            tmp = Head;
            Head = tmp.next;
        }
        if (tmp == Tail) {
            Tail = pred;
        }
    }

    public void deleteHead() {
        removeAfter(null);
    }

    public void deleteTail() {
        if (isEmpty()) {
            return;
        }
        RefNODE pred = new RefNODE(null);
        search(Tail.data, pred);
        removeAfter(pred.node);
    }

    public void deleteItem(int x) {
        RefNODE pred = new RefNODE(null);
        Node pos = search(x, pred);
        if (pos != null) {
            removeAfter(pred.node);
        }
    }

    public void deleteItemAfter(int x) {
        RefNODE pred = new RefNODE(null);
        Node pos = search(x, pred);
        if (pos.next != null) {
            removeAfter(pos);
        }

    }

    public void insertSort() {
        Node curr = Head.next;
        Tail = Head.next = null;
        while (curr != null) {
            Node nextTmp = curr.next; //giữ lại sau thằng tmp
            
            //tim nut dau tien tu trai sao cho
            //co du lieu lon hon curr.data
            Node pos = Head;
            RefNODE pred = new RefNODE(null); //pred.node = null;
            while (pos != null && curr.data < pos.data) {
                pred.node = pos;
                pos = pos.next;
            }
            insertAfter(curr, pred.node);
            curr = nextTmp;
        }
        
    }
    public void addFirst1(int x) {
        Node node = new Node(x);
        if (isEmpty()){
            Head = Tail = node;
        } else {            
            node.next = Head;
            Head = node;
        }
            
    }
    
    public void addLast1(int x) {
        Node node = new Node(x);
        if (isEmpty()){
            Head = Tail = node;
        } else {            
            Tail.next = node;
            Tail = node;
        }
    }
}

public class SinglyLinkedList {

    public static void main(String[] args) {
        // TODO code application logic here
        LinkedList L = new LinkedList();
        L.addToTail(6);
        L.addToTail(3);
        L.addToTail(4);
        L.addToTail(1);
        //System.out.println(L);
        L.addToHead(2);
        System.out.println(L);
        LinkedList L2 = new LinkedList(new int[]{1, 5, 3});
        // System.out.println(L2);
        if (L.isAscendingSorted()) {
            System.out.println("Sorted");
        } else {
            System.out.println("Unsorted");
        }
        L.reverse();
        System.out.println(L);
        RefNODE pred = new RefNODE(null);
        Node pos = L.search(5, pred);
        if (pos == null) {
            System.out.println("Not found");
        } else if (pred.node == null) {
            System.out.println("Found at head");
        } else {
            System.out.println("The predecessor is " + pred.node);
        }
        L.deleteItem(3);
        System.out.println(L);
        L.deleteItemAfter(2);
        
        System.out.println(L.Tail);
    }

}
