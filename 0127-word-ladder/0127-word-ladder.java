class Solution {
    public int ladderLength(String startWord, String targetWord, List<String> wordList) {
        
        HashSet<String> st = new HashSet<>();
        for(String str :wordList){
            st.add(str);
        }
        Queue<Pair> que = new LinkedList<>();
        que.offer(new Pair(startWord,1));
        st.remove(startWord);
        while(!que.isEmpty()){
            String word =que.peek().word;
            int dist =que.peek().dist;
            que.poll();
            if(word.equals(targetWord) == true) return dist;
            
            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char replace[] =word.toCharArray();
                    replace[i]=ch;
                    String newreplaced =new String(replace);
                    if(st.contains(newreplaced)==true){
                        st.remove(newreplaced);
                        que.offer(new Pair(newreplaced,dist+1));
                    }
                }
            }
        }
        return 0;
        
    }
    static class Pair{
        int dist;
        String word;
        Pair(String _str,int _dist){
            this.word=_str;
            this.dist=_dist;
        }
    }
}