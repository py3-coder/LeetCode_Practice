class Solution {
    // TC : O(n*n!)
    // SC : O(n) ~ Auxilary Space
    // boolean flag=false;
    // public boolean checkInclusion(String s1, String s2) {
    //     permute(s1,s2,0);
    //     return flag;
    // }
    // public String swap(String s,int i,int r){
    //     if(i==r) return s;
    //     StringBuilder ss = new StringBuilder(s);
    //     char temp = ss.charAt(i);
    //     ss.setCharAt(i, ss.charAt(r));
    //     ss.setCharAt(r, temp);
    //     return ss.toString();
    // }
    // public void permute(String s1 , String s2 , int indx){
    //     if(indx == s1.length()){
    //         if(s2.indexOf(s1)>=0){
    //             flag = true;
    //         }
    //     }else{
    //         for(int i=indx;i<s1.length();i++){
    //             s1 = swap(s1 , indx , i);
    //             permute(s1 , s2,indx+1);
    //             s1 = swap(s1 , i, indx);
    //         }
    //     }
    // }
    
    public boolean checkInclusion(String s1, String s2) {
    Map<Character, Integer> cnt = new HashMap<>();
    for (char c : s1.toCharArray()) {
        cnt.put(c, cnt.getOrDefault(c, 0) + 1);
    }

    int matchedCnt = 0;
    for (int i = 0; i < s2.length(); ++i) {
        char c = s2.charAt(i);
        if (cnt.containsKey(c)) {
            cnt.put(c, cnt.get(c) - 1);
            if (cnt.get(c) == 0) {
                matchedCnt++;
            }
        }
        if (i >= s1.length()) {
            c = s2.charAt(i - s1.length());
            if (cnt.containsKey(c)) {
                if (cnt.get(c) == 0) {
                    matchedCnt--;
                }
                cnt.put(c, cnt.get(c) + 1);
            }
        }

        if (matchedCnt == cnt.keySet().size()) { 
            return true;
        }
    }
    return false;
  }
}