class Solution {
    public String[] findRelativeRanks(int[] score) {
        String[] res = new String[score.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b-a));
        for(int ele :score){
            pq.offer(ele);
        }
        int k=1;
        while(!pq.isEmpty()){
            int ele =pq.poll();
            //System.out.println(ele);
            pushEle(ele,score,res,k);
            k++;
        }
        return res;
    }
    public void pushEle(int ele,int[] arr,String[] res,int k){
        for(int i=0;i<arr.length;i++){
            if(ele == arr[i] && k==1){
                res[i] = "Gold Medal";
            }
            else if(ele == arr[i] && k==2){
                res[i] = "Silver Medal";
            }
            else if(ele == arr[i] && k==3){
                res[i] = "Bronze Medal";
            }
            else if(ele == arr[i]){
                res[i] =String.valueOf(k);
            }
        }
    }
}