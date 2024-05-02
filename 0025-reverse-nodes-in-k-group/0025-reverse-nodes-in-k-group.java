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
    public ListNode reverseKGroup(ListNode head, int k) {
        // Lets Apply Our Brains ::
        if(head==null || head.next==null){
            return head;
        }
        ListNode curr1 =head;
        for(int i=0;i<k;i++){
            if(curr1==null){
                return head;
            }
            curr1 =curr1.next;
        }
        ListNode curr=head ,prev =null ,temp=null;
        int cnt=0;
        while(curr!=null && cnt<k){
            temp=curr.next;
            curr.next=prev;
            prev =curr ;
            curr=temp;
            cnt++;
        }
        if(temp!=null){
            head.next =reverseKGroup(temp,k);
        }
        return prev;
        
    }
}