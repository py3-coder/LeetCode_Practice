class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int ele: nums){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        int count=0;
        for(int val :map.values()){
            if(val==1){
                return -1;
            }
            else if(val ==2){
                count++;
            }
            else if(val==4){
                count+=2;
            }else{
                if(val%3==0){
                    count+= val/3;
                }else if(val%3==2){
                    int rem= val%3;
                    count+=val/3+ rem/2;
                }else{
                    count+=val/3+1;
                }
            }
        }
        return count;
    }
}