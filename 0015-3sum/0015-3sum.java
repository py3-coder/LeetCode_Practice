class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        //     Set<List<Integer>> set =new HashSet<>();
    //      //Broute Force::
    int n= arr.length;
    //     for(int i=0;i<n;i++){
    //         for(int j=i+1;j<n;j++){
    //             for(int k=j+1;k<n;k++){
    //                 if(arr[i]+arr[j]+arr[k]==0){
    //                     List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
    //                     temp.sort(null);
    //                     set.add(temp);
    //                 }
    //             }
    //         }
    //     }
    //    List<List<Integer>> res = new ArrayList<>(set);
    // return res;

    //optimised...
    //     for(int i=0;i<n;i++){
    //         HashSet<Integer> hs = new HashSet<>();
    //         for(int j=i+1;j<n;j++){
    //             int target = -(arr[i]+arr[j]);
    //             if(hs.contains(target)){
    //                 List<Integer> temp = Arrays.asList(arr[i], arr[j], target);
    //                     temp.sort(null);
    //                     set.add(temp);
    //             }
    //             hs.add(arr[j]);
    //         }
    //     }
    //    List<List<Integer>> res = new ArrayList<>(set);
    //    return res;

    //better 
    List< List < Integer > > ans= new ArrayList<>();
    Arrays.sort(arr);
    for(int i=0;i<n;i++){
        //remove duplicate i value
        if(i!=0 && arr[i]==arr[i-1]) continue;
        int j=i+1;
        int k=n-1;
        while(j<k){
            int sum = arr[i]+arr[j]+arr[k];
            if(sum<0){
                j++;
            }else if(sum>0){
                k--;
            }else{
                List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                    ans.add(temp);
                    j++;
                    k--;
                    //skip the duplicates:
                    while (j < k && arr[j] == arr[j - 1]) j++;
                    while (j < k && arr[k] == arr[k + 1]) k--;
            }
        }
    }
    return ans;
    }
}