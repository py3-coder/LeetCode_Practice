class Solution {
    public int maxDepth(String s) {
        int maxi=0;
        int cnt=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') maxi =Math.max(maxi,++cnt);
            else if(s.charAt(i)==')') cnt--;
        }
        return cnt==0?maxi:0;
    }
}