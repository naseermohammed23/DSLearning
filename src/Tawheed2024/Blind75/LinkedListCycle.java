package Tawheed2024.Blind75;

import java.util.HashMap;

public class LinkedListCycle {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }  
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(1));
        head.next.next = head;

        System.out.println(hasCycle(head));
    }

    static HashMap<Integer, Integer> map = new HashMap<>();

    public static boolean hasCycle(ListNode head) {
        
        if (head == null || head.next == null)
            return false;
        
        Integer nodeHashCode = map.get(head.val+head.hashCode());
        if ( nodeHashCode != null) {
            if (nodeHashCode == head.hashCode())
                return true;
        }
        
        map.put(head.val+head.hashCode(), head.hashCode());

        return hasCycle(head.next);

    }
    
}
