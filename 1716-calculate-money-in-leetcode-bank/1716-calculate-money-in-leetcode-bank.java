class Solution {
    public int totalMoney(int n) {
        // int rem =n%7;
        // int num=n/7;
        // int sum=0;
        // for(int j=num+1;j<=num+rem;j++){
        //     sum+=j;
        // }
        // while(num>0){
        //     for(int i=num;i<num+7;i++){
        //         sum+=i;
        //     }
        //     num--;
        // }
        // return sum;
        
        //Pattern : Copied :: Logic 
        int extra = n%7, weeks = n/7;
        return 28 * weeks + 7 * (weeks)*(weeks-1)/2 + weeks*extra + (extra)*(extra+1)/2;
    }
}