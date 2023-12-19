//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java

class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    // Code Here. 
	    
	    //Lets Make Graph :: Prim's Algo ::)
	    List<List<Pair>> adj =new ArrayList<>();
	    for(int i=0;i<V;i++){
	        adj.add(new ArrayList<>());
	    }
	    for(int i=0;i<edges.length;i++){
	        adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
	        adj.get(edges[i][1]).add(new Pair(edges[i][0],edges[i][2]));
	    }
	    
	    PriorityQueue<Triple> pq =new PriorityQueue<>((a,b)->(a.wt-b.wt));
	    
	    int sum=0;
	    int[] vis =new int[V];
	    
	    pq.offer(new Triple(0,0,-1));
	    
	    while(!pq.isEmpty()){
	        int wt =pq.peek().wt;
	        int node =pq.peek().node;
	        int pnode =pq.peek().pnode;
	        pq.poll();
	        
	        if(vis[node]==1){
	            continue;
	        }
	        vis[node] =1;
	        sum+=wt;
	        
	        for(Pair curr : adj.get(node)){
	            int ewt =curr.dist;
	            int currNode =curr.node;
	            if(vis[currNode]!=1){
	                pq.offer(new Triple(ewt,currNode,node));
	            }
	        }
	    }
	    return sum;
	}
	static class Pair{
	    int dist;
	    int node;
	    
	    Pair(int _node,int _dist){
	        this.dist =_dist;
	        this.node =_node;
	    }
	}
	static class Triple{
	    int wt;
	    int node;
	    int pnode;
	    Triple(int _wt,int _node,int _pnode){
	        this.wt =_wt;
	        this.node=_node;
	        this.pnode=_pnode;
	    }
	}
}