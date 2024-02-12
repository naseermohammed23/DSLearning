package Tawheed2024.Blind75;

import java.util.Stack;

public class ReverseLinkedList {
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        ListNode reverseHead = reverseList(head);
    }

    public static ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) 
            return head;
        
        Stack<ListNode> stack = new Stack<>();
        while(head.next != null) {
            stack.push(head);
            head = head.next;
        }

        ListNode root = head;
        while(!stack.isEmpty()) {
            ListNode node = stack.pop();
            head.next = node;
            head = node;
        }

        head.next = null;

        return root;
    }

    /* Another way of doing the same problem , this is with recurrsion
    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) 
            return head;
        
        ListNode pNode = null;
        ListNode cNode = head;
        ListNode xNode = null;

        return reverseList(pNode, cNode, xNode);
    }

    ListNode reverseList(ListNode pNode, ListNode cNode, ListNode xNode) {
        if (cNode == null) 
            return pNode;
        
        xNode = cNode.next;
        cNode.next = pNode;
        pNode = cNode;
        cNode = xNode;

        return reverseList(pNode, cNode, xNode);
    } */
}
