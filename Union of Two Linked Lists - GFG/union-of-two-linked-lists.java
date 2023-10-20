//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node 
{
    int data;
    Node next;
    
    Node(int a)
        {
            data = a;
            next = null;
        }
}

class GfG
{
    static Scanner sc = new Scanner(System.in);
    
    public static Node inputList(int size)
    {
        Node head, tail;
        int val;
        
        val = sc.nextInt();
        
        head = tail = new Node(val);
        
        size--;
        
        while(size-->0)
        {
            val = sc.nextInt();
            tail.next = new Node(val);
            tail = tail.next;
        }
        
        return head;
    }
    
    public static void printList(Node n)
    {
        while(n!=null)
        {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }
    
    public static void main(String args[])
    {
        int t = sc.nextInt();
        while(t-->0)
        {
            int n , m;
            
            n = sc.nextInt();
            Node head1 = inputList(n);
            
            m = sc.nextInt();
            Node head2 = inputList(m);
            
            Sol obj = new Sol();
            
            printList(obj.findUnion(head1, head2));
            System.out.println();
        }
    }
}
// } Driver Code Ends


/*
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/

class Sol
{
	public static Node findUnion(Node head1,Node head2)
	{
	    //Approch 1. : Use set and traverse along it::
	    // TC : O(n+m)+O(n+m)
	    // SC: O(n+m) 
	    //Approch 2: Merge Sort Approch  ::
	    // TC : O((n+m)log(n+m))
	    // SC: O(lon(n+m))
	    
	    // Lets Now Implement the Optimal One ::
	    Node temp1=mergeSort(head1);
	    Node temp2=mergeSort(head2);
	    return merge(temp1,temp2);
	}
	public static Node mergeSort(Node head){
	    if(head==null || head.next==null) return head;
	    
	    ///--- Using two pointer to Find mid ---
	    Node slow =head;
	    Node fast =head;
	    Node prev=null;
	    while(fast!=null && fast.next!=null){
	        prev=slow;
	        slow=slow.next;
	        fast =fast.next.next;
	        
	    }
	    prev.next=null;
	    Node temp1=mergeSort(head);
	    Node temp2=mergeSort(slow);
	    Node fhead=merge(temp1,temp2);
	    return fhead;
	    
	}
	public static Node merge(Node temp1,Node temp2){
	    Node dummy =new Node(0);
	    Node temp =dummy;
	    while(temp1!=null && temp2!=null){
	        if(temp1.data<temp2.data){
	            temp.next =temp1;
	            temp1 =temp1.next;
	        }else if(temp1.data==temp2.data){
	            temp.next =temp1;
	            temp1 =temp1.next;
	            temp2 =temp2.next;
	        }
	        else{
	            temp.next=temp2;
	            temp2 =temp2.next;
	        }
	        temp=temp.next;
	    }
	    if(temp1!=null){
	        temp.next =temp1;
	    }
	    if(temp2!=null){
	        temp.next =temp2;
	    }
	    return dummy.next;
	}
}