class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int len =tokens.length;
        if(len == 0) return 0;
        Arrays.sort(tokens);
        int left =0,right =len-1;
        int score=0,ans=0;
        while(left<=right){
            if(power>=tokens[left]){
                power -=tokens[left++];
                score++;
                if(score>ans) ans =score;
                
            }
            else if(score>=1){
                power +=tokens[right--];
                score--;
            }
            else{
                break;
            }
        }
        return ans;
    }
}