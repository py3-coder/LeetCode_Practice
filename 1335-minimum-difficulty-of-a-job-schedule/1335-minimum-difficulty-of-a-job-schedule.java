class Solution {
    static HashMap<String,Integer> map;
    public int minDifficulty(int[] jobDifficulty, int d) {
        //Edges Case ::
        
        //Recursion -- TLE ::
        // Memoization ::
        
        
        int sum=0;
        for(int ele:jobDifficulty){
            sum+=ele;
        }
        if(d ==jobDifficulty.length){
            return sum;
        }
        if(d>jobDifficulty.length){
            return -1;
        }
        //rec. ::
        //int res =solveJob(0,jobDifficulty,0,d);
        
        // memo ::
        map =new HashMap<>();
        int res =solveJob(0,jobDifficulty,0,d);
        return res;
    }
    public static int solveJob(int i,int[] arr,int maxTill,int d){
        //Base Case ::
         if(d==0 && i==arr.length) return 0;
        if(d==0 || i==arr.length) return 10000;
        String key =i+":"+maxTill+":"+d;
        if(map.containsKey(key)){
            return map.get(key);
        }
        int solve =Math.max(arr[i],maxTill)+ solveJob(i+1,arr,0,d-1);
        maxTill = Math.max(arr[i],maxTill);
        int notSolve = solveJob(i+1,arr,maxTill,d);
        
        map.put(key,Math.min(solve,notSolve));
        return Math.min(solve,notSolve);
        
    }
}