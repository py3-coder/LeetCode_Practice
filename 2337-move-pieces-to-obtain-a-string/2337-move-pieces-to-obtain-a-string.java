class Solution {
    public boolean canChange(String start, String target) {
        int i=0,j=0;
        int n= start.length();
        while(i<n || j<n){
            while(i<n && start.charAt(i)=='_'){
               i++;
            }
            while(j<n && target.charAt(j)=='_'){
               j++;
            }
            //System.out.print("i - "+i+" "+"j -"+j+" , ");
            
            if (i == j && i == start.length()) {
                return true;
            }
            
            //both are not equal : 
            if (i == start.length() || j == target.length() || start.charAt(i) != target.charAt(j)) {
                return false;
            }
            
            //both are equal :
            if((target.charAt(j)=='L' && i<j) || (target.charAt(j)=='R' && i>j)){
                return false;
            }
            i++;
            j++;
            
            
        }
        return true;
    }
}