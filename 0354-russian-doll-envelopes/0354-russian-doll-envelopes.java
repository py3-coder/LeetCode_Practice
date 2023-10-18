class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // LIS Modified :)
        // If we sort on basic of first and if equal the on basic of second::
        // Simply apply LIS on both :)

        //edge case ::)
        if(envelopes.length==1){
            return 1;
        }
        //return solveLis(envelopes);
        // TC : O(n^2)  --TLE
        // SC: O(n)+O(n)
        // fails at 85/87 testcase::

        // TC : O(nlogn)
        // SC: O(n)+O(n)
        return solveLISOptimised(envelopes);
        
    }
    public static int solveLis(int[][] envelopes){
        Arrays.sort(envelopes,(a,b)->{
            if(a[0]==b[0]){
                return b[1]-a[1];
            }else{
                return a[0]-b[0];
            }
        });
        int n=envelopes.length;

        int len[] = new int[n];
        Arrays.fill(len,1);
        int maxi=0;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(envelopes[i][0]>envelopes[j][0] && envelopes[i][1]>envelopes[j][1] && 1+len[j]>len[i]){
                    len[i] =1+len[j];
                }
            }
            maxi =Math.max(len[i],maxi);
        }
        return maxi;
    }
    public static int solveLISOptimised(int[][] envelopes){
        int n=envelopes.length;
        Arrays.sort(envelopes,(a,b)->{
            if(a[0]==b[0]){
                return b[1]-a[1];
            }else{
                return a[0]-b[0];
            }
        });
        // since the oth indx of every is sorted ::
        // so if we could able to find lis on 1st then that would be the ans::
        int arr[] =new int[n];
        int k=0;
        for(int[] ele:envelopes){
            arr[k++]=ele[1];
        }
        List<Integer> temp =new ArrayList<>();
        temp.add(arr[0]);
        for(int i=1;i<n;i++){
            if(!temp.isEmpty() && temp.get(temp.size()-1)<arr[i]){
                temp.add(arr[i]);
            }else{
                int pos =binarySearch(temp,arr[i]);
                temp.set(pos,arr[i]);
            }
        }
        return temp.size();
    }
    public static int binarySearch(List<Integer> arr,int target){
        int l=0;
        int h=arr.size()-1;
        while(l<=h){
            int mi =l+(h-l)/2;
            if(arr.get(mi)==target){
                return mi;
            }else if(arr.get(mi)>target){
                h=mi-1;
            }else{
                l=mi+1;
            }
        }
        return l;
    }
}