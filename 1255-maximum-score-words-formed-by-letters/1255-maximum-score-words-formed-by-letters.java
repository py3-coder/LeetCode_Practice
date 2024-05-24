class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
       int n =words.length;
       int[] cnt = new int[26];
        for(char l :letters){
            cnt[l-'a']++;
        }
        return solveRec(0,words,score,cnt);
        
    }
    public int solveRec(int indx ,String[] words,int[] score,int[] cnt){
        if(indx>=words.length){
            return 0;
        }
        int res=0;
        String w = words[indx];
        int count = 0;
        int i = 0;
        int[] temp = Arrays.copyOf(cnt, cnt.length);
        for (; i < w.length(); i++) {
            char c = w.charAt(i);
            if (temp[c - 'a'] > 0) {
                temp[c - 'a']--;
                count += score[c - 'a'];
            } else {
                break;
            }
        }
        if (i == w.length()) {
            res = Math.max(res, count + solveRec(indx + 1,words,score,temp));
        }
        res = Math.max(solveRec(indx + 1,words,score,cnt), res);
        return res;
    }
}
