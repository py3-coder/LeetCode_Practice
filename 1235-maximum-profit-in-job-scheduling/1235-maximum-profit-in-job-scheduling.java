class Solution {
    static HashMap<Integer,Integer> map;
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {        
        List<Triple> triple =new ArrayList<>();
        int n=startTime.length;
        for(int i=0;i<n;i++){
           // System.out.println(startTime[i]+":"+endTime[i]);
            triple.add(new Triple(startTime[i],endTime[i],profit[i]));
        }
        
        //sort on basis on startTime :: if start is same then endtime ::
        Collections.sort(triple,(a,b)->(a.start==b.start)?(a.end-b.end):(a.start-b.start));
        map =new HashMap<>();
        return solveMemoOptimised(0,triple,n);
    }
    public static int solveMemoOptimised(int indx,List<Triple> tp,int n){
        //Base Case::
        if(indx == n) return 0;
        if(map.containsKey(indx)){
            return map.get(indx);
        }
        // Choices we have ::: pick or not pick
        
        int next =getNextIndx(tp,indx,n);
        int pick =tp.get(indx).profit+solveMemoOptimised(next,tp,n);
        
        int notPick =solveMemoOptimised(indx+1,tp,n);
        map.put(indx,Math.max(pick,notPick));
        return Math.max(pick,notPick);
        
    }
    // Previous Approch : getting tle ::
     // public static int solveMemo(int indx,int lasttime,List<Triple> tp){
    //     //Base Case::
    //     if(indx == tp.size()) return 0;
    //     // Choices we have ::: pick or not pick
    //     String key = indx+"-"+lasttime;
    //     if(map.containsKey(key)){
    //         return map.get(key);
    //     }
    //     int pick =0,notPick=0;
    //     // need to optimise --> TLE ::
    //     if(lasttime<=tp.get(indx).start){
    //         pick =tp.get(indx).profit+solveMemo(indx+1,tp.get(indx).end,tp);
    //     }
    //     notPick =solveMemo(indx+1,lasttime,tp);
    //     map.put(key,Math.max(pick,notPick));
    //     return Math.max(pick,notPick);
    // }
    public static int getNextIndx(List<Triple> tp,int indx,int n){
        int l=indx+1;
        int h=n-1;
        int ans=n;
        
        while(l<=h){
            int mid =l+(h-l)/2;
            if(tp.get(mid).start>=tp.get(indx).end){
                ans =mid;
                h =mid-1;
            }else{
                l =mid+1;
            }
        }
        return ans;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    class Triple{
        int start;
        int end;
        int profit;
        
        Triple(int s,int e,int p){
            this.start =s;
            this.end =e;
            this.profit =p;
        }
    }
}