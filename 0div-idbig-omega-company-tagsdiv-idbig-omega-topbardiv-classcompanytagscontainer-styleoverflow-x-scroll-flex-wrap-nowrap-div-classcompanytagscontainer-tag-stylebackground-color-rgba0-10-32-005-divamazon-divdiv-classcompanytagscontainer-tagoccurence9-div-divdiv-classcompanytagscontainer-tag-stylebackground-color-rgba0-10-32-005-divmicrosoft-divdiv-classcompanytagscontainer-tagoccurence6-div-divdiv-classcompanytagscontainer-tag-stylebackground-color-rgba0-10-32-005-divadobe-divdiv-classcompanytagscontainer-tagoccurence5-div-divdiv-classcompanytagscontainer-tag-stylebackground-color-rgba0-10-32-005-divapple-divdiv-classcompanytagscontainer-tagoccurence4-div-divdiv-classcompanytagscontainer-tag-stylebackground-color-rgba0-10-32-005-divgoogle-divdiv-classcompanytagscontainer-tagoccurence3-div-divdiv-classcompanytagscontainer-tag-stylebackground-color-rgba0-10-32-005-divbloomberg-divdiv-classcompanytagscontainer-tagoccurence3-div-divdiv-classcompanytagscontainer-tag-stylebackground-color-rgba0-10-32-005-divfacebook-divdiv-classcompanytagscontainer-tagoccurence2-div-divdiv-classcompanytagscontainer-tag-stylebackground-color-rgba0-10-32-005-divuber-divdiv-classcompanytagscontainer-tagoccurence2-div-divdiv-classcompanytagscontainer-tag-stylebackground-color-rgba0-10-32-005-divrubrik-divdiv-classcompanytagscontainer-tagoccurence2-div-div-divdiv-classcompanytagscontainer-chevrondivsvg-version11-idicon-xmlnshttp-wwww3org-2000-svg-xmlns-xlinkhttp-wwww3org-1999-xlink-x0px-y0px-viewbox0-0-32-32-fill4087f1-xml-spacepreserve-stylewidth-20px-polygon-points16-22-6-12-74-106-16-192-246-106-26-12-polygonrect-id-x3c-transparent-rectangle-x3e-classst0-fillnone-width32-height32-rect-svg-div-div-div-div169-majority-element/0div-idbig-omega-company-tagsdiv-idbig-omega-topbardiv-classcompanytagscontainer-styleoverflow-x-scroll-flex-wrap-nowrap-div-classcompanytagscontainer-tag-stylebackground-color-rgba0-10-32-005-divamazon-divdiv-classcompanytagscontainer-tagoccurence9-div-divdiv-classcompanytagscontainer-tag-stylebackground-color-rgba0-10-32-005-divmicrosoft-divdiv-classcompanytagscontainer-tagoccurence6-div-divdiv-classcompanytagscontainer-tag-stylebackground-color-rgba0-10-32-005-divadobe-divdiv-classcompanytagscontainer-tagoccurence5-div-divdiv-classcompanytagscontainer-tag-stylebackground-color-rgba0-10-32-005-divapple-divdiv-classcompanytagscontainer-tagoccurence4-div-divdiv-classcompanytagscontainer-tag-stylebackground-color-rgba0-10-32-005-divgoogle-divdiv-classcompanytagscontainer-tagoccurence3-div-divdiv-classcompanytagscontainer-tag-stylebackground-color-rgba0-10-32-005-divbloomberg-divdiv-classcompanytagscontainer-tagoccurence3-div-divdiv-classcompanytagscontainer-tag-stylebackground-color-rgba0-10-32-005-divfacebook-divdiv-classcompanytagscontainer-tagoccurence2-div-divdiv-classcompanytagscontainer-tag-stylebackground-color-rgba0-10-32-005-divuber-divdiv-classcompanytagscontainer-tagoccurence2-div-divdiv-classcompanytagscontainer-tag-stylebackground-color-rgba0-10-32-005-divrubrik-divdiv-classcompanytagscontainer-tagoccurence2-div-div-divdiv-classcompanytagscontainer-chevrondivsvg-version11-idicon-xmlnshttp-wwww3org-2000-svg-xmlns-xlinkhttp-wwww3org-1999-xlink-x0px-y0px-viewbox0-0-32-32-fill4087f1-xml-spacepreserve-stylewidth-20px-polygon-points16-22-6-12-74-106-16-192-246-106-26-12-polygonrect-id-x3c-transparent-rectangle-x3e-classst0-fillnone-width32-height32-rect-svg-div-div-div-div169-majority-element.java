class Solution {
    public int majorityElement(int[] nums) {
        int ele=0;
        int cnt=0;
        for(int i=0;i<nums.length;i++){
            if(cnt==0){
                cnt+=1;
                ele=nums[i];
            }else if(ele==nums[i]) cnt++;
            else{
                cnt--;
            }
        }
        return ele;
    }
}