class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        HashSet<String> set = new HashSet<>();
        dictionary.forEach(str -> set.add(str));
        
        String[] st = sentence.split(" ");
        for( int  i=0; i<st.length ;i++){
            for(int j=0;j<st[i].length();j++){
                String root = st[i].substring(0,j);
                if(set.contains(root)){
                    st[i] = root;
                }
            }
        }
        return String.join(" ", st);
    }
}