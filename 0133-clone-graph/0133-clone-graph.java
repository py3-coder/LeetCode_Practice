/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        Node cpy = new Node(node.val);
        Node[]  vis =new Node[101];
        Arrays.fill(vis,null);
        dfs(node,cpy,vis);
        return cpy;
    }
    public void dfs(Node node,Node cpy,Node[] vis){
        vis[cpy.val] =cpy;
        
        for(Node n :node.neighbors){
            if(vis[n.val]==null){
                Node newnode =new Node(n.val);
                cpy.neighbors.add(newnode);
                dfs(n,newnode,vis);
            }else{
                cpy.neighbors.add(vis[n.val]);
            }
        }
    }
}