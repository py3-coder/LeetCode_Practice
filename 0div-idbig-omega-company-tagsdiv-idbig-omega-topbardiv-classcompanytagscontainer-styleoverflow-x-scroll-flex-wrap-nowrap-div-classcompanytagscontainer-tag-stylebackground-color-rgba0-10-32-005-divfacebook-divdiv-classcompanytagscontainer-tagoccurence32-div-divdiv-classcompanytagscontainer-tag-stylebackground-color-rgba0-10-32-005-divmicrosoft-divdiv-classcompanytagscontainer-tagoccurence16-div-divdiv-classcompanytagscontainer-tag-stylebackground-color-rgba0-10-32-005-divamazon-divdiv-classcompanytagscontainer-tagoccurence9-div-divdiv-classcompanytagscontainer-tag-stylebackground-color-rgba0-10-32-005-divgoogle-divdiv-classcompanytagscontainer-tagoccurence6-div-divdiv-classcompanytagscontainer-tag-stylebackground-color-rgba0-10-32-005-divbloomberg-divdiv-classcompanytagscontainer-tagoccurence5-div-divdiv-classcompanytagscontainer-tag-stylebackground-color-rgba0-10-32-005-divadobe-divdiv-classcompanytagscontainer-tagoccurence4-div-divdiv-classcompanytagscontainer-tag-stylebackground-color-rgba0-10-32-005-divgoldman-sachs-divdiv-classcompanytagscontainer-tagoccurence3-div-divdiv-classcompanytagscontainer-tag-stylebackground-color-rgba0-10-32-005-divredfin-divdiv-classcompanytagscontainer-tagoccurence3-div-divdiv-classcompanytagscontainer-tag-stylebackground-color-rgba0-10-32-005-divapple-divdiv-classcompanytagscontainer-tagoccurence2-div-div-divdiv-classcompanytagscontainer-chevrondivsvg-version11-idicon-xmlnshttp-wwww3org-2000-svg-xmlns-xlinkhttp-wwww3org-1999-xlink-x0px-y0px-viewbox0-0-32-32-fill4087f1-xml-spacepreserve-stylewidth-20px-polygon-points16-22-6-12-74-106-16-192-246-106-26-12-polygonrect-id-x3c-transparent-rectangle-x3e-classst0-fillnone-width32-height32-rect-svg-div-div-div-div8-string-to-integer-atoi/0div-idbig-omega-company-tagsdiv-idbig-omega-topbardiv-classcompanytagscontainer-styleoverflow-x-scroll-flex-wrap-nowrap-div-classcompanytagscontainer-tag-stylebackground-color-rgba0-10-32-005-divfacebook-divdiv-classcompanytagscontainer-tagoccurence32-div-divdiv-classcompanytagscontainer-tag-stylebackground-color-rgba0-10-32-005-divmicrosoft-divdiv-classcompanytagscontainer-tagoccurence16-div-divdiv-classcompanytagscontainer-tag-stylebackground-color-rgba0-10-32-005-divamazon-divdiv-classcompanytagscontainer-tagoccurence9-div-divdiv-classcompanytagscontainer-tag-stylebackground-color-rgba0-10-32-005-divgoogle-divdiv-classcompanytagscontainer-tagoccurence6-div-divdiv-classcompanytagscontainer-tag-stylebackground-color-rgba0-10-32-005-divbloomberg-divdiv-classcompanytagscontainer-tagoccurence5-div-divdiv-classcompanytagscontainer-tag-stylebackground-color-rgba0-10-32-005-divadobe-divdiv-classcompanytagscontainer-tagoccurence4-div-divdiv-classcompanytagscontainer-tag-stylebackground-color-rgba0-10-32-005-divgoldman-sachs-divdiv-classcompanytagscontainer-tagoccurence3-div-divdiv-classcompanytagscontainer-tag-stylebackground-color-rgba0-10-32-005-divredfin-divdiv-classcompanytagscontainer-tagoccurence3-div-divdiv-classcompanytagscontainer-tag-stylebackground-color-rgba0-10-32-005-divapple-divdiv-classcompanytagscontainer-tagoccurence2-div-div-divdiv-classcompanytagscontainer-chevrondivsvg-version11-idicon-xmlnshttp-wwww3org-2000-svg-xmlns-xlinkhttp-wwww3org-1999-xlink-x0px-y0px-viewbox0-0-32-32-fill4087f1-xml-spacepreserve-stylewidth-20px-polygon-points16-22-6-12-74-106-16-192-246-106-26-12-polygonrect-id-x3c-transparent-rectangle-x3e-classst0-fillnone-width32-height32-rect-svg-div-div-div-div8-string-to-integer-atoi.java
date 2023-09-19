class Solution {
    public int myAtoi(String s) {
        int total=0;
        total=stringToInt(s,total,0,true,false);
        return total;
        
    }
    public static int stringToInt(String str,int total,int indx,boolean sign,boolean check){
        //B H I::::
        //Base Case :::
        if(indx==str.length()) return 0;
        if(!check){
            char pos1 =str.charAt(indx);
            if(pos1==' ') return stringToInt(str,total,indx+1,sign,check);
            if(pos1=='+' || pos1=='-'){
                sign =(pos1=='-')?false:true;
                return stringToInt(str,total,indx+1,sign,!check);
            }
        }
        check=true;
        char ch =str.charAt(indx);
        if(ch-'0'<0 || ch-'0'>9) return 0;
        //edge case hnadle for overflow and underflow::
        if(total>Integer.MAX_VALUE/10 || total==Integer.MAX_VALUE/10 && ch-'0'>7){
            return sign?Integer.MAX_VALUE:Integer.MIN_VALUE;
        }
        total =total*10+ch-'0';
        int t =stringToInt(str,total,indx+1,sign,check);
        if(t==0) return sign?total:-total;
        return t;
    }
}