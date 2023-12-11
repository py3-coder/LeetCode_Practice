//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        ArrayList<ArrayList<Integer>> adjLs =new ArrayList<>();
        for(int i=0;i<V;i++){
            adjLs.add(new ArrayList<>());
        }
        
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(adj.get(i).get(j) == 1 && i!=j){
                    adjLs.get(i).add(j);
                    adjLs.get(j).add(i);
                }
            }
        }
        //System.out.print(adjLs);
        int vis[] = new int[V];
        int cnt=0;
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                cnt++;
                dfs(i,vis,adjLs);
            }
        }
        return cnt;
    }
    static void dfs(int node,int vis[],ArrayList<ArrayList<Integer>> adj){
        vis[node] =1;
        for(int nodes:adj.get(node)){
            if(vis[nodes]==0){
                dfs(nodes,vis,adj);
            }
        }
    }
};