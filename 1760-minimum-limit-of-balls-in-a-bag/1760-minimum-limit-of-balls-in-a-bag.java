class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int val = Integer.MIN_VALUE;
        for(int i : nums){
            val = Math.max(val,i);
        }
        int start =1;
        int end = val;
        int res =0;
        while(start<=end){
            int mid = start +(end-start)/2;
            if(isPossible(nums,mid,maxOperations)==true){
                res = mid;
                end = mid-1;
            }else{
                start =mid+1;
            }
        }
        return res;
    }
    public static boolean isPossible(int[] arr,int mid ,int maxi){
        int count =0;
        for(int val : arr){
            count += (val-1)/mid;
        }
        return count<=maxi;
    }
}