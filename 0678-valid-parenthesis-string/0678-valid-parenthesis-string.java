class Solution {
    public boolean checkValidString(String s) {
        // Idea Not My Own Copied ::)
        // TC : O(n)+O(m)
        // SC: O(n)+O(m)
        Stack<Integer> left=new Stack<>();
        Stack<Integer> star =new Stack<>();
        int i=0;
        for(char ch : s.toCharArray()){
            if(ch=='('){
                left.push(i);
                i++;
            }else if(ch=='*'){
                star.push(i);
                i++;
            }else{
                if(left.isEmpty() && star.isEmpty()) return false;
                if(!left.isEmpty()){
                    left.pop();
                }else{
                    star.pop();
                }
                
            }
        }
        while(!left.isEmpty() && !star.isEmpty()){
            if(left.pop()>star.pop()){
                return false;
            }
        }
        return left.isEmpty();
        
    }
}