//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int[][] memo = new int[101][100001];
    static Boolean isSubsetSum(int N, int arr[], int sum){
        // Lets Play With Recursion :::
        //1. Recursion Call ::
        //return solveRec(N,arr,sum);
        //2.Memo Call ::
        Arrays.stream(memo).forEach(a -> Arrays.fill(a, -1));
        return solvememo(N,arr,sum)==1?true:false;
        
        
    }
    public static boolean solveRec(int n,int arr[],int target){
        //Base ::
        if(target==0) return true;
        if(n==0) return false;
        
        if(arr[n-1]>target){
            //not possible to pick --> Not pick Case ::
            return solveRec(n-1,arr,target);
        }else{
            //pick and not pick case::
            return solveRec(n-1,arr,target-arr[n-1]) || solveRec(n-1,arr,target);
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
    
    
}