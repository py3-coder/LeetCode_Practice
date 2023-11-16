class Solution {
    public String findDifferentBinaryString(String[] nums) {
        // Approch :: 
        // 1. Sort the nums array.
        // 2. Traverse the array and check the value with i
        // 3. Break if not match convt. i to binary string:
        // 4. if loop does'nt break means the last will ans so just convert the nums.length into binary::

        // TC :O(nlogn) +O(logn)*O(logn)
        // SC :O(1)
        // Arrays.sort(nums);
        // int n =nums[0].length();
        // String res ="";
        // for(int i=0;i<(1<<n);i++){
        //     if(i<nums.length && i!=binarytoInt(nums[i])){
        //         res =inttoBinary(i,n);
        //         return res;
        //     }
        // }
        // res =inttoBinary(nums.length,n);
        // return res;

        // Optimal Approch ::
        // Idea take opp each char --> diagonal :: 
        // TC : O(n)
        // SC : O(1)
        String res ="";
        for(int i=0;i<nums.length;i++){
            char curr =nums[i].charAt(i);
            char opp = (curr=='0')?'1':'0';
            res +=opp;
        }
        return res;
    }
    public static int binarytoInt(String str){
        int num=0;
        int cnt=0;
        for(int i=str.length()-1;i>=0;i--){
            if(str.charAt(i)=='1'){
                num +=(int)(Math.pow(2,cnt));
            }
             cnt++;
        }
        return num;
    }
    public static String inttoBinary(int i,int n){
        StringBuilder sb =new StringBuilder();
        for(int j=0;j<n;j++){
            if((i&1)==1){
                sb.append('1');
            }else{
                sb.append('0');
            }
            i>>=1;
        }
        sb.reverse();
        return sb.toString();
    }
}