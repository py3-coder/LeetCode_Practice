class Solution {
    public int lengthOfLongestSubstring(String s) {
        //Sliding Window--Template ---Varibale Size window....
        int n=s.length();
        int start=0;
        int end=0;
        int maxi=0;
        HashMap<Character,Integer> map =new HashMap<>();
        while(end<n){
            char ch =s.charAt(end);
            map.put(ch,map.getOrDefault(ch,0)+1);
            if(end-start+1==map.size()){
                maxi =Math.max(maxi,end-start+1);
            }else if(end-start+1>map.size()){
                while(end-start+1>map.size()){
                    char cc =s.charAt(start);
                    if(map.get(cc)==1){
                        map.remove(cc);   
                    }
                    else{
                        map.put(cc,map.get(cc)-1);
                    }
                    start++;
                }
                if(end-start+1==map.size()){
                    maxi =Math.max(maxi,end-start+1);
                }
            }
            end++;
        }
        return maxi;
    }
}