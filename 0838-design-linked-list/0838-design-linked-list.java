class MyLinkedList {
    Node head;
    int len;
    public MyLinkedList() {
        head = new Node();
        len=0;
    }
    public int get(int index) {
        //index is greater than length not valid:
        if(index>=len){
            return -1;
        }
        //
        Node dummy =head;
        for(int i=0;i<=index;i++){
            dummy=dummy.next;
        }
        return dummy.val;
    }
    
    public void addAtHead(int val) {
        Node temp =new Node(val);
        temp.next =head.next;
        head.next =temp;
        len++;
        
    }
    public void addAtTail(int val) {
        Node temp = new Node(val);
        Node dummy =head;
        for(int i=0;i<len;i++){
            dummy=dummy.next;
        }
        dummy.next =temp;
        len++;
    }
    public void addAtIndex(int index, int val) {
        if(index>len) return;
        Node node = new Node(val);
        Node currNode =head;
        for(int i=0;i<index;i++){
            currNode =currNode.next;
        }
        node.next =currNode.next;
        currNode.next=node;
        len++;
        
    }
    public void deleteAtIndex(int index) {
        if(index>=len) return;
        Node currNode =head;
        for(int i=0;i<index;i++){
            currNode =currNode.next;
        }
        currNode.next =currNode.next.next;
        len--;
    }
    class Node{
        int val;
        Node next;

        Node(int _val){
            this.val=_val;
            this.next=null;
        }
        Node(){
            this.val=0;
            this.next=null;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */