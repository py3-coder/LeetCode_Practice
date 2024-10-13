class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        // Lets solve ::
        
        PriorityQueue<Triple> pq = new PriorityQueue<>((a,b)->(a.val-b.val));
        int size = nums.size();
        
        int mini =Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
        for(int i=0;i<size;i++){
            pq.offer(new Triple(nums.get(i).get(0),i,0));
            maxi=Math.max(maxi,nums.get(i).get(0));
            mini=Math.min(mini,nums.get(i).get(0));
        }
        int min_range = maxi-mini;
        
        int start=mini;
        int end =maxi;
        while(!pq.isEmpty()){
            Triple tt = pq.poll();
            int col = tt.col+1;
            if(col==nums.get(tt.row).size()){
                break;
            }
            int next_ele = nums.get(tt.row).get(col);
            maxi = Math.max(maxi , next_ele);
            pq.offer(new Triple(next_ele,tt.row,col));
            
            mini =pq.peek().val;
            
            int range = maxi-mini;
            if(min_range>range){
                start = mini;
                end =maxi;
                min_range =range;
            }
        }
        return new int[]{start,end};
    }
    
    public class Triple{
        int val ;
        int row;
        int col;
        
        Triple(int _val,int _row ,int _col){
            this.val = _val;
            this.row = _row;
            this.col = _col;
        }
    }
}