class Solution {
    public int smallestNumber(int n, int t) {
      //  int end = 100 , start = n ;
        for(int i=n;i<101;i++){
            if(isPossible(i,t)){
                return i;
            }
        }
        return 0;
    }
    public boolean isPossible(int temp , int t){
        int digitSum=1;
        while(temp>0){
            digitSum*=(temp%10);
            temp/=10;
        }
        //System.out.println(digitSum+" "+t);
        return (digitSum%t==0)?true:false;
    }
}