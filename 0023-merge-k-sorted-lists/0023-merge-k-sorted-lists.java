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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minheap= new PriorityQueue<ListNode>((a,b)->(a.val-b.val));
        for(ListNode list:lists){
            if(list!=null)
            minheap.add(list);
        }
        ListNode head=null;
        ListNode tail=null;
        while(!minheap.isEmpty()){
            ListNode p =minheap.poll();
            if(head==null){
                head=p;
                tail=p;
            }else{
                tail.next=p;
                tail=p;
            }
            if(p.next!=null){
                minheap.add(p.next);
            }
        }
        return head;
        
    }
    
}