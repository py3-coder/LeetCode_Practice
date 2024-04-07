class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        DistjointSet ds = new DistjointSet(n);
        for(int[] e : edges){
				ds.unionBySize(e[0], e[1]);
		}
        List<List<Pair>> adj =new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int[] temp =edges[i];
            adj.get(temp[0]).add(new Pair(temp[1],temp[2]));
        }
        int[] val = new int[n];
		Arrays.fill(val, -1);
        for(int[] ed : edges){
			int r = ds.findPar(ed[0]);
			val[r] &= ed[2];
		}
        int[] ans = new int[query.length];
			for(int i = 0;i < query.length;i++){
				if(query[i][0] == query[i][1]){
					ans[i] = 0;
				}else if(ds.findPar(query[i][0])!=ds.findPar(query[i][1])){
					ans[i] = -1;
				}else{
					ans[i] = val[ds.findPar(query[i][0])];
				}
			}
		return ans;
    }
    // public void dfs(int node,int[] vis,List<List<Pair>> adj){
    //     vis[node]=1;
    //     for(Pair curr : adj.get(node)){
    //         int u = curr.u;
    //         int wt = curr.wt;
    //         ans =ans & wt;
    //         if(vis[u]!=1){
    //             dfs(u,vis,adj);
    //         }
    //     }
    // }
    
}
public class Pair{
        int u;
        int wt;
        Pair(int u,int wt){
            this.u =u;
            this.wt=wt;
        }
    }

class DistjointSet{
    List<Integer> size = new ArrayList<>();
    List<Integer> parent =new ArrayList<>();
    
    public DistjointSet(int n){
        for(int i=0;i<=n;i++){
            size.add(1);
            parent.add(i);
        }
    }
    
    public int findPar(int node){
        if(parent.get(node)==node){
            return node;
        }
        int par =findPar(parent.get(node));
        parent.set(node,par);
        return parent.get(node);
    }
    
    public void unionBySize(int u,int v){
        int utp_u =findPar(u);
        int utp_v =findPar(v);
        
        if(utp_u == utp_v) return;
        
        if(size.get(utp_u)>size.get(utp_v)){
            parent.set(utp_v,utp_u);
            size.set(utp_u,size.get(utp_u)+size.get(utp_v));
        }else{
            parent.set(utp_u,utp_v);
            size.set(utp_v,size.get(utp_u)+size.get(utp_v));
        }
    }
}