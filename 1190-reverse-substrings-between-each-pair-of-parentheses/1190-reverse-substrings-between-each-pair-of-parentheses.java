class Solution {
    public String reverseParentheses(String s) {
        Stack<String> st = new Stack<>();
        String str = "";
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                str += s.charAt(i);
            }else if(s.charAt(i) == '('){
                st.push(str);
                str = "";
            }else{
                String p = st.pop();
                String r = new StringBuilder(str).reverse().toString();
                str = p + r;               
            }                
        }
        return str;
    }
}