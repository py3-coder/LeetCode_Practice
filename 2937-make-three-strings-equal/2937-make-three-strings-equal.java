class Solution {
    public int findMinimumOperations(String s1, String s2, String s3) {
        int len1=s1.length();
        int len2=s2.length();
        int len3=s3.length();
        int mini =Math.min(len1,Math.min(len2,len3));
        int i=0;
        while(i<mini){
            char ch1=s1.charAt(i);
            char ch2=s2.charAt(i);
            char ch3=s3.charAt(i);
            if(ch1==ch2 && ch2==ch3 ){
                i++;
            }else{
                break;
            }          
        }
        return i==0?-1:len1+len2+len3-3*i;
        
    }
}