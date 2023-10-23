class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        // Recursion::
        Set<String> set = new HashSet<>(wordDict);
        //return solveRec(s,set);

        //Memoisation::)
        HashMap<String,Boolean> map =new HashMap<>();
        return solveMemo(s,set,map);

        
    }
    public static boolean solveRec(String s,Set<String> set){
        int len =s.length();
        if(len==0) return true;
        
        for(int i=1;i<=len;i++){
            if(set.contains(s.substring(0,i)) && solveRec(s.substring(i),set)){
                return true;
            }
        }
        return false;
    }
    public static boolean solveMemo(String s,Set<String> set,HashMap<String,Boolean> map){
        int len=s.length();
        if(len==0) return true;
         if(map.containsKey(s)) return map.get(s);
        for(int i=1;i<=len;i++){
            if(set.contains(s.substring(0,i)) && solveMemo(s.substring(i),set,map)){
                map.put(s.substring(0,i),true);
                return true;
            }
        }
        map.put(s,false);
        return false;
    }
}