package Tawheed2024.Blind75;

public class MergeKLists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }  
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1, new ListNode(2));
        ListNode n2 = new ListNode(3, new ListNode(4));
        ListNode n3 = new ListNode(5, new ListNode(6));

        ListNode mergeNode = mergeKLists(new ListNode[]{n1, n2, n3});
    }
    
    public static ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists1(lists, lists.length-1);
    }

    public static ListNode mergeKLists1(ListNode[] lists, int idx) {
        if (idx >= 0)
            return mergeTwoLists(lists[idx], mergeKLists1(lists, --idx));
        else 
            return lists[0];
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if(list1 != null && list2 !=null) {
            if (list1.val < list2.val) {
                list1.next = mergeTwoLists(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeTwoLists(list1, list2.next);
                return list2;
            }
        }

        if (list1 == null)
            return list2;
        return list1;   
    }
}
