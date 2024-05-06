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
    public ListNode removeNodes(ListNode head) {
        if(head==null || head.next==null) return head;
        
        ListNode revhead = reverse(head);
        head = deleteNode(revhead);
        return reverse(head);
        
    }
    public ListNode deleteNode(ListNode revhead){
        ListNode curr = revhead;
        ListNode next =revhead.next;
        int val = revhead.val;
        while(next!=null){
            int nextval = next.val;
            if(val>nextval && next.next!=null){
                curr.next = next.next;
                next.next =null;
                next = curr.next;
            }
            
            if(val>nextval && next.next==null){
                curr.next = null;
                 next = curr.next;
            }
            
            if(val<=nextval){
                val = Math.max(val,nextval);
                curr = next;
                next = next.next;
            }
        }
        return revhead;

    }
    public ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev=null;
        ListNode next;
        
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        if(prev.next!=null){
            head = prev;
        }
        return head;
    }
}