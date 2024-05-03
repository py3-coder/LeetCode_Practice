class Solution {
    public int compareVersion(String version1, String version2) {
        List<String> ver1 = new ArrayList<>(Arrays.asList(version1.split("[.]")));
        List<String> ver2 = new ArrayList<>(Arrays.asList(version2.split("[.]")));
        
        // revison is missing is anyone:-
        if(ver1.size()<ver2.size()){
            for(int j=ver1.size();j<ver2.size();j++){
                ver1.add("0");
            }
        }else if(ver1.size()>ver2.size()){
            for(int j=ver2.size();j<ver1.size();j++){
                ver2.add("0");
            }
        }
        
        for(int i=0;i<ver1.size();i++){
            int v1 = Integer.valueOf(ver1.get(i));
            int v2 = Integer.valueOf(ver2.get(i));

            if(v1>v2){
                return 1;
            }else if(v2>v1){
                return -1;
            }
        }
        return 0;
    }
}