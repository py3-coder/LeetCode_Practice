class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] freq = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
        }
        StringBuilder op = new StringBuilder();
        int prev=-1;
        for(int i=25;i>=0;i--){
            
            if(op.length()>=s.length()){
                break;
            }
            if(freq[i]==0) continue;
         
            if(op.length()>0 && op.charAt(op.length()-1)!=(char)('a' + i) && prev!=-1){
                op.append((char)('a' + i));
                freq[i]--;
                
                i=prev;
            }
            
            if(freq[i]<=repeatLimit){
                op.append(genrate(freq[i],(char)('a' + i)));
                freq[i]=0; 
                prev=-1;
            }
            else if(freq[i]>repeatLimit){
                freq[i]-=repeatLimit;
                op.append(genrate(repeatLimit,(char)('a' + i)));
                
                prev=i;
            }
        }
        return  op.toString();
    }
    public String genrate(int k,char c){
        String key="";
        while(k-->0){
            key+=c;
        }
        return key;
    }
}