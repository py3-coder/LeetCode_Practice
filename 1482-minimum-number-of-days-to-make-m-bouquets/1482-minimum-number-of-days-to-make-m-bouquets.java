class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        /* Approch ~ Observations
        1. if m*k > arr.length then it should return -1 in every case
        2. lets think  in direction minimun no. of days to bool a flower  the min element in array
            and all flower will bool in max days that is maximum element of array
        3. So , we need to search the minimum value into the min to max range ....
        4. Searching Space : [min element to max element]
        5. Now, we can apply binary searh to find the ans 
        
        
        Code :
        */
        if((long)m*k > bloomDay.length){
            return -1;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int val : bloomDay){
            min = Math.min(min,val);
            max = Math.max(max,val);
        }
        int res =0;
        int start = min;
        int end = max;
        while(start<=end){
            int mid = start +(end -start)/2;
            if(isPossible(bloomDay,m,k,mid)==true){
                res =mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return res;
    }
    
    public static boolean isPossible(int[] arr,int m,int k, int mid){
        int count =0;
        int counter=0;
        for(int i=0;i<arr.length;i++){
            if(mid>=arr[i]){
                count +=1;
                if(count==k){
                    counter +=1;
                    count=0;
                }
            }else if(mid<arr[i]){
                count =0;
            }
        }
        return counter>=m;
    }
}