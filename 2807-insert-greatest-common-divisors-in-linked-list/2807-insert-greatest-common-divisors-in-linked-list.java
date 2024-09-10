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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head== null || head.next==null){
            return head ;
        }
        ListNode curr =head;
        ListNode next =head.next;
        while(next!=null){
            int val = gcd(curr.val , next.val);
            ListNode temp = new ListNode(val);
            curr.next = temp ;
            temp.next = next;
            
            curr = next ;
            next = next.next;
        }
        return head;
    }
    public int gcd(int a ,int b){
        while(b!=0){
            if(a>b){
                a-=b;
            }else{
                b-=a;
            }
        }
        return a;
    }
}
