class Solution {
    private static final String[] KEYS = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    public static List<String> letterCombinations(String a) {
        // Write your code here.
        List<String> res = new ArrayList<>();
        if(a==null || a.length()==0) return res;
        solveRecursion(a,0,"",res);
        return res;
    }
    public static void solveRecursion(String str,int indx ,String Op,List<String> res){
        if(indx==str.length()){
            res.add(Op);
            return;
        }
        String letter =KEYS[str.charAt(indx)-'0'];
        for(int i=0;i<letter.length();i++){
            solveRecursion(str, indx+1, Op+letter.charAt(i), res);
        }

    }
}