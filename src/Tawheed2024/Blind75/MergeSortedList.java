package Tawheed2024.Blind75;

import java.util.HashMap;

public class MergeSortedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }  
    }

    public static void main(String[] args) {
        ListPrint();
    }

    public static void ListPrint() {
        ListNode n = new ListNode(12);
        ListNode n1 = new ListNode(12);

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(12, n.hashCode());
        Integer i = map.get(12);

        if (i != null)
            System.out.println(i + " " +n1.hashCode() + " " + n.hashCode());

        
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode result = null;
        return mergeTwoLists(list1, list2, result);
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2, ListNode result) {
        ListNode temp = null;
        if (list1.val < list2.val) {
            temp = new ListNode(list1.val, new ListNode(list2.val));                
        } else {
            temp = new ListNode(list2.val, new ListNode(list1.val));
        }

        if (result == null) {
            result = temp;
        } else {
            result.next = temp;
        }

        return mergeTwoLists(list1.next, list2.next, result);

    }
}
