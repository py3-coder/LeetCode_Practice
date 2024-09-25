class Solution {
    private class TrieNode{
    TrieNode[]children;
    boolean isEnd;
    int pre_count=0;

    TrieNode(){
            children=new TrieNode[26];
            isEnd=false;
        }
    }

    private TrieNode root;

    private void insert_word(String s){
        TrieNode curr=root;

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);

            if(curr.children[ch-'a']==null){
                curr.children[ch-'a']=new TrieNode();
            }

            curr=curr.children[ch-'a'];
            curr.pre_count++;   
        }

        curr.isEnd=true;
    }

    private int start_word_prefix(String s){

        TrieNode curr=root;
        int count=0;

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);

            if(curr.children[ch-'a']==null)break;

            curr=curr.children[ch-'a'];
            count+=curr.pre_count;
        }

        return count;
    }

    public int[] sumPrefixScores(String[] words) {
        int n=words.length;
        int i=0;

        int[]res=new int[n];

        root=new TrieNode();

        for(String word:words)insert_word(word);

        for(String word:words){
            int count=start_word_prefix(word);
            res[i++]=count;
        }

        return res;
    }
    
}


