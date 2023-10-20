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
    public ListNode sortList(ListNode head) {
        //Apprcoh 1
        // Traverse the linklist till last and put into list sort it and create head pointer append new node
        // till it have data::
        // TC : O(n)+O(nlogn)+O(n)
        //SC : O(n) +O(n) ~ (if we talk of n new pointer we need as O(1) for each nd for n we need O(n) i.e
       // return sort(head);

        //Approch 2:
        //Apply Merge Sort - Best Sorting Algo
        // TC : O(nlogn)
        // SC : O(logn)
        return mergeSortRec(head);
        
        
    }
    public ListNode sort(ListNode head){
        ListNode temp = head;
        ArrayList<Integer> lis = new ArrayList<>();
        while(temp!=null){
            lis.add(temp.val);
            temp=temp.next;
        }
        temp=head;
        Collections.sort(lis);
        for(int val:lis){
            temp.val =val;
            temp=temp.next;
        }
        return head;
    }
    //2. Approch ::
    public static ListNode mergeSortRec(ListNode head){
        // Base Case:
        if(head==null || head.next==null) return head;

        ListNode slow=head;
        ListNode prev=null;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        prev.next =null;

        ListNode part1 =mergeSortRec(head);
        ListNode part2 =mergeSortRec(slow);
        return merge(part1,part2);

    }
    public static ListNode merge(ListNode temp1,ListNode temp2){
        ListNode dummy =new ListNode(0);
        ListNode temp =dummy;

        while(temp1!=null && temp2!=null){
            if(temp1.val<temp2.val){
                temp.next =temp1;
                temp1 =temp1.next;
            }else{
                temp.next =temp2;
                temp2 =temp2.next;
            }
            temp=temp.next;
        }
        if(temp1!=null){
            temp.next=temp1;
        }
        if(temp2!=null){
            temp.next=temp2;
        }
        return dummy.next;
    }
    
}