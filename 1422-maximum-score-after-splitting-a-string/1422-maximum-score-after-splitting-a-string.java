class Solution {
    public int maxScore(String s) {
        int score=0;
        
        for(int i=0;i<s.length()-1;i++){
            String left = s.substring(0,i+1);
            
            String right =s.substring(i+1);
            score =Math.max(score , cntZero(left)+cntOne(right));
        }
        return score;
    }
    public int cntZero(String str){
        int cnt=0;
        for(int i=0;i<str.length();i++){
              if(str.charAt(i) == '0'){
                  cnt++;
              }
        }
        return cnt;
    }
    public int cntOne(String str){
        int cnt=0;
        for(int i=0;i<str.length();i++){
              if(str.charAt(i) == '1'){
                  cnt++;
              }
        }
        return cnt;
    }
}