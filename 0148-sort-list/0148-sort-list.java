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
        //return mergeSortRec(head);

        // Approch 3:
        //Apply Merge Sort  -- trying to optimise space:
        //Iterative approch we can save recursion stack call::
        return sortIter(head);
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
    // Approch 3::
    // Iterative Merge Sort LinkList::
    public static ListNode sortIter(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode cur = head;
        int len = length(head);
        ListNode left,right,dummy,tail;
        for(int i=1;i<len;i*=2){
            dummy =new ListNode(0);
            cur=head;
            tail =dummy;
            while(cur!=null){
                left =cur;
                right =split(left,i);
                cur =split(right,i);
                tail=mergenew(left,right,tail);
            }
            head=dummy.next;
        }
        return head;
    }
    public static int length(ListNode head){
        int len=0;
        while(head!=null){
            head=head.next;
            len++;
        }
        return len;
    }
    public static ListNode split(ListNode head,int n){
        for(int i=1;head!=null && i<n;i++){
            head=head.next;
        }
        if(head==null) return null;
        ListNode right =head.next;
        head.next=null;
        return right;
    }
    public static ListNode mergenew(ListNode l1, ListNode l2, ListNode head) {
        ListNode cur = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) cur.next = l1;
        if (l2 != null) cur.next = l2;
        while (cur.next != null) {
            cur = cur.next;
        }
        return cur;
    }

    
}