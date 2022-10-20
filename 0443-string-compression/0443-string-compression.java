class Solution {
    public int compress(char[] chars) {
        StringBuilder ans = new StringBuilder();
        ans.append(chars[0]);
        int count=1;
        for(int i=1;i<chars.length;i++){
            char curr = chars[i];
            char prev = chars[i-1];
            if(prev==curr){
                count+=1;
            }else{
                if(count>1){
                    ans.append(count);
                    count=1;
                }
                ans.append(curr);
            }
        }
        if(count>1){
            ans.append(count);
        }
        for(int i=0;i<ans.length();i++){
            chars[i] = ans.charAt(i);
        }
        return ans.length();
    }
}