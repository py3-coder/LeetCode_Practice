class Solution {
    public boolean canChange(String s, String t) {
        // TC - O(n)
        // SC -(1)
        int i=0,j=0;
        int n= s.length();
        while(i<n || j<n){
            while(i<n && s.charAt(i)=='_'){
               i++;
            }
            while(j<n && t.charAt(j)=='_'){
               j++;
            }
            //System.out.print("i - "+i+" "+"j -"+j+" , ");
            
            if (i == j && i == n) {
                return true;
            }
            
            //both are not equal : 
            if (i == n || j == n || s.charAt(i) != t.charAt(j)) {
                return false;
            }
            
            //both are equal :
            if((t.charAt(j)=='L' && i<j) || (t.charAt(j)=='R' && i>j)){
                return false;
            }
            i++;
            j++;
            
            
        }
        return true;
    }
}