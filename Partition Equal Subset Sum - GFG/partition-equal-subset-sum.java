//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int[][] memo = new int[101][100001];
    static int equalPartition(int N, int arr[])
    {
        // code here
        //Approch :: Idea-->
        // Since We Know Subset Sum::) So sum of all ele of array if
        // Odd -> Not possible to  Partition Equal subset
        //Even  --> so if we find single subset available the other must::
        // sum/2 = apply subset sum ::
        // Lets start ::
        
        int sum =0;
        for(int ele:arr){
            sum+=ele;
        }
        if(sum%2==1) return 0;
        else{
            sum =sum/2;
            return solveTab(N,arr,sum);
        }
    }
    public static int solvememo(int n,int arr[],int target){
        //Base ::
        if(target==0) return 1;
        if(n==0) return 0;
        
        //check pre-camputed ?
        if(memo[n][target]!=-1){
            return memo[n][target];
        }
        if(arr[n-1]>target){
            //not possible to pick --> Not pick Case ::
            return memo[n][target]=solvememo(n-1,arr,target);
        }else{
            //pick and not pick case::
            return memo[n][target]=Math.max(solvememo(n-1,arr,target-arr[n-1]),solvememo(n-1,arr,target));
        }
    }
    public static int solveTab(int n,int  arr[] ,int target){
        //Base --> initlization
        int tab[][] = new int[n+1][target+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<target+1;j++){
                if(i==0){
                    tab[i][j]=0;
                }
                if(j==0){
                    tab[i][j]=1;
                }
            }
        }
        
        for(int i=1;i<n+1;i++){
            for(int j=1;j<target+1;j++){
                if(arr[i-1]>j){
                    tab[i][j]=tab[i-1][j];
                }else{
                    tab[i][j] =Math.max(tab[i-1][j-arr[i-1]],tab[i-1][j]);
                }
            }
        }
        return tab[n][target];
    }
}