class Solution {
    public List<String> generateParenthesis(int n) {
        int Open =n;
        int close=n;
        String Op="";
        List<String> res = new ArrayList<>();
        
        Solve(Open,close,Op,res);
        return res;
    }
    public static void Solve(int Open,int close,String Op,List<String> res){
        if(Open==0 && close==0){
            res.add(Op);
            return;
        }
        if(Open!=0){
            Solve(Open-1,close,Op+'(',res);
        }
        if(close>Open){
            Solve(Open,close-1,Op+')',res);
        }
    }
}