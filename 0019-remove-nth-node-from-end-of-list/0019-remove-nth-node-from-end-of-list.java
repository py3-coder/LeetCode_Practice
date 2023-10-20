/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 1. Approch :: find len and find len-k:
        // traverse form head to len-k-1 :: update the pointer:
        // TC : O(n) +O(n-len-1)
        // SC : O(1)


        // 2. Approch Gap Method ::
        // take two pointer create k node gap::
        /// when first reach at last then sec must be at before k node at back:


        //Gap type concept let make fast k node ahead from start .. that we will mentain till last::
        ListNode start = new ListNode();
        start.next = head;
        ListNode fast =start;
        ListNode slow=start;

        for(int i=0;i<n;i++){
            fast =fast.next;
        }
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next =slow.next.next;
        return start.next;
    }
}