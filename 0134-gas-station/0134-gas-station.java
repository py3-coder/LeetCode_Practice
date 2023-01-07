class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum=0;
        for(int i=0;i<gas.length;i++){
            sum+=gas[i]-cost[i];
        }
        if(sum<0) return -1;
        
        int gasTank=0,start=0;
        for(int i=0;i<gas.length;i++){
            gasTank += gas[i]-cost[i];
            if(gasTank<0){
                start =i+1;
                gasTank=0;
            }
        }
        return gasTank >= 0 ? start : -1;
    }
}