class Solution {
    static int memo[][] = new int[102][102];
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int arr[]= new int[cuts.length+2];
        arr[0]=0; arr[arr.length-1]=n;
        for(int i=0;i<cuts.length;i++){
            arr[i+1] =cuts[i];
        }
        //return solveRec(arr,1,cuts.length);
        
        Arrays.stream(memo).forEach(a->Arrays.fill(a,-1));
        return solveMemo(arr,1,cuts.length);
        
    }
    public static int solveRec(int arr[],int i,int j){
        //Base Case::
        if(i>j) return 0; 
        int ans =Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
                int temp = solveRec(arr,i,k-1)+ solveRec(arr,k+1,j)+(arr[j+1]-arr[i-1]);
                ans =Math.min(temp,ans);
        }
        return  ans;
    }
    public static int solveMemo(int arr[],int i,int j){
        //Base Case::
        if(i>j) return 0; 
        if(memo[i][j]!=-1){
            return memo[i][j];
        }
        int ans =Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
            int left,right;
            if(memo[i][k-1]!=-1){
                left=memo[i][k-1];
            }else{
                left =solveMemo(arr,i,k-1);
                memo[i][k-1]=left;
            }
            if(memo[k+1][j]!=-1){
                right=memo[k+1][j];
            }else{
                right=solveMemo(arr,k+1,j);
                memo[k+1][j] =right;
            }
            int temp = left+right+(arr[j+1]-arr[i-1]);
            ans =Math.min(temp,ans);
            memo[i][j]=ans;
        }
        return  memo[i][j]=ans;
    }
}