class Solution {
    public int kthGrammar(int n, int k) {
        // Lets Impleement .. B H I -- Method ::
        //Base Case :::
        if(n==1 && k==1){
            return 0;
        }
        //Hypthesis::
        int mid =(int)Math.pow(2,n-1)/2;
        //Induction::
        if(k<=mid){
            return kthGrammar(n-1,k);
        }else{
            return (kthGrammar(n-1,k-mid)==1)?0:1;
       
        }
    }
} 