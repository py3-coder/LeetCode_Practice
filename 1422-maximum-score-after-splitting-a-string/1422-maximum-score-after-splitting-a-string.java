class Solution {
    public int maxScore(String s) {
        int rightOnes = 0, leftZeroes = 0;
        for(char c: s.toCharArray())
            if(c=='1') rightOnes++;
        int score = 0;
        for(int i=0; i<s.length()-1; i++){
            if(s.charAt(i)=='0') leftZeroes++;
            else rightOnes--;
            score = Math.max(score, leftZeroes + rightOnes);
        }
        return score;
    }
    
}