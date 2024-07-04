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
    public ListNode mergeNodes(ListNode head) {
        
        ListNode temp =  head ;
        ListNode curr = head.next;
        int sum =0;
        while(curr!=null){
            while(curr.val!=0){
                sum+=curr.val;
                curr = curr.next;
            }
            head.next = new ListNode(sum);
            head = head.next ;
            curr = curr.next;
            sum =0;
        }
        return temp.next;
    }
}