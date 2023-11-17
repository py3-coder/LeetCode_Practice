class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int glen =g.length;
        int slen =s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        int cnt=0;
        for(int i=0;i<slen && cnt<glen;i++){
            if(s[i]>=g[cnt]){
                cnt++;
            }
        }
        return cnt;
    }
}