class Solution {
    public static List<List<String>> partition(String str) {
        // Write your code here.
        List<List<String>> ans = new ArrayList<>();
        solveRecursion(str,0,ans,new ArrayList<>());
        return ans;

    }
    public static void solveRecursion(String str,int indx,List<List<String>> ans,List<String> temp){
        if(indx==str.length()){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=indx;i<str.length();i++){
            if(isPalindrome(str,indx,i)){
                temp.add(str.substring(indx,i+1));
                solveRecursion(str,i+1,ans,temp);
                temp.remove(temp.size()-1);
            }
        }

    }
    static boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }

}