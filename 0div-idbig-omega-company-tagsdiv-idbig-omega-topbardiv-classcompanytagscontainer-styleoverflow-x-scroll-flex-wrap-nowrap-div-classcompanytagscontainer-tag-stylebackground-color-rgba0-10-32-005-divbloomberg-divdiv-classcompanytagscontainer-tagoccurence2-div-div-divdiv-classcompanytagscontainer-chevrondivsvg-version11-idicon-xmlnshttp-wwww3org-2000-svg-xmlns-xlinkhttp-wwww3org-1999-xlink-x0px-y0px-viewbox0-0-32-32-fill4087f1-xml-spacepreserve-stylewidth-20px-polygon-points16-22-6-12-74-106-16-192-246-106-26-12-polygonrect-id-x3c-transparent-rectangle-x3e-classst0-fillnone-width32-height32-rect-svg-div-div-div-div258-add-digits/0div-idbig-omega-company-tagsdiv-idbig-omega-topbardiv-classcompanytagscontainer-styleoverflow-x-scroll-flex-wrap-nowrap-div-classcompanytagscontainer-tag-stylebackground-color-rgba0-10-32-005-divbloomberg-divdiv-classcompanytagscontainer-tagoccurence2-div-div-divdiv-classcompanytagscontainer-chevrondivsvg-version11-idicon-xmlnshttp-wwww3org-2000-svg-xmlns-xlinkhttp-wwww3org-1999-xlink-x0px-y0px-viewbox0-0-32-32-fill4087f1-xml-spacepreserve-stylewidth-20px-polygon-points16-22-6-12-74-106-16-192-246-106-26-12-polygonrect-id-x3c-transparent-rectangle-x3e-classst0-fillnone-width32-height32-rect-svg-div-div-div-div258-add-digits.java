class Solution {
    public int addDigits(int num) {
        //int ans =recursionSum(num);
        //return ans;
        //TC : O(log(n))
        //SC: O(1) --> Auxilary Space --> O(log(n))
        
        
        //Iterative ::
        // while(num>9){
        //     int sum=0;
        //     while(num>0){
        //         sum+=num%10;
        //         num/=10;
        //     }
        //     num=sum;
        // }
        // return num;
        
        //TC :  O((log(num))^2)
        //SC: O(1)
        
        
        if(num==0) return 0;
        else if(num%9==0)
          return 9;
        else
          return num%9;
        
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