class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len =cost.length;
        int diff=0,stock=0,indx =0;
        for(int i=0;i<len;i++){
            stock +=gas[i]-cost[i];
            if(stock<0){
                diff +=stock;
                stock=0;
                indx =i+1;
            }
        }
        if(stock>=-diff){
            return indx;
        }
        return -1;
    }
}