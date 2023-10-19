class Solution {
    public int minimumMountainRemovals(int[] nums) {
        // Explanation:: LIS ::
        //Since we need to find the no. of deletion to make mountain array::
        // So if we apply LIS from front and back  add the max valueandreduce -1:
        // Eg : [2,1,1,5,6,2,3,1]
        // front:1,1,1,2,3,2,3,1
        // back :2,1,1,3,4,2,2,1
        //------------------------
        //               7-1 =6 
        //Note: Botonic array can't be montain arr: mountains must have dec & ase
        // part:
        
        // return total len-mountain : no. of deletion:


        //*IMP :: Point If we have Increasing party only or decreasing part only
        // not valid one::
        // since when ever we have lis==1 && lds ==1 we can skip it..
        
        // TC : O(n^2)
        // SC : O(n)+O(n)
        //return solveLIS(nums);

        //Lets think of optimise::
        // TC : O(nlogn)
        //SC : O(n)+O(n)
        return solve(nums);




    }
    public static int solveLIS(int[] arr){
        int n=arr.length;
        int flis[] =new int[n];
        int blis[] =new int[n];
        Arrays.fill(flis,1);
        Arrays.fill(blis,1);

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j] && 1+flis[j]>flis[i]){
                    flis[i]=1+flis[j];
                }
            }
        }
        int maxi=0;
        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>i;j--){
                if(arr[i]>arr[j] && 1+blis[j]>blis[i]){
                    blis[i]=1+blis[j];
                }
            }
            // imp: case it can't be just increasing or decresing::
            //ex : 9 8 1 7 6 5 4 3 2 1
            // lis:1 1 1 2 2 2 2 2 2 1 
            // lds:9 8 1 7 6 5 4 3 2 1
            //--------------------------
            //lets understand :: 
            // 9 8 7 6 5 4 3 2 1 -- general : not valid since it decresing part 
            // only :: mountain array must have both part ::
            if(flis[i]>1 && blis[i]>1){
                maxi =Math.max(maxi,flis[i]+blis[i]-1);
            }
            
        }
        return n-maxi;
    }
    public static int solve(int[] nums){
        int n =nums.length;
        int lis[] =new int[n];
        int lds[] =new int[n];
        

        ArrayList<Integer> temp =new ArrayList<>();
        
        //LIS::
        temp.add(nums[0]);
        for(int i=1;i<n;i++){
            if(temp.get(temp.size()-1)<nums[i]){
                temp.add(nums[i]);
            }else{
                int pos = binarySearch(nums[i],temp);
                temp.set(pos,nums[i]);
            }
            lis[i] =temp.size();
        }

        temp.clear();
        //LDS::
        temp.add(nums[n-1]);
        for(int i=n-2;i>=0;i--){
            if(temp.get(temp.size()-1)<nums[i] ){
                temp.add(nums[i]);
            }else{
                int pos = binarySearch(nums[i],temp);
                temp.set(pos,nums[i]);
            }
            lds[i] =temp.size();
            
        }
        int maxi=0;
        for(int i=0;i<n;i++){
            // skip the completely incresing / decresing case::)
            if(lis[i]>1 && lds[i]>1){
                maxi =Math.max(maxi,lis[i]+lds[i]-1);
            }
        }
        return nums.length-maxi;

    }
    public static int binarySearch(int target,ArrayList<Integer> arr){
        int l=0;
        int h=arr.size()-1;

        while(l<=h){
            int m =l+(h-l)/2;
            if(arr.get(m)==target){
                return m;
            }else if(arr.get(m)>target){
                h=m-1;
            }else{
                l=m+1;
            }
        }
        return l;
    }
}