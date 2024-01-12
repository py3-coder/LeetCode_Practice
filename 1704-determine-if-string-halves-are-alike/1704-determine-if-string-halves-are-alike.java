class Solution {
    public boolean halvesAreAlike(String s) {
        int n =s.length();
        s =s.toLowerCase();
        int s1=0,s2=0;
        for(int i=0;i<n;i++){
            if(i<(n/2) && isVowel(s.charAt(i))){
                s1++;
            }
            if(i>=(n/2) && isVowel(s.charAt(i))){
                s2++;
            }
        }
        if(s1==s2) return true;
        return false;
    }
    public static boolean isVowel(char ch){
        if(ch=='a' || ch=='e'|| ch=='i'|| ch=='o'|| ch=='u'){
            return true;
        }
        return false;
    }
}