//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for(int t=0;t<testCases;t++){
		    int n = sc.nextInt();
		    int arr[] = new int[n];
		    for(int i=0;i<n;i++){
		        arr[i] = sc.nextInt();
		    }
		    Arrays.sort(arr);
		    ArrayList <ArrayList<Integer>> res = new solve().AllSubsets(arr,n);
		    for (int i = 0; i < res.size (); i++)
		    {
		        System.out.print ("(");
		        for (int j = 0; j < res.get(i).size (); j++)
		        {
		            if (j != res.get(i).size()-1)
		                System.out.print ((res.get(i)).get(j) + " ");
		            else
		                System.out.print ((res.get(i)).get(j));
		        }
		        System.out.print (")");
		      
		    }
		    System.out.println();
		}
	}
}
// } Driver Code Ends


class solve
{
    //Function to find all possible unique subsets.
    public static ArrayList <ArrayList <Integer>> AllSubsets(int arr[], int n)
    {
        // your code here
        Arrays.sort(arr);
        LinkedHashSet<ArrayList<Integer>> res = new LinkedHashSet<>();
        ArrayList<Integer> op = new ArrayList<>();
        //call
        res.add(op);
        uniqueSubset(arr,0,res,op);
        //System.out.println(subset);
        return new ArrayList<>(res);
    }
    public static void  uniqueSubset(int arr[],int indx,LinkedHashSet<ArrayList<Integer>> res,ArrayList<Integer> op){
        //Base Case ::
        if(indx==arr.length){
            return;
        }
        //pick 
        op.add(arr[indx]);
        res.add(new ArrayList<Integer>(op));
        uniqueSubset(arr,indx+1,res,op);
        //not pick case :: just remove last ele from op::
        op.remove(op.size()-1);
        uniqueSubset(arr,indx+1,res,op);
    }
}
