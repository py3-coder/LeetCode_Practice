class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        String str="";
        solveRec(n,n,str,res);
        return res;
        
    }
    public static void solveRec(int open,int close,String op,List<String> temp){
        if(open==0 && close==0){
            temp.add(op);
            return ;
        }
        if(open==0 && close!=0){
            String op2 =op+')';
            solveRec(open,close-1,op2,temp);
        }
        else if(open<close){
            //2 choices ::
            String op1=op+'(';
            String op2 =op+')';
            solveRec(open-1,close,op1,temp);
            solveRec(open,close-1,op2,temp);
            
        }else if(open==close){
            String op1 =op+'(';
            solveRec(open-1,close,op1,temp);
        }
    }
}