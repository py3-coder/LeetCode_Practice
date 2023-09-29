class Solution {
    public int countPrimes(int n) {
        return sieve(n);
        
    }
    public int sieve(int n){
        int count=0;
        boolean prime[] = new boolean[n];
        for(int i=0;i<n;i++){
            prime[i] =true;
        }
        for(int p=2;p<Math.sqrt(n);p++){
            if(prime[p]==true){
                for(int i=p*p;i<n;i+=p){
                    prime[i] =false;
                }
            }
        }
        for(int j=2;j<n;j++){
            if(prime[j]==true){
                count++;
            }
        }
        return count;
    }
}