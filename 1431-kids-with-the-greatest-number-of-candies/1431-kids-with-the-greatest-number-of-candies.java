class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int len = candies.length;
        List<Boolean> res = new ArrayList<>();
        int maxi =-1;
        for(int i=0;i<len;i++){
            if(candies[i]>maxi){
                maxi =candies[i];
            }
        }
        for(int i=0;i<len;i++){
            if(candies[i]+extraCandies>=maxi){
                res.add(true);
            }else{
                res.add(false);
            }
        }
        return res;
    }
}