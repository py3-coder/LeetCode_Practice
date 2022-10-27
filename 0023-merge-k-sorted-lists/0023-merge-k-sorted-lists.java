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
    public ListNode merge2(ListNode l1,ListNode l2){
        ListNode fake = new ListNode(Integer.MIN_VALUE);
        ListNode tail = fake;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                tail.next =l1;
                l1 =l1.next;
            }
            else{
                tail.next =l2;
                l2 =l2.next;
            }
            tail =tail.next;
        }
        tail.next = (l1!=null)?l1:l2;
        
        return fake.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length==0) return null;
        ListNode dummy= new ListNode(Integer.MIN_VALUE);
        ListNode m1 =dummy;
        for(int i=0;i<lists.length;i++){
             m1 = merge2(m1,lists[i]);
        }
        return dummy.next;
    }
}