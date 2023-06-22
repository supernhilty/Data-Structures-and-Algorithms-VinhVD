package fptu.demo.binarysearchtree;

/**
 * Java program to demonstrate basic operations in a Binary Search Tree (BST)
 *
 * @author vinhvo
 */
import java.io.*;
import java.util.*;

class BinarySearchTree<E extends Comparable<E>> {

    //------------------- nested Node class -----------------------
    protected static class Node<E> {

        private E element;          // an element stored at this node
        //private Node<E> parent;   // a reference to the parent node (if any)
        private Node<E> left;       // a reference to the left child (if any)
        private Node<E> right;      // a reference to the right child (if any)

        /**
         * Constructors build a node with the given element and its children.
         *
         * @param e the real data that each node stores
         * @param leftChild left child of the current node
         * @param rightChild right child of the current node
         */
        public Node(E e, Node<E> leftChild, Node<E> rightChild) {
            this.element = e;
            //parent = above;
            this.left = leftChild;
            this.right = rightChild;
        }

        public Node(E e) {
            this.element = e;
            //parent = above;
            this.left = null;
            this.right = null;
        }

        // getter, setter methods
        public E getElement() {
            return this.element;
        }

        /*This method will be used later
        public Node<E> getParent() {
            return this.parent;
        }
         */
        public Node<E> getLeft() {
            return this.left;
        }

        public Node<E> getRight() {
            return this.right;
        }

        // update methods
        public void setElement(E e) {
            this.element = e;
        }

        /*This method will be used later
        public void setParent(Node<E> parentNode) {
            parent = parentNode;
        }
         */
        public void setLeft(Node<E> leftChild) {
            this.left = leftChild;
        }

        public void setRight(Node<E> rightChild) {
            this.right = rightChild;
        }
    } // --------------- end of nested Node class -----------------

    // Root of BST
    /**
     * Each object belongs to BST has one root node
     */
    private Node<E> root;

    public Node<E> getRoot() {
        return this.root;
    }

    // Constructor
    BinarySearchTree() {
        this.root = null;
    }

    BinarySearchTree(E e) {
        this.root = new Node<>(e);
    }

    public int getHeight(Node node) {
        return height(root);
    }

    private int height(Node<E> node) {
        if (node == null) {
            return 0;
        }
        if (root.left == null & root.right == null) {
            return 1;
        }
        return 1 + Math.max(height(node.left), height(node.getRight()));
    }

    public int getTotalNodes() {
        return totalNodes(root);
    }

    private int totalNodes(Node<E> node) {
        if (node == null) {
            return 0;
        }        
        return 1 + totalNodes(node.right) + totalNodes(node.left);
    }

    public boolean isBST() {
        return isBTS(root);
    }

    private boolean isBTS(Node<E> node) {
        if (node == null) {
            return true;
        }
        if (node.left != null && findMax(node.left).compareTo(node.element) > 0) {
            return false;
        }
        if (node.right != null && findMin(node.right).compareTo(node.element) < 0) {
            return false;
        }
        if (!isBTS(node.left) || !isBTS(node.right)) {
            return false;
        }

        return true;
    }

    public E findMin(Node<E> root) {
        if (root == null) {
            return null;
        }
        while (root.getLeft() != null) {
            root = root.getLeft();
        }
        return root.getElement();
    }

    public int getTotalLeaf() {
        return getTotalLeaf(root);
    }

    private int getTotalLeaf(Node<E> node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        return getTotalLeaf(node.left) + getTotalLeaf(node.right);
    }

//    public void clone(){
//        
//        
//    }
//    public void equal() {
//        
//    }
    /**
     * Insert a node into the binary search tree
     *
     * @param data data of type E that implements the Comparable interface
     * @return void
     */
    public void insert(E data) {
        this.root = insertRec(this.root, data);
    }

    /**
     * A recursive function to insert a new node with data (e) into BST
     *
     * @param root : the root of the current sub-tree
     * @param e: data field
     * @return root node of the tree after insertion
     */
    private Node<E> insertRec(Node<E> root, E data) {
        /* If the tree is empty, then return a new node */
        if (root == null) {
            return new Node<E>(data);
        } /**
         * If the value of the data being inserted is less than the value of the
         * current root node, then traverse to the left node of the current
         * root, and set the current left node to whatever gets returned from
         * the insert method
         */
        else if (data.compareTo(root.getElement()) < 0) {
            /**
             * Write your code here, it should be: root.left = insertRec(...,
             * ...);
             */
            root.left = insertRec(root.left, data);
        } /**
         * If the value of the data being inserted is less than the value of the
         * current root node,, then traverse to the right node of the current
         * root,, and set the current right node to whatever gets returned from
         * the insert method
         */
        else if (data.compareTo(root.getElement()) > 0) {
            /**
             * Write your code here, it should be: root.right = insertRec(...,
             * ...);
             */
            root.right = insertRec(root.right, data);
        } else {
            // This is emply to explicitly state that we do NOT 
            // allow insert duplicate values into the tree.
            ;
        }
        /* return the (unchanged) node pointer */
        return root;
    }

    /**
     * This method finds the maximum value in the tree
     *
     * @param root root node of the current subtree
     * @return maximum value in the tree
     */
    private E findMax(Node<E> root) {
        // We simply continue traversing to the right until we can't go any more, 
        // That means we have reached the largest element 
        if (root == null) {
            return null;
        }

        while (root.getRight() != null) {
            //Write your code here
            root = root.getRight();
        }

        return root.getElement();
    }

    /**
     * Returns true if the value is contained in the binary search tree, false
     * otherwise
     *
     * @param data: the value that's being searched for
     * @return boolean evaluation
     * @see boolean
     */
    public Node<E> contains(E data) {
        return contains(this.root, data);
    }

    private Node<E> contains(Node<E> root, E data) {
        // if the root is null, then either the BST is empty or 
        // the value has not been found and traversal cannot continue
        if (root == null) {
            return null;
        } // if the data being searched for is less than the value of the current root's data, 
        // then we check if the data exists in the current root's left sub-tree
        else if (data.compareTo(root.getElement()) < 0) {
            /**
             * Write your code here, it should be: contains(..., ...)
             */

            return contains(root.left, data);
        } // if the data being searched for is greater than the value of the current root's data, 
        // then we check if the data exists in the current root's right sub-tree
        else if (data.compareTo(root.getElement()) > 0) {
            /**
             * Write your code here, it should be: contains(abc,xyz)
             */
            return contains(root.right, data);
        } // if the data being searched for is equal to the value of the current root's data, then 
        // the search was successful and the method should return true
        else {
            return root;
        }
    }

    /**
     * DFS to print the values stored in the BST via in-Order traversal
     *
     * @param void
     * @return void
     */
    public void inorder() {
        System.out.print("In-order Traversal:");
        inorder(root);
        System.out.println();
    }

    // Sequence to be printed: Left, Node, Right
    // Traverses left as far as possible until a null node is reached, 
    // then prints the root node and 
    // then goes as far right as possible until a null node is reached. 
    private void inorder(Node<E> root) {
        if (root == null) {
            return;
        }

        inorder(root.getLeft());
        System.out.print(" " + root.getElement().toString());
        inorder(root.getRight());
    }

    /**
     * DFS to print the values stored in the BST via pre-Order traversal
     *
     * @param void
     * @return void
     */
    public void preorder() {
        //Write your code here
        System.out.print("Pre-order Traversal:");
        preorder(root);
        System.out.println();
    }

    // Sequence to be printed: Node, Left, Right
    // Prints the root node, then traverses left as far as possible until a null node is reached, 
    // then goes as far right as possible until a null node is reached.
    private void preorder(Node<E> root) {
        //Write your code here
        if (root == null) {
            return;
        }

        System.out.print(" " + root.getElement().toString());
        preorder(root.getLeft());
        preorder(root.getRight());

    }

    /**
     * DFS to print the values stored in the BST via post-Order traversal
     *
     * @param void
     * @return void
     */
    public void postorder() {
        //Write your code here
        System.out.print("Post-order Traversal:");
        postorder(root);
        System.out.println();
    }

    // Sequence to be printed: Left, Right, Node
    // Traverses left as far as possible until a null node is reached, 
    // then goes as far right as possible until a null node is reached,
    // and finally prints the root node.
    private void postorder(Node<E> root) {
        //Write your code here
        if (root == null) {
            return;
        }

        postorder(root.getLeft());
        postorder(root.getRight());
        System.out.print(" " + root.getElement().toString());

    }

    // Test the class's methods
//
//    public static void main(String[] args) {
//        /**
//         * NOTE that these code is just example feel free to modify for testing
//         * other methods
//         */
//        BinarySearchTree<Integer> i_tree = new BinarySearchTree<Integer>();
//
//        /* Let us build the BST as below
//                  5
//                /   \
//              3       9
//             /  \    /  \
//            2    4  6    10 
//           /         \
//          1           7
//         */
//        i_tree.insert(5);
//        i_tree.insert(3);
//        i_tree.insert(2);
//        i_tree.insert(4);
//        i_tree.insert(9);
//        i_tree.insert(6);
//        i_tree.insert(10);
//        i_tree.insert(1);
//        i_tree.insert(7);
//
//        // print inorder traversal of the BST
//        i_tree.inorder();
//
//        // print preorder traversal of the BST
//        i_tree.preorder();
//
//        // print postorder traversal of the BST
//        i_tree.postorder();
//        System.out.println("Maximum values in BST = " + i_tree.findMax(i_tree.getRoot()));
//        System.out.println(i_tree.findMin(i_tree.getRoot()));
//        System.out.println(i_tree.getHeight(i_tree.getRoot()));
//        System.out.println(i_tree.getTotalLeaf());
//        System.out.println(i_tree.getTotalNodes());
//        System.out.println(i_tree.isBST());
//        
//
//        BinarySearchTree<String> s_tree = new BinarySearchTree<String>();
//
//        /* 
//        Let us build the BST as below
//                  m
//                /   \
//              d       r
//             /  \    /  \
//            c    g  o    t 
//           /         \
//          b           q
//          
//         */
//        s_tree.insert("m");
//        s_tree.insert("d");
//        s_tree.insert("c");
//        s_tree.insert("b");
//        s_tree.insert("g");
//        s_tree.insert("r");
//        s_tree.insert("o");
//        s_tree.insert("t");
//        s_tree.insert("q");
//
//        // print inorder traversal of the BST
//        s_tree.inorder();
//
//        // print preorder traversal of the BST
//        s_tree.preorder();
//
//        // print postorder traversal of the BST
//        s_tree.postorder();
//        System.out.println("Maximum values in BST = " + s_tree.findMax(s_tree.getRoot()));
//    }
}
