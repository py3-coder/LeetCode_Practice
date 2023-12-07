class Solution {
    public String largestOddNumber(String num) {
        int n=num.length()-1;
        while(num.charAt(n)%2==0 && n>0){
            n--;
        }
        if(n==0){
            if(num.charAt(0)%2!=0) return num.substring(0,1);
            return "";
        }
        return num.substring(0,n+1);
    }
}