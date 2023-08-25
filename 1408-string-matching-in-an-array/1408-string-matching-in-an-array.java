class Solution {
    public List<String> stringMatching(String[] words) {
        Set<String> set =new HashSet<>();
        ArrayList<String> lis = new ArrayList<>();
        for(String str:words){
            for(String val:words){
                if(val.contains(str)==true && val!=str ){
                    set.add(str);
                }
            }
        }
        lis.addAll(set);
        return lis;
    }
}