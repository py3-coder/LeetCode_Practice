class Solution {
    public int numDecodings(String s) {
        Map<Integer,Integer> memo = new HashMap<>();
        return Solve(s,0,memo);
        
    }
    public static int Solve(String s,int i,Map<Integer,Integer> memo){
        // Base Case for way 1
        if(i==s.length()){
            return 1;
        }
        // When ever we enconter 0 --> "01" = 0 , "102"=0 "120"=0  
        if(s.charAt(i)=='0'){
            return 0;
        }
        if(memo.containsKey(i)){
            return memo.get(i);
        }
        // Base Case for way 2
        if(i==s.length()-1) return 1;
        // focus on only single elememts
        int way1 = Solve(s,i+1,memo);
        // focus on pair element 
        int way2 =0;
        // pair only considered when it int value is lower than 27.
        if(Integer.parseInt(s.substring(i,i+2))<=26){
            way2 =Solve(s,i+2,memo);
        }
        memo.put(i,way1+way2);
        return way1+way2;
    }
}