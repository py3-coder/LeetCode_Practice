class Solution {
    HashMap<String,Integer> map;
    public int waysToReachStair(int k) {
        map = new HashMap<>();
        return solveRec(1,k,true,0);
        
    }
    public int solveRec(int curr,int k,boolean flag,int jump){
        
        //choice ::
        
        // if prev jump was i-1 backward then only one choice
        // if prev jump  i+2^jump --  the  2 choice either backward or forward::
        //base case ::-
        if(curr>k+1){
            return 0;
        }
        int ans =0;
        if(curr == k){
            ans++;
        }
        String key =curr+" "+jump+" "+flag;
        if(map.containsKey(key)){
            return map.get(key);
        }

        // we have two choices :: 
        if(flag==true && curr!=0){
            ans += solveRec(curr-1,k,false,jump);
            ans += solveRec(curr+(int)Math.pow(2,jump),k,true,jump+1);
        }else{
            ans +=solveRec(curr+(int)Math.pow(2,jump),k,true,jump+1);
        }
        map.put(key,ans);
        return ans;
    }
}
