class Solution {
public int maxSatisfaction(int[] satisfaction) {
Arrays.sort(satisfaction);

    int maxVlaue=0;
    for(int i=0;i<satisfaction.length;i++){
        int cook=1;
        int sum=0;
        for(int j=i;j<satisfaction.length;j++){
        sum+=satisfaction[j]*cook;
        cook++;
        }
        maxVlaue=Math.max(sum,maxVlaue);
    }
    return  maxVlaue;
}
}