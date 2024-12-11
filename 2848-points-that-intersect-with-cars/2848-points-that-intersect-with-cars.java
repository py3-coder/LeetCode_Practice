class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        //Sweep line :
        int[] line = new int[102];
        for(List<Integer> point : nums){
            int l0 =point.get(0),l1=point.get(1);
            line[l0]++;
            line[l1+1]--;
        }
        int cnt=0;
        for(int i=1;i<102;i++){
            line[i] += line[i-1];
            if(line[i]>0){
                cnt++;
            }
        }
        return cnt;
    }
}