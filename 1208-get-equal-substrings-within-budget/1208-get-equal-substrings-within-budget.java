class Solution {
    // TC : O(n) // SC : O(1) 
    // public int equalSubstring(String s, String t, int maxCost) {
    //     int start=0,end=0;
    //     int maxlen=0;
    //     while(end<s.length()){
    //         int val = Math.abs(s.charAt(end)-t.charAt(end));
    //         maxCost -=val;
    //         if(maxCost<0 && end>=start){
    //             maxCost+= Math.abs(s.charAt(start)-t.charAt(start));
    //             start++;
    //         }
    //         maxlen = Math.max(maxlen,end-start+1);
    //         end++;
    //     }
    //     return maxlen;
    // }
    // 
    public int equalSubstring(String s, String t, int maxCost) {
        int[] pref = new int[s.length()+1];
        for(int i=1;i<=s.length();i++){
            pref[i] = pref[i-1] +Math.abs(s.charAt(i-1)-t.charAt(i-1));
        }
        
        int l=0,h=s.length()+1;
        int ans =0;
        while(l<=h){
            int mid = l+(h-l)/2;
            if(check(pref,maxCost,mid)){
                ans = mid;
                l = mid+1;
            }else{
                h = mid-1;
            }
        }
        return ans;
    }
    public boolean check(int[] pref ,int maxCost ,int mid){
        boolean flag  = false;
        int l = 0,r =mid;
        while(r<pref.length){
            int sum = pref[r]  - pref[l];
            if(sum<=maxCost){
                flag = true;
                break;
            }
            l++;
            r++;
        }
        return flag;
    }
}