//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[], int N) {
        // code here
        
        // Lets Play :::
        // Broute Force :: 
        // Take a map store all find the ele with freq =2;;
        //take array mark the ele who so ever is present pick who is absent
        //You both x and y (x-missing one , y reapeating one::)
        
        // TC : O(n)+O(n)+O(n)
        //SC: O(n)+O(n)
        
        // Optimal .. 
        //Make a rray of n mark the freq for every ele ..
        //Traverse after that and check whose freq=0 and freq=2 got it;;
        // TC : O(n)+O(n)
        //Sc :O(n)
        
        
        //Best Approch ::
        // since we need to find 2 value .. let suppose x is missing and y be repeating::
        // S - Sn == X-Y  ----1
        // S^2 -S(n)^2 = X^2-Y^2::
        // (X+Y)(X-Y) == X^2-Y^2::
        //Since by this we can get X+Y -- 2
        //Solve 1 and 2 you get what you want::
        
        // long S=0,S2=0;
        // for(int i=0;i<n;i++){
        //     S +=arr[i];
        //     S2+=(long)arr[i]*(long)arr[i];
        // }
        // long SN = (n * (n + 1)) / 2;
        // long S2N = (n * (n + 1) * (2 * n + 1)) / 6;
        
        // int val1 =(int)S - (int)SN;
    
        // int val2 =(int)S2 -(int)S2N;
        // val2 = val2/val1;
        
        // int x =(val1+val2)/2;
        // int y=x-val1;
        
        // return new int[]{x,y};
        long n =N ;

        long nsum = (n*(n+1))/2;

        long nsq_sum = (n*(n+1)*(2*n+1)) / 6;

        long csum = 0;

        long csq_sum = 0;

        for(long x:arr){

            csum+=x;

            csq_sum+=x*x;

        }

        long df = nsum-csum;

        long sm = (nsq_sum-csq_sum)/df;

        int[] res = new int[2];

        res[1] = (int) ((sm+df)/2);

        res[0] = (int) ((sm-df)/2);

        

        return res;
        
        
    }
}