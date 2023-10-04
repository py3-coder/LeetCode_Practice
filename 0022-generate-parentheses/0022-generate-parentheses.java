class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();
        if(n==0){
            return res;
        }
        int open=n;
        int close=n;
        String op="";
        genrate(open, close,op, res);
        return res;
        
    }
    public static void genrate(int open,int close,String op,ArrayList<String> res){
        if(open==0 && close==0){
            res.add(op);
            return;
        }
        if(open==close){
            op+="(";
            genrate(open-1, close, op, res);
        }
        if(open<close){
            String op1 =op;
            String op2 =op;
            //pick close::
            op1+=")";
            genrate(open, close-1, op1, res);
            if(open!=0){
                //not pick close means we have to pick open :)
                op2+="(";
                genrate(open-1, close, op2, res);
            }
        }
    }
}