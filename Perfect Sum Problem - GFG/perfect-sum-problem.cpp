//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends

class Solution{
    int mod = 1e9+7;
    	public:
	long long int fun( vector<vector<long long int>> &dp, int v1[], int n, int sum)
	{
        if(n==0){
             if(sum==0) return 1;
             return 0;
        }
        if(dp[n][sum] != -1)return dp[n][sum];
        long long int a=0,b=0;
        if(sum>= v1[n-1]){
            a = (fun(dp,v1,n-1,sum -v1[n-1])%mod +  fun(dp,v1,n-1,sum)%mod )%mod;
            return dp[n][sum] = a;
        }
        else {
             b = fun(dp,v1,n-1,sum)%mod;
             return dp[n][sum] = b;
        }
        
       
	}
	  

	public:
	int perfectSum(int v1[], int n, int sum)
	{
	    vector<vector<long long int>> dp(n+1,vector<long long int>(sum+1,-1));
        return (int)fun(dp,v1,n,sum);
    
	}
	  
};

//{ Driver Code Starts.
int main() 
{
   	
   
   	int t;
    cin >> t;
    while (t--)
    {
        int n, sum;

        cin >> n >> sum;

        int a[n];
        for(int i = 0; i < n; i++)
        	cin >> a[i];

       

	    Solution ob;
	    cout << ob.perfectSum(a, n, sum) << "\n";
	     
    }
    return 0;
}

// } Driver Code Ends