class Solution {
    public List<Integer> majorityElement(int[] nums) {
        //
        List<Integer> res = new ArrayList<>();
        if(nums.length<=2){
            HashSet<Integer> set = new HashSet<>();
            for(int ele:nums){
                set.add(ele);
            }
            for(int ele:set){
                res.add(ele);
            }
            return res;
        }

        int ele1=Integer.MIN_VALUE,cnt1=0;
        int ele2=Integer.MIN_VALUE,cnt2=0;
        for(int i=0;i<nums.length;i++){
            if(cnt1==0 && nums[i]!=ele2){
                cnt1=1;
                ele1=nums[i];
            }else if(cnt2==0 && nums[i]!=ele1){
                cnt2=1;
                ele2=nums[i];
            }else if(nums[i]==ele1){
                cnt1++;
            }
            else if(nums[i]==ele2){
                cnt2++;
            }else{
                cnt1--;
                cnt2--;
            }
        }
        cnt1=0;
        cnt2=0;
        for(int ele:nums){
            if(ele==ele1) cnt1++;
            if(ele==ele2) cnt2++;
        }
        int min=(nums.length/3)+1;
        if(cnt1>=min) res.add(ele1);
        if(cnt2>=min) res.add(ele2);

        return res;

    }
}