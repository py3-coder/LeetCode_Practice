class Solution {
    public int passThePillow(int n, int time) {
       int reqN =  n-1;
    
       int q = time/reqN;
       int remPass = time%reqN;
        
        if(q%2 == 0){
            return 1+remPass;
        }else{
            return n-remPass;
        }
       
        
    }
}