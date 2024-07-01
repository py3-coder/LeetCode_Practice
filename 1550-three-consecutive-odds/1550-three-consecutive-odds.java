class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int cnt=0;
        for(int ele : arr){
            
            //(cnt%2==0)?
            if(ele%2==0){
                cnt=0;
            }else{
                cnt+=1;
                
                if(cnt == 3){
                    return true;
                }
            }
        }
        return false;
    }
}