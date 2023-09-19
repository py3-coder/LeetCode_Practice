// class Solution {
//     public int myAtoi(String s) {
        
//     }
// }

public class Solution {
    public static int myAtoi(String str) {
        // Write your code here.
        // Lets Apply Recursion:::
        int total=0;
        total=stringInt(str,total,0,true,false);
        return total;
        
    }
    public static int stringInt(String str,int total,int indx,boolean sign,boolean check){
        //Base Case::
        if(indx==str.length()) return 0;
        if(!check){
            if(str.charAt(indx)==' ') return stringInt(str, total, indx+1, sign,check);
            if(str.charAt(indx)=='-'|| str.charAt(indx)=='+'){
                sign =str.charAt(indx)=='-'?false:true;
                return stringInt(str, total, indx+1, sign,!check);
            }
        }
        check=true;
        //Case when the begining char at letter::
        char ch =str.charAt(indx);
        if(ch-'0'< 0|| ch-'0'>9){
            return 0;
        }
        // Case to handle edge case of Overflow ---
        if(total>Integer.MAX_VALUE/10 || total==Integer.MAX_VALUE/10 && ch-'0'>7)
            return sign?Integer.MAX_VALUE:Integer.MIN_VALUE;
            
        //Hypothesis & Induction ::
        total =total*10+ch-'0';
        int t =stringInt(str, total, indx+1, sign, check);
        if(t==0) return sign?total:-total;
        return t;

    }
}
