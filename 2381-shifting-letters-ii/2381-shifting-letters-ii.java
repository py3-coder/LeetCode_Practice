class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        //sweep line algo
        char[] ch = s.toCharArray();
        int[] line = new int[s.length()+1];
        
        for(int[] shift : shifts){
            int val = shift[2]==1?1:-1;
            line[shift[0]]+=val;
            line[shift[1]+1]-=val;
        }
        int sum=0;
        for(int i=0;i<line.length-1;i++){
            sum+=line[i];
            int newChar = ((ch[i] - 'a') + sum) % 26;
            if(newChar < 0) newChar+= 26;
            ch[i] =  (char)('a' + newChar);
        }
        
        return String.valueOf(ch);
    }
}