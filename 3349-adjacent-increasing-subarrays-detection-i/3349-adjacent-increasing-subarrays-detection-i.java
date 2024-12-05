class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        
        int n = nums.size();
        if(n<2*k) return false;
        if(k==1) return true;
        for(int i=0;i<n-2*k+1;i++){
           if(check(i,k,nums)==true){
               return true;
           }
        }
        return false;
    }
    public boolean check(int i , int k , List<Integer> nums){
        int n = nums.size();
        for(int j=i;j<i+2*k-1 && j<n-1 ;j++){
                int curr = nums.get(j) , next = nums.get(j+1);
                if(curr >=next && j!=i+k-1){
                    return false;
                }
                if(j == i+k-1){
                    continue;
                }
            }
        return true;
    }
}