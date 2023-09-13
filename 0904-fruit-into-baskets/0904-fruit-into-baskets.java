class Solution {
    public int totalFruit(int[] fruits) {
        int n=fruits.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int start=0,end=0;
        int res=0;
        
        while(end<n){
            map.put(fruits[end],map.getOrDefault(fruits[end],0)+1);
            if(map.size()<2){
                end++;
            }else if(map.size()==2){
                res=Math.max(res,end-start+1);
                end++;
            }else{
                while(map.size()>2){
                    map.put(fruits[start],map.get(fruits[start])-1);
                    if(map.get(fruits[start])==0){
                        map.remove(fruits[start]);
                    }
                    start++;
                }
                end++;
            }
        }
        return res==0?n:res;
    }
}