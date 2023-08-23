class Solution {
    public int finalValueAfterOperations(String[] ops) {
        int len = ops.length;
        int val=0;
        for(int i=0;i<len;i++){
            if(ops[i].charAt(0) =='-' || ops[i].charAt(1) =='-'){
                val=val-1;
            }else if(ops[i].charAt(0) =='+' || ops[i].charAt(1) =='+'){
                val=val+1;
            }
        }
        return val;
        
    }
}