class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //Broute Force
        //int n =arr.length;
        // HashSet<List<Integer>> res = new HashSet<>();
        // for(int i=0;i<n;i++){
        //     for(int j=i+1;j<n;j++){
        //         for(int k=j+1;k<n;k++){
        //             for(int l=k+1;l<n;l++){
        //                 int sum =arr[i]+arr[j]+arr[k]+arr[l];
        //                 if(sum==target){
        //                     List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k],arr[l]);
        //                     temp.sort(null);
        //                     res.add(temp);
        //                 }
        //             }
        //         }
        //     }
        // }
        // List<List<Integer>> output = new ArrayList<>(res);
        // return output;
        
        //better
        // int n =nums.length;
        // HashSet<List<Integer>> res = new HashSet<>();
        // for(int i=0;i<n;i++){
        //     for(int j=i+1;j<n;j++){
        //         HashSet<Long> hs = new HashSet<>();
        //         for(int k=j+1;k<n;k++){
        //             long due =target-(nums[i]+nums[j]+nums[k]);
        //             if(hs.contains(due)){
        //                  List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k],(int)due);
        //                     temp.sort(null);
        //                     res.add(temp);
        //             }
        //             hs.add((long)nums[k]);
        //         }
        //     }
        // }
        // List<List<Integer>> output = new ArrayList<>(res);
        // return output;
        //optimal approch::
        
        int n=nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<n-3;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<n-2;j++){
                if(j>i+1 && nums[j]==nums[j-1]) continue;
                int  k =j+1;
                int l=n-1;
                while(k<l){
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
                    if(sum==target){
                         List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k],nums[l]);
                            res.add(temp);
                            k++;
                            l--;
                            while (k < l && nums[k] == nums[k - 1]) k++;
                            while (k < l && nums[l] == nums[l + 1]) l--;
                    }else if(sum>target){
                        l--;
                    }else{
                        k++;
                    }
                }
            }
        }
        return res;
    }
}