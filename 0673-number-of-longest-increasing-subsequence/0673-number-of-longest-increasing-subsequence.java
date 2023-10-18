class Solution {
    public int findNumberOfLIS(int[] nums) {
        // LIS Pure::
        //edge case :: 
        if(nums.length==1){
            return 1;
        }
        return solveLIS(nums);
        
    }
    public static int solveLIS(int[] arr){
        int n=arr.length;
        HashMap<Integer,Integer> map =new HashMap<>();
        int len[] = new int[n];
        int cnt[] = new int[n];
        Arrays.fill(len,1);
        Arrays.fill(cnt,1);

        int maxi =0;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    if(1+len[j]>len[i]){
                        len[i] =1+len[j];
                        cnt[i]=cnt[j];
                    }else if(1+len[j]==len[i]){
                        cnt[i]+=cnt[j];
                    }
                }
            }
            maxi =Math.max(maxi,len[i]);
        }
        int num=0;
        for(int i=0;i<n;i++){
            if(maxi==len[i]){
                num +=cnt[i];
            }
        }
        return num;
    }
}