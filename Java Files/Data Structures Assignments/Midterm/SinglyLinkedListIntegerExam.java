
/* 
    "I understand the ground rules and agree to abide by them. 
    I will not share code or assist another student during this exam, 
    nor will I seek assistance from another person or attempt to view their code."
*/


public class SinglyLinkedListIntegerExam
{
    //---------------- nested Node class ----------------
    /**
    * Node of a singly linked list, which stores a reference to its
    * element and to the subsequent node in the list (or null if this
    * is the last node).
    */
    private static class Node {
        /** The element stored at this node */
        private Integer element; // reference to the element stored at this node
        /** A reference to the subsequent node in the list */
        private Node next; // reference to the subsequent node in the list
        /**
        * Creates a node with the given element and next node.
        *
        * @param e the element to be stored
        * @param n reference to a node that should follow the new node
        */
        public Node(Integer e, Node n) {
            element = e;
            next = n;
        }
        // Accessor methods
        /**
        * Returns the element stored at the node.
        * @return the element stored at the node
        */
        public Integer getElement() { return element; }
        /**
        * Returns the node that follows this one (or null if no such node).
        * @return the following node
        */

        public Node getNext() { return next; }
        // Modifier methods
        /**
        * Sets the node's next reference to point to Node n.
        * @param n the node that should follow this one
        */
        public void setNext(Node n) { next = n; }
    } //----------- end of nested Node class -----------
    // instance variables of the SinglyLinkedListInteger
    /** The head node of the list */


    private Node head = null; // head node of the list (or null if empty)
    /** The last node of the list */


    private Node tail = null; // last node of the list (or null if empty)
    /** Number of nodes in the list */


    private int size = 0; // number of nodes in the list
    /** Constructs an initially empty list. */


    public SinglyLinkedListIntegerExam() { } // constructs an initially empty list
    // access methods
    /**
    * Returns the number of elements in the linked list.
    * @return number of elements in the linked list
    */

    public int countEvens()
    {
        int count = 0; 
        int i = head.getElement(); 
        

        while (count <= size())
        {
            if (i % 2 == 0)
            {
                count ++;
                 
            }
            i = head.next.element; 
        }
        System.out.println(count); 

        return count ; 
    }

    public int size() { 
    
        if (head == null)
        {
            return 0; 
        }
        
        return size() + 1; 
    }
    /**
    * Tests whether the linked list is empty.
    * @return true if the linked list is empty, false otherwise
    */


    public boolean isEmpty() { 
        if (size() == 0)
        {
            return false;
        } 
        
        return true; 
     }
    /**
    * Returns (but does not remove) the first element of the list
    * @return element at the front of the list (or null if empty)
    */


    public Integer first() { // returns (but does not remove) the first element
    if (isEmpty()) return null;
    return head.getElement();
    }


    /**
    * Returns (but does not remove) the last element of the list.
    * @return element at the end of the list (or null if empty)
    */


    public Integer last() { // returns (but does not remove) the last element
    if (isEmpty()) return null;
    return tail.getElement();
    }



    public static void main (String[] args)
    {
        Node nOne = new Node(43, null);
        Node nTwo = new Node(44, null);
        Node nThree = new Node(45, null); 
        Node nFour = new Node(46, null);
        Node nFive = new Node(47, null);

        SinglyLinkedListIntegerExam s = new SinglyLinkedListIntegerExam(); 

        s.countEvens(); 

        nOne = new Node(43, nTwo);
        nTwo = new Node(44, nThree);
        nThree = new Node(45, nFour); 
        nFour = new Node(46, nFive);
        nFive = new Node(47, null);
    }
}