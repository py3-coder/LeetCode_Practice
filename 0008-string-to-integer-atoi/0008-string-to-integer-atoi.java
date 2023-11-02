class Solution {
    public int myAtoi(String s) {
        //return iterativeAtoi(s);
        //TC :: O(n)
        //SC: O(1)
        
        
        // int total=0;
        // total=stringToInt(s,total,0,true,false);
        // return total;
        
        //TC : O(n)::
        //SC : O(1) ---> Auxliary Space :: Recursion Stack - O(n)
        return stringToInt(s,0,0,true,false);
        
    }
    public static int iterativeAtoi(String s){
        int total=0,sign=1;
        int indx=0;
        if(s.length()==0) return 0;
        s=s.strip();
        if(s.isEmpty()) return 0;
        
        //whitespace
        while(s.charAt(indx)==' ') indx++;
        //-ve ,+ve
        if(s.charAt(indx)=='+' || s.charAt(indx)=='-'){
            sign=s.charAt(indx)=='+'?1:-1;
            indx++;
        }
        while(indx<s.length()){
            //overflow && underflow:::
            if(s.charAt(indx)-'0'<0 || s.charAt(indx)-'0'>9) break;
            if(total>Integer.MAX_VALUE/10 || total==Integer.MAX_VALUE/10 && s.charAt(indx)-'0'>7){
                 return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            total =total*10+s.charAt(indx)-'0';
            indx++;
        }
        return sign*total;
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