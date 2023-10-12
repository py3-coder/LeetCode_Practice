//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.countWays(N, S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int memo[][][] = new int[201][201][2];
    static int mod=1003;
    static int countWays(int N, String S){
        // 1. Recursion :: IMP Question & Tough too
        //return solveRec(S,0,N-1,true);
        for(int f[][]:memo){
            for(int[] i:f){
                Arrays.fill(i,-1);
            }
        }
        return solveMemo(S,0,N-1,true);
        
        
    }
    public static int solveRec(String str,int i,int j,boolean istrue){
        //Base Case::
        if(i>j) return 0;
        if(i==j)
        { 
            if(istrue) 
            return str.charAt(i)=='T'?1:0; 
            else 
            return str.charAt(i)=='F'?1:0;  
        }
        int ans=0;
        for(int k=i+1;k<j;k+=2){
            int lt=solveRec(str,i,k-1,true);
            int lf=solveRec(str,i,k-1,false);
            int rt=solveRec(str,k+1,j,true);
            int rf=solveRec(str,k+1,j,false);
            
            if(str.charAt(k)=='|'){
                if(istrue==true){
                    ans+=(lt*rt)+(lt*rf)+(rt*lf);
                }else{
                    ans+= lf*rf;
                }
            }else if(str.charAt(k)=='&'){
                if(istrue==true){
                    ans+=(lt*rt);
                }else{
                    ans+=(lt*rf)+(rt*lf)+(lf*rf);
                }
            }else if(str.charAt(k)=='^'){
                if(istrue==true){
                    ans+=(lt*rf)+(rt*lf);
                }else{
                    ans+=(lf*rf)+(lt*rt);
                }
            }
        }
        return ans%mod;
    }
    public static int solveMemo(String str,int i,int j,boolean istrue){
        //Base Case::
        if(i>j) return 0;
        if(i==j)
        { 
            if(istrue) 
            return str.charAt(i)=='T'?1:0; 
            else 
            return str.charAt(i)=='F'?1:0;  
        }
        if(memo[i][j][istrue==true?1:0]!=-1){
            return memo[i][j][istrue==true?1:0]%mod;
        }
        int ans=0;
        for(int k=i+1;k<j;k+=2){
            int lt=solveMemo(str,i,k-1,true);
            int lf=solveMemo(str,i,k-1,false);
            int rt=solveMemo(str,k+1,j,true);
            int rf=solveMemo(str,k+1,j,false);
            
            if(str.charAt(k)=='|'){
                if(istrue==true){
                    ans+=(lt*rt)+(lt*rf)+(rt*lf);
                }else{
                    ans+= lf*rf;
                }
            }else if(str.charAt(k)=='&'){
                if(istrue==true){
                    ans+=(lt*rt);
                }else{
                    ans+=(lt*rf)+(rt*lf)+(lf*rf);
                }
            }else if(str.charAt(k)=='^'){
                if(istrue==true){
                    ans+=(lt*rf)+(rt*lf);
                }else{
                    ans+=(lf*rf)+(lt*rt);
                }
            }
        }
        ans%=mod;
        memo[i][j][istrue==true?1:0]=ans;
        return ans%mod;
    }
}