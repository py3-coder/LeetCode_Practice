class Solution {
    public boolean checkPossibility(int[] nums) {
        //LIS ::
        return solveBS(nums)>=nums.length-1;
    }
    public static int solveBS(int nums[]){
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);
        for(int i=1;i<nums.length;i++){
            if(temp.get(temp.size()-1)<=nums[i]){
                temp.add(nums[i]);
            }else{
                int pos = binarySearch(nums[i],temp);
                temp.set(pos,nums[i]);
            }
        }
        return temp.size();
    }
    public static int binarySearch(int target,ArrayList<Integer> arr){
        int l =0;
        int h =arr.size()-1;

        while(l<=h){
            int m =l+(h-l)/2;
            if(arr.get(m)==target){
                return m+1;
            }else if(arr.get(m)>target){
                h=m-1;
            }else{
                l=m+1;
            }
        }
        return l;
    }
}