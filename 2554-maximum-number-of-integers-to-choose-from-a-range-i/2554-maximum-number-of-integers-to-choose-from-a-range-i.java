class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> set = new HashSet<>();
        
        for(int ele : banned){
            set.add(ele);
        }
            
        int cnt=0,sum=0;
        for(int i=1;i<n+1;i++){
            if(!set.contains(i) && sum+i<=maxSum){
                cnt++;
                sum+=i;
            }
        }
        return cnt;
    }
}