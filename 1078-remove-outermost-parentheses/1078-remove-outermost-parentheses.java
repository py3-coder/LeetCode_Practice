class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder ans=new StringBuilder();
        int open=0;
        for(int i=0;i<s.length();i++){
            char ch =s.charAt(i);
            if(ch=='(' && open == 0){
                open++;
            }
            else if(ch=='('&& open>0){
                ans.append(ch);
                open++;
            }
            else if(ch==')' && open>1){
                ans.append(ch);
                open--;
            }
            else if(ch==')' && open==1){
                open--;
            }
        }
        return ans.toString();
    }
}