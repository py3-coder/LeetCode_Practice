class Solution {
    public int commonFactors(int a, int b) {
        //Broute Force ::
        // int num =a>b?a:b;
        // int count=0;
        // for(int i=1;i<=num;i++){
        //     if(a%i==0 && b%i==0){
        //         count++;
        //     }
        // }
        // return count;
        //TC : O(n)
        //SC :O(1)
        
//         int count=0;
//         int num=gcd(a,b);
//         for(int i=1;i<=num;i++){
//             if(a%i==0 && b%i==0){
//                 count++;
//             }
//         }
//         return count;
        
        //TC : O(log(min(a,b)))+O(log(min(a,b)))
        //SC : O(1)
        
        
        int count=0;
        int num=gcd(a,b);
        for(int i=1;i<=Math.sqrt(num);i++){
            if(num%i==0){
                if(i*i==num){
                    count+=1;
                }else{
                    count+=2;
                }
            }
        }
        return count;
        
    }
    public static int gcd(int a,int b){
        return a==0?b:gcd(b%a,a);
    }
    
}