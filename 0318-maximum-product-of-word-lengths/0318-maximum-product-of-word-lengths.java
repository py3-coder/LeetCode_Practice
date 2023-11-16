class Solution {
    public int maxProduct(String[] words) {
        //Bit Manupulation way::
        
        int mask[] =new int[words.length];
        for(int i=0;i<words.length;i++){
            int num=0;
            for(char ch:words[i].toCharArray()){
                num = num |(1<<ch-'a');
            }
            mask[i]=num;
        }
        int max=0;
        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                if((mask[i] & mask[j])==0){
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
}