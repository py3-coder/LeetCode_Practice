class Solution {
    public List<Integer> goodDaysToRobBank(int[] arr, int time) {
        //Broute Force ::
        // TC : O(n*t)  
        // SC: O(1)+O(k) k-- good days count:

        //Optimal ::
        // TC : O(n)+O(n) ~ O(n)
        // SC : O(n)+O(n) ~ O(n) + O(k)
        int len =arr.length;
        int increase[] = new int[len];
        int decrease[] = new int[len];

        for(int i=1;i<len;i++){
            if(arr[i]<=arr[i-1]){
                decrease[i]=1+decrease[i-1];
            }
        }

        for(int j=len-2;j>=0;j--){
            if(arr[j]<=arr[j+1]){
                increase[j] =1+increase[j+1];
            }
        }

        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<len;i++){
            if(increase[i]>=time && decrease[i]>=time){
                ans.add(i);
            }
        }
        return ans;



    }
}