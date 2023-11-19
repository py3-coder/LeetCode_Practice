class Solution {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        // int[] arr =new int[nums.length];
        // int prev =nums[0];
        // arr[0]=0;
        // int cnt=0;
        // for(int i=1;i<nums.length;i++){
        //     if(prev<nums[i]){
        //         cnt++;
        //         arr[i]=cnt;
        //         prev =nums[i];
        //     }else{
        //         arr[i]=cnt;
        //     }
        // }
        // int res=0;
        // for(int i=0;i<arr.length;i++){
        //     res+=arr[i];
        // }
        // return res;
        int minOps = 0;
        for (int i=nums.length-1; i>0; i--) {
            if (nums[i] != nums[i-1]) {
                minOps += nums.length - i;
            }
        }
        return minOps;
    }
}