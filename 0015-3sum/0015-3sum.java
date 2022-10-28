class Solution {
    public static List<List<Integer>> twosum(int[] arr , int start , int end, int targ){
        List<List<Integer>> subres =new ArrayList<>();
        int left  = start ;
        int right = end ;
        while(left<right){
            int sum = arr[left]+arr[right];
            if(left!=start && arr[left] == arr[left-1]) {
               left++;
                continue;
            }
            if(sum == targ){
                List<Integer> lis = new ArrayList<>();
                lis.add(arr[left]);
                lis.add(arr[right]);
                subres.add(lis);
                left++;
                right--;
            }else if(sum<targ){
                left++;
            }else{
                right--;
            }
        }
        return subres;
    }
    
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n= nums.length;
        if(n<3){
            return res;
        }
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++){
            if(i!=0 && nums[i] == nums[i-1]){ 
                continue;
            }
            int val1 = nums[i];
            int targ = 0-val1;
            List<List<Integer>> subres = twosum(nums,i+1,n-1,targ);
            
            for (List<Integer> list : subres){
                list.add(0,val1);
                res.add(list);
            }
        }
        return res;
    }
}