class Solution {
    // TC : O(n)
    // SC : O(n)
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int start=0;
        for(int i=0;i<spaces.length; i++){
            sb.append(s.substring(start,spaces[i]));
            sb.append(" ");
            start=spaces[i];
        }
        sb.append(s.substring(start,s.length()));
        return sb.toString();
    }
}