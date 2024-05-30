class Solution {
    public int countTriplets(int[] arr) {
        // TC : O(n^3)
        // SC : O(1)
        //return solveBf(arr);
        
        // TC : O(n^2)
        // SC :O(1)
        return solveOpt(arr);
    }
    public int solveBf(int[] arr){
        int cnt=0;
        
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                int a = 0;
                for(int k=i;k<j;k++){
                    a^=arr[k];
                }
                int b =0;
                for(int k=j;k<arr.length;k++){
                    b^=arr[k];
                    if(a == b){
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
    
    public int solveOpt(int[] arr){
        int cnt =0;
        
        
        for(int i=0;i<arr.length;i++){
            int xor =arr[i];
            
            for(int k=i+1;k<arr.length;k++){
                xor ^= arr[k];
                
                if(xor == 0){
                    cnt += (k-i);
                }
            }
        }
        return cnt;
    }
}