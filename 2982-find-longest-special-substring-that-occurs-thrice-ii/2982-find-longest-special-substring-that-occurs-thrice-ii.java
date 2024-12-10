class Solution {
    public int maximumLength(String s) {
        // More optimal :
        
        // TC : O(n)
        // SC : O(1) 
        
        int[][] cnt = new int[26][3];
        Arrays.stream(cnt).forEach(a->Arrays.fill(a,-1));
        
        char lastseen='*';
        int winlen =0;
        for(int i=0;i<s.length();i++){
            if(lastseen == s.charAt(i)){
                winlen +=1;
            }else{
                lastseen =s.charAt(i);
                winlen=1;
            }
            findMin(s.charAt(i),winlen,cnt);
        }
        int mini=-1;
        for(int i=0;i<26;i++){
            mini = Math.max(mini ,findMinVal(i,cnt));
        }
        
       
        return mini;
        
        // TC : O(nlogn)
        // SC : O(1)
        
//         int n= s.length();
        
//         //check for 1 size if not possible -1:
//         int start=1,end = n;
        
//         if(!isPossible(1,s)) return -1;
        
        
//         int ans=0;
//         while(start<end){
//             int mid = (start+end) / 2;
//             if(isPossible(mid,s)){
//                 ans = mid;
//                 start = mid+1;
//             }else{
//                 end=mid;
//             }
//         }
//         return ans;
    }
    public void findMin(char ch , int winlen,int[][] cnt){
        int findMini =Integer.MAX_VALUE,loc=-1;
        int pos = ch-'a';
        for(int i=0;i<3;i++){
            if(findMini>cnt[pos][i]){
                findMini = cnt[pos][i];
                loc = i;
            }
        }
        if(cnt[pos][loc]<winlen){
            cnt[pos][loc]=winlen;
        }
        
        
    }
    public int findMinVal(int i,int[][] cnt){
        int mini =Integer.MAX_VALUE;
        for(int j=0;j<3;j++){
           mini = Math.min(cnt[i][j] , mini);
        }
        return mini;
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