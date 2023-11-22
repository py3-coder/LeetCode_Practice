//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class GfG {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Item(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            System.out.println(String.format("%.2f", new Solution().fractionalKnapsack(w, arr, n)));
        }
    }
}
// } Driver Code Ends


/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        // Your code here
        Comparator<Item> comp = new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                double ratio1 = (double)o1.value/o1.weight;
                double ratio2 = (double)o2.value/o2.weight;
                if(ratio1<ratio2){
                    return 1;
                }else{
                    return -1;
                }
            }
        };
        
        double profit=0;
        Arrays.sort(arr ,comp);
        for(int i=0;i<arr.length;i++){
            if(W==0) break;
            else if(W>=arr[i].weight){
                profit+=arr[i].value;
                W-=arr[i].weight;
            }else if(W>0){
                double val =(double)arr[i].value/arr[i].weight;
                profit +=val*W;
                break;
            }
        }
        return profit;
    }
}