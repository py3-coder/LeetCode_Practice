class Solution {
    public List<String> removeSubfolders(String[] folder) {
      Arrays.sort(folder);
        List<String> result = new ArrayList<>();
        
        for(int i=0; i< folder.length; i++){
            String str = folder[i];
            result.add(str);
            String base = str+"/";
            
            while(i+1< folder.length && folder[i+1].startsWith(base)){
                i++;
            }
            
        }
        
        return result;
    }
}