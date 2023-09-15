//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            long ans = ob.prime_Sum(n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution
{
    public long prime_Sum(int n)
    {
        // code here
        //Broute Force ::
        // long sum=0;
        // for(int i=1;i<=n;i++){
        //     sum+=checkprime(i);
        // }
        // return sum;
        // TC : O(nlogn)
        //SC : O(1) 
        
        //Sieve of Eratathonoes  -- TC - O(n*log(logn))
        //SC : O(n)
        return sieve(n);
    }
    public static long checkprime(int num){
        if(num==1) return 0;
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0){
                return 0;
            }
        }
        return num;
    }
    
    public  static long sieve(int num){
        long sum=0;
        boolean prime[] = new boolean[num+1];
        for(int i=0;i<=num;i++){
            prime[i] =true;
        }
        for(int p=2;p<=Math.sqrt(num);p++){
            if(prime[p] ==true){
                for(int i=p*p;i<=num;i+=p){
                    prime[i] =false;
                }
            }
        }
        for(int i=2;i<=num;i++){
            if(prime[i]==true){
                sum+=i;
            }
        }
        return sum;
    }
}