class Solution {
    public int integerBreak(int n) {
        if(n==2) return 1;
        if(n==3) return 2;
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=i+1;
        }
        return solveRec(n,arr,n);

        // HashMap<String,Integer> map = new HashMap<>();
        // return solveMemo(n,arr,n,1,map);

        //return solveRecDiff(n);

    }
    public static int solveRec(int n,int[] arr,int target){
        if(n==0 || target==0 ) return 1;
        if(arr[n-1]>target){
            return solveRec(n-1,arr,target);
        }else{
            return Math.max(arr[n-1]*solveRec(n,arr,target-arr[n-1]),solveRec(n-1,arr,target));
        }
    }
    public static int solveMemo(int n,int[] arr,int target,int maxi,HashMap<String,Integer> map ){
        if(n==0 || target==0 ) return maxi;
        String key =n+"n"+target+"t"+maxi+"m";
        if(map.containsKey(key)){
            return map.get(key);
        }
        if(arr[n-1]>target){
            int val=solveMemo(n-1,arr,target,maxi,map);
            map.put(key,val);
            return val;
        }else{
            int val=Math.max(solveMemo(n,arr,target-arr[n-1],maxi*arr[n-1],map),solveMemo(n-1,arr,target,maxi,map));
            map.put(key,val);
            return val;
        }  
    }
    public static int solveRecDiff(int n){
        if(n<=3) return n-1;
        int ans = n;
        for(int i=2;i<n;i++){
            ans= Math.max(ans,i*solveRecDiff(n-i));
        }
        return ans;

    }
}