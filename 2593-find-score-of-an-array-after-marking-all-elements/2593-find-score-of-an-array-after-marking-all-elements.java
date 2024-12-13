class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        boolean[] vis = new boolean[n];
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->(a.val==b.val)?(a.pos-b.pos):(a.val-b.val));
        for(int i=0;i<n;i++){
            pq.offer(new Pair(nums[i],i));
        }
        long sum=0;
        while(!pq.isEmpty()){
            Pair pp = pq.poll();
            int indx =pp.pos ;
            if(vis[indx] != true){
                sum+=pp.val;
                if(indx==0){
                    vis[indx+1] = true;
                }else if(indx == n-1){
                    vis[indx-1] = true;
                }else{
                    vis[indx+1]=true;
                    vis[indx-1]=true;
                }
            }
        }
        return sum;
    }
}
class Pair{
    int val;
    int pos;

    Pair(int _val , int _pos){
        this.val =_val;
        this.pos =_pos;
    }
}