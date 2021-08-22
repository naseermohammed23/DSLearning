package Educative;

/**
 * LinkedList Cycle detection.. 
 */

public class LinkedListCycle {
    

    static class Node {

        Node next;
        int value;

        public Node(int val) {
            this.value = val;
        }

        public void add(Node node) {
            this.next = node;
        }

    }


    public static void main(String[] args) {
        
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);


        head.add(node2);
        node2.add(node3);
        node3.add(node4);
        node4.add(node5);
        node5.add(node6);
        node6.add(node3);
        
        detectCycle(head);
    }

    /**
     * Helper method to detect cycle in linked list.. 
     */
    private static void detectCycle(Node head) {

       Node slow = head;
       Node fast = head;

       while (fast != null && fast.next != null) {
        
           fast = fast.next.next;
           slow = slow.next;
           
        
           if (slow == fast) {
                System.out.println("Cycle exist");
                break;
           }
           
       }        
    }
}
