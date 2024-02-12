package Tawheed2024.Blind75;

public class MiddleNode {
    

    public ListNode middleNode(ListNode head) {
        
        if (head == null || head.next == null) return head;

        ListNode currNode = head;

        int count = 0;

        while (currNode != null) {
            count++;
            currNode = currNode.next;
        }

        int mid = count / 2 + 1;
        ListNode midNode = null;

        for (int i=1;i<=mid;i++) {
            if (i == mid) {
                midNode = head;
                break;
            }

            head = head.next;
        } 

        return head;
    }
}
