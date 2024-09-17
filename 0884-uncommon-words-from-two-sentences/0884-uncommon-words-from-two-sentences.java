class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String s = s1 + " " + s2;
        HashMap<String,Integer> map = new HashMap<>();
        String[] words = s.split(" ");
        for(String str : words){
            map.put(str,map.getOrDefault(str,0)+1);
        }
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                res.add(entry.getKey());
            }
        }
        return res.stream().toArray(String[]::new);
        
    }
}