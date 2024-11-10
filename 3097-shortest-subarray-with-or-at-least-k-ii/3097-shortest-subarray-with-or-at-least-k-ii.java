class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int j=0;
        int ans=Integer.MAX_VALUE;
        int val=0;
        int[] arr=new int[32];
        for(int i=0;i<nums.length;i++){
            val|=nums[i];
            int e=0;
            int num=nums[i];
            while(num>0){
                int rem=num%2;
                if(rem==1) arr[e]+=1;
                num=num/2;
                e++;
            }
            while(i>=j && val>=k){
                ans=Math.min(ans,i-j+1);
            
            int m=0;
            int no=nums[j];
            while(no>0){
                int rem=no%2;
                if(rem==1) arr[m]-=1;
                no=no/2;
                m++;
            }
            val=solve(arr);
            j++;
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    
    public int solve(int[] nums){
        int val=0;
        int ans=1;
        for(int i=0;i<30;i++){
            if(nums[i]>=1){
                val+=ans;
            }
            ans*=2;
        }
        return val;
    }
}