public class AllOne {
    class valueNode {
        valueNode preNode;             
        valueNode nextNode;           
        int value;                     // curNode.value;
        List<String> curKeys;         // store the key at the value of curNode.value;
        
        valueNode(int value,String key) {
            this.value = value;
            curKeys = new LinkedList<String>();
            curKeys.add(key);
        }
    }
    
    private valueNode head;
    private valueNode tail;
    private valueNode curNode;
    private HashMap<String, valueNode> keyMap;
    
    /** Initialize your data structure here. */
    public AllOne() {
        keyMap = new HashMap<String,valueNode>();
        head = null;
        tail = null;
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (tail == null) { // which means head must be null too and the keyMap must be empty.
                curNode = new valueNode(1,key);
                head = curNode;
                tail = curNode;
                keyMap.put(key,curNode);
        } else if (!keyMap.containsKey(key)){ //which means that this key should be add to the tail.
                if (tail.value == 1) {//which means just add the key to the tail list.
                    tail.curKeys.add(key);
                    keyMap.put(key,tail);
                }else {    //which means have to add a value= 1 node.
                    curNode = new valueNode(1,key);
                    curNode.preNode = tail;
                    tail.nextNode = curNode;
                    tail = curNode;
                    keyMap.put(key,curNode);
                }
        } else { //which the string already exists.
            curNode = keyMap.get(key);
            if (curNode.preNode != null) {  //which means the node is in the middle.
                if (curNode.preNode.value == curNode.value + 1){
                    curNode.preNode.curKeys.add(key);
                    curNode.curKeys.remove(key); 
                    keyMap.put(key,curNode.preNode);
                    checkEmpty(curNode);
                }else {                     //which means the preNode value != curNode.value;
                    valueNode newNode = new valueNode(curNode.value+1, key);
                    newNode.preNode = curNode.preNode;
                    newNode.nextNode= curNode;
                    newNode.preNode.nextNode = newNode;
                    curNode.preNode = newNode;
                    curNode.curKeys.remove(key); 
                    keyMap.put(key,newNode);
                    checkEmpty(curNode);
                }
            }else {//which means the node is the head. so we build a new head.
                head = new valueNode(curNode.value+1,key);
                head.nextNode = curNode;
                curNode.preNode = head;
                curNode.curKeys.remove(key);
                keyMap.put(key,head);
                checkEmpty(curNode);
            }
        }
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
            if (head ==null ||!keyMap.containsKey(key)) return; //which means nothing here.
                                                         //or  means no key in the structrue.
            curNode = keyMap.get(key);
            if (curNode.nextNode != null) {  //which means the node is in the middle.
                if (curNode.nextNode.value == curNode.value - 1){ //which means we can just 
                    curNode.nextNode.curKeys.add(key);
                    curNode.curKeys.remove(key); 
                    keyMap.put(key,curNode.nextNode);
                    checkEmpty(curNode);
                }else {                     //which means the nextNode value != curNode.value-1;
                        valueNode newNode = new valueNode(curNode.value-1, key);
                        newNode.nextNode = curNode.nextNode;
                        newNode.preNode= curNode;
                        newNode.nextNode.preNode = newNode;
                        curNode.curKeys.remove(key); 
                        curNode.nextNode = newNode;
                        keyMap.put(key,newNode);
                        checkEmpty(curNode);
                }
            } else {    //which means the node is the tail. so we build a new head.
                if (curNode.value == 1) {     //just to delete the key.
                    curNode.curKeys.remove(key);  
                    keyMap.remove(key);
                    checkEmpty(curNode);
                }else {                         // build another tail.
                    tail = new valueNode(curNode.value-1,key);
                    tail.preNode = curNode;
                    curNode.nextNode = tail;
                    curNode.curKeys.remove(key);  
                    keyMap.put(key,tail);
                    checkEmpty(curNode);
                }
            }
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
         if (head == null) return "";//which means nothing here.
         return head.curKeys.get(0);
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
         if (tail == null) return "";//which means nothing here.
         return tail.curKeys.get(0);
        
    }
    // to check whether the node should be delete because the keyList is empty.
    private void checkEmpty(valueNode checkNode) {
            if (checkNode.curKeys.size() != 0) return;
            if (checkNode.preNode == null && checkNode.nextNode == null){
                tail = null;
                head = null;
            }else if (checkNode.preNode == null && checkNode.nextNode != null) {
                head = checkNode.nextNode;
                head.preNode = null;
            }else if (checkNode.nextNode == null && checkNode.preNode != null){
                tail = checkNode.preNode;
                tail.nextNode = null;
            }else {
                checkNode.preNode.nextNode = checkNode.nextNode;
                checkNode.nextNode.preNode  = checkNode.preNode; 
            } 
    }
}