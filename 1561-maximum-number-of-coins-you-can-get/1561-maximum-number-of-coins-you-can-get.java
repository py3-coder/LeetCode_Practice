class Solution {
    public int maxCoins(int[] piles) {
        //TC : O(nlogn)+O(n/3)
        //SC :O(1)
        // Arrays.sort(piles);
        // int i=0,j=piles.length-1;
        // int sum=0;
        // while(i<j){
        //     sum+=piles[j-1];
        //     j-=2;
        //     i+=1;
        // }
        // return sum;
        
        //Lets Try to optimise::
        // TC : O(n)
        // SC : O(1) 
         int[]  freq =new int[100001];
         for(int i=0;i<piles.length;i++){
             freq[piles[i]]++;
         }
         int i=freq.length-1;
         int chance =piles.length/3;
         int turn=1;
         int ans=0;
         while(chance!=0){
             if(freq[i]>0){
                 if(turn==1){
                     turn=0;
                 }else{
                     ans+=i;
                     turn=1;
                     chance--;
                 }
                 freq[i]--;
             }else{
                 i--;
             }
         }
         return ans;
    }
}