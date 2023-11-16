class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        //Broute Force =
        // TC :O(n^2) -- 2 for loop check to each 2 pairs possible --
        //SC :O(1)
        
        //better -->
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
            int b = nums[i], a= target-b;
            if(map.containsKey(a)){
                return new int[]{map.get(a),i};
            }
            map.put(b,i);
        }
        return new int[]{};
    
    //TC :  O(n)
    //SC : O(n)
    
    //Lets Optimise :: Using Two pointer ::
           
//         int left =0;
//         int right =n-1;
//         while(left<right){
//             int sum =nums[left]+nums[right];
//             if(sum==target){
//                 return new int[]{left,right};
//             }else if(sum>target){
//                 right--;
//             }else{
//                 left++;
//             }
//         }
//         return new int[]{};
        
        //TC : O(nlogn)
        //Sc: O(1)
    }
}