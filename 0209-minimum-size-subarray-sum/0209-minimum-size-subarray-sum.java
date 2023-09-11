class Solution {
    public int minSubArrayLen(int target, int[] arr) {
        int n=arr.length;
        int mini =Integer.MAX_VALUE;
        int sum=0;
        int end=0,start=0;
        while(end<n){
            sum+=arr[end];
            end++;
            while(sum>=target){
                mini =Math.min(end-start,mini);
                sum-=arr[start];
                start++;
            }
            
        }
        return  mini==Integer.MAX_VALUE?0:mini;
    }
}