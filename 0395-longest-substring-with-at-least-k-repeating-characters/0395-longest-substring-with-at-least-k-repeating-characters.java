class Solution {
    public int longestSubstring(String s, int k) {
        int maxUniqueCharCnt = getUniqueChar(s);   
        int[] freq = new int[26];
        int ans =0;
        for(int currCharCnt=1;currCharCnt<=maxUniqueCharCnt;currCharCnt++){
            int uniqueCharCnt=0,start=0,end=0,atleastk=0;
            Arrays.fill(freq, 0);
            while(end<s.length()){
                if(uniqueCharCnt<=currCharCnt){
                   int pos = s.charAt(end)-'a';
                    if(freq[pos]==0){
                        uniqueCharCnt++;
                    }
                    freq[pos]++;
                    if(freq[pos]==k){
                        atleastk++;
                    }
                   end++;
                }else{
                    int pos = s.charAt(start)-'a';
                    if(freq[pos]==k){
                        atleastk--;
                    }
                    freq[pos]--;
                    if(freq[pos]==0){
                       uniqueCharCnt--; 
                    }
                    start++;
                }
                
                if(uniqueCharCnt == currCharCnt && uniqueCharCnt==atleastk){
                    ans = Math.max(ans , end-start);
                }
            }
            
        }
        return ans;
    }
    public int getUniqueChar(String s){
         boolean [] chars = new boolean [26];
        int uniqueCount = 0;
        
        for (char ch : s.toCharArray()) {
            int idx  = ch - 'a';
            if (!chars[idx]) {
                uniqueCount++;
                chars[idx] = true;
            }
        }
        
        return uniqueCount;
    }
}