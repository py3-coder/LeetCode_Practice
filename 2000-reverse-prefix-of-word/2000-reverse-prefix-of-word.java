class Solution {
    public String reversePrefix(String word, char ch) {
        StringBuilder sb = new StringBuilder();
        int mark=-1;
        for(int i=0;i<word.length();i++){
            if(word.charAt(i)==ch){
                mark=i;
                sb.append(word.charAt(i));
                break;
            }
            sb.append(word.charAt(i));
        }
        if(mark==-1){
            return word;
        }
        sb.reverse();
        sb.append(word.substring(mark+1));
        return sb.toString();
    }
}