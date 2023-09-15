class Solution {
    public int addDigits(int num) {
        int ans =recursionSum(num);
        return ans;
        
    }
    public int recursionSum(int num){
        if(num<10){
            return num;
        }
        int sum=0;
        while(num>0){
            sum+=num%10;
            num/=10;
        }
        return recursionSum(sum);
    }
}