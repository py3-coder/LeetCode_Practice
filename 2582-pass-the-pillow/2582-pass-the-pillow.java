class Solution {
    public int passThePillow(int n, int time) {
       int reqN =  n-1;
    
       int q = time/reqN;
       int remPass = time%reqN;
        
        return (q%2==0)?1+remPass:n-remPass ;
        
        // if(q%2 == 0){
        //     return 1+remPass;
        // }else{
        //     return n-remPass;
        // }   
    }
}