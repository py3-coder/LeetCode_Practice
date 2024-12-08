class Solution {
    public static HashMap<String,Integer> map;
    public int maxTwoEvents(int[][] events) {
        // DP :-
        Arrays.sort(events ,(a,b)->a[0]==b[0]?b[2]-a[2]:a[0]-b[0]);
        map = new HashMap<>();
        return solve(0,0,events);
        
    }
    public int solve(int indx ,int k , int[][] events){
        if(indx==events.length || k==2){
            return 0;
        }
        String key = indx+"*"+k;
        // mem0 ::
        if(map.containsKey(key)){
            return map.get(key);
        } 
        int next =getNextIndx(events,indx);
        int pick=0;
        if(k<2){
            pick = events[indx][2] + solve(next,k+1,events);
        }
        int notpick = solve(indx+1,k,events);
        map.put(key , Math.max(pick , notpick));
        
        return Math.max(pick , notpick);
    }
    public static int getNextIndx(int[][] events ,int indx){
        
        int l=indx+1;
        int h=events.length-1;
        int ans=events.length;
        
        while(l<=h){
            int mid =l+(h-l)/2;
            if(events[mid][0]>events[indx][1]){
                ans =mid;
                h =mid-1;
            }else{
                l =mid+1;
            }
        }
        return ans;
    }
}
