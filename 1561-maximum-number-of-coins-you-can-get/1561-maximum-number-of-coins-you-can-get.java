class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        
        int i=0,j=piles.length-1;
        int sum=0;
        while(i<j){
            sum+=piles[j-1];
            j-=2;
            i+=1;
        }
        return sum;
    }
}