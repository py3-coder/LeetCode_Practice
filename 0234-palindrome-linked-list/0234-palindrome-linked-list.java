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
    public ListNode reverse(ListNode head){
        ListNode curr= head, prev = null ,next;
        while(curr !=null){
            next = curr.next;
            curr.next =prev;
            prev = curr;
            curr = next;
        }
        head=prev;
        return head;
    }
    public boolean isPalindrome(ListNode head) {
     ListNode slow = head;
     ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast != null){
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = head;
        while(slow!=null){
            if(fast.val !=slow.val)
            return false;
        
        fast = fast.next;
        slow = slow.next;
        }
        return true;
    }
}