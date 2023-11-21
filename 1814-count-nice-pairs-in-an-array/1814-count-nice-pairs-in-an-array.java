class Solution {
    public int countNicePairs(int[] nums) {
        //1st Approch::Broute Force ::
        // TC - O(n*n*log(n))
        // SC - O(1)
        
        //2nd Approch ::
        // TC : 
        // covert the eqn as ::
        // num-rev(num)== num1-rev(num1)
        // keep each in map if more than one means freq >=2 means we found pair::
        long MOD =1000000007;
        HashMap<Integer,Integer> map =new HashMap<>();
        for(int ele :nums){
            int val = ele-reverse(ele);
            map.put(val,map.getOrDefault(val,0)+1);
        }
        //System.out.print(map);
        long res=0;
        for(int val :map.values()){
            if(val==1) continue;
            res = (res+(long)val*(val-1)/2)%MOD;
            res%=MOD;
        }
        return (int)res;
    }
    public static int reverse(int num){
        int x=0;
        while(num>0){
            x =x*10+num%10;
            num/=10;
        }
        return x;
    }
}