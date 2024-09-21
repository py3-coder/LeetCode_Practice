class Solution {
    public List<Integer> lexicalOrder(int n) {
        // TC : O(n)
        // SC : O(1) 
        
        
        List<Integer> res = new ArrayList<>();
        int curr =1;
        for(int i=1;i<=n;i++){
            res.add(curr);
            if(curr*10<=n){
                curr*=10;
            }else if(curr%10!=9 && curr+1<=n){
                curr++;
            }else{
                while ((curr / 10) % 10 == 9) {
                    curr /= 10;
                }
                curr = curr / 10 + 1;
                
            }
        }
        return res;
    }
}