class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int max = Integer.MIN_VALUE;
        for(int val : quantities){
            max= Math.max(max,val);
        }
        int start =1;
        int end = max;
        int res =0;
        while(start<=end){
            int mid = start +(end-start)/2;
            if(isPossible(n,mid,quantities)==true){
                res = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return res ;
    }
    public static boolean isPossible(int n , int mid , int[] arr){
        int count =0;
        for(int val : arr){
            count += Math.ceil(val/(mid*1.0));
        }
        return count<=n;
    }
}