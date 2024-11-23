class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        for(String word : wordList){
            set.add(word);
        }
        
        Queue<Pair> que = new LinkedList<>();
        que.offer(new Pair(beginWord,1));
        set.remove(beginWord);
        
        while(!que.isEmpty()){
            Pair pp = que.poll();
            String curr = pp.word;
            int dist = pp.dist;
            
            if(curr.equals(endWord)){
                return dist;
            }
            for(int i=0;i<curr.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char replace[] =curr.toCharArray();
                    replace[i]=ch;
                    String newreplaced =new String(replace);
                    if(set.contains(newreplaced)){
                        set.remove(newreplaced);
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