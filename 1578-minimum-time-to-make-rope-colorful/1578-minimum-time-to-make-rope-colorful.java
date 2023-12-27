class Solution {
    public int minCost(String colors, int[] neededTime) {
        int cost=0;
        for(int i=0;i<colors.length()-1;i++){
            char f = colors.charAt(i);
            char s =colors.charAt(i+1);
            if(f==s){
                int min =Math.min(neededTime[i],neededTime[i+1]);
                if(min == neededTime[i+1]){
                    neededTime[i+1] =neededTime[i];
                    neededTime[i] =min;
                }
                cost+=min;
            }
        }
        return cost;
    }
}