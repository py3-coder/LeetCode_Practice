class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int res[] = new  int[nums.length];
        // ArrayList<Integer> liseven = new ArrayList<>();
        // ArrayList<Integer> lisodd = new ArrayList<>();
        // for(int i=0;i<nums.length;i++){
        //     if(nums[i]%2==0){
        //         liseven.add(nums[i]);
        //     }else{
        //         lisodd.add(nums[i]);
        //     }
        // }
        // int k=0;
        // for(int i=0;i<liseven.size();i++){
        //     res[k++] =liseven.get(i);
        // }
        // for(int i=0;i<lisodd.size();i++){
        //     res[k++] =lisodd.get(i);
        // }
        // return res;
        int left=0,right=nums.length-1;
        while(left<=right){
            if(nums[left]%2==0) left++;
            else if(nums[right]%2!=0) right--;
            else{
                int temp=nums[left];
                nums[left] =nums[right];
                nums[right]=temp;
            }
        }
        return nums;
    }
}