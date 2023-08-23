class Solution {
    public int maximumWealth(int[][] accounts) {
        int m = accounts.length;
        int n =accounts[0].length;
        int maxi=-1;
        for(int i=0;i<m;i++){
            int temp=-1;
            int sum=0;
            for(int j=0;j<n;j++){
                sum+=accounts[i][j];
            }
            if(sum>temp){
                temp=sum;
            }
            if(temp>maxi){
                maxi =temp;
            }
        }
        return maxi;
    }
}