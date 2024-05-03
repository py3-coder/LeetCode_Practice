class Solution {
    public int compareVersion(String version1, String version2) {
        // TC : O(N) 
        // SC : O(2N)
//         List<String> ver1 = new ArrayList<>(Arrays.asList(version1.split("[.]")));
//         List<String> ver2 = new ArrayList<>(Arrays.asList(version2.split("[.]")));
        
        
//         for(int i=0;i<Math.max(ver1.size(),ver2.size());i++){
//             int v1 = i<ver2.size()?Integer.valueOf(ver1.get(i)):0;
//             int v2 = i<ver2.size()?Integer.valueOf(ver2.get(i)):0;

//             if(v1>v2){
//                 return 1;
//             }else if(v2>v1){
//                 return -1;
//             }
//         }
//         return 0;
        
        
        
        
        
        
        int temp1 = 0,temp2 = 0;
        int len1 = version1.length(),len2 = version2.length();
        int i = 0,j = 0;
        while(i<len1 || j<len2) {
            temp1 = 0;
            temp2 = 0;
            while(i<len1 && version1.charAt(i) != '.') {
                temp1 = temp1*10 + version1.charAt(i++)-'0';

            }
            while(j<len2 && version2.charAt(j) != '.') {
                temp2 = temp2*10 + version2.charAt(j++)-'0';

            }
            if(temp1>temp2) return 1;
            else if(temp1<temp2) return -1;
            else {
                i++;
                j++;

            }

        }
        return 0;
        }
}