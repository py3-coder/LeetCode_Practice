class Solution {
    public int majorityElement(int[] nums) {
        //Moore's Voting Algo..
        int ele=0;
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(count==0){
                count=1;
                ele=nums[i];
            }else if(nums[i]==ele) count++;
            else{
                count--;
            }
        }
        return ele;  
        //he majority element always exists in the array. No need to check..
    }
}