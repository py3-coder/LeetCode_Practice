class Solution {
    public int maximumLength(String s) {
        
        
        // TC : O(nlogn)
        // SC : O(1)
        
        int n= s.length();
        
        //check for 1 size if not possible -1:
        int start=1,end = n;
        
        if(!isPossible(1,s)) return -1;
        
        
        int ans=0;
        while(start<=end){
            int mid = (start+end) / 2;
            if(isPossible(mid,s)){
                ans = mid;
                start = mid+1;
            }else{
                end=mid-1;
            }
        }
        return ans;
    }
    
    public boolean isPossible(int k , String s){
        int[] cnt = new int[26];
        int end = 0,start=0;
        
        while(end<s.length()){
            while(s.charAt(end)!=s.charAt(start)) start++;
            if(end-start+1 >= k){
                cnt[s.charAt(end)-'a']++;
            }
            if(cnt[s.charAt(end)-'a']>2) return true;
            
            end++;
        }
        return false;
    }
}