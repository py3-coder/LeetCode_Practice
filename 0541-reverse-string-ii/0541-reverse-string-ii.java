class Solution {
    public String reverseStr(String s, int k) {
        int n=s.length();
        char[] ch =s.toCharArray();
        //increase 2k loop: since till we can after that only use::
        for(int i=0;i<n-1;i+=2*k){
            int start=i;
            //if in case left char are less than 2*k so we need to reverse all:
            int end=Math.min(i+k-1,n-1);
            //swap the characters:
            swap(start,end,ch);
        }
        return s.valueOf(ch);
    }
    public static void swap(int s,int e,char[] ch){
        while(s<e){
            char temp = ch[s];
            ch[s++] = ch[e];
            ch[e--] = temp;
        }
        return ;
    }
}