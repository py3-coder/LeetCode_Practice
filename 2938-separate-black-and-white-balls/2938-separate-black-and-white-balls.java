class Solution {
    public long minimumSteps(String s) {
        int n=s.length();
        long res=0;
        long l=0;
        for(int i=0;i<n;i++){
            char ch =s.charAt(i);
            if(ch=='1'){
                l++;
            }else{
                res+=l;
            }
        }
        return res;
    }
}