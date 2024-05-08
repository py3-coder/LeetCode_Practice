class Solution {
    public String[] findRelativeRanks(int[] score) {
        String[] res = new String[score.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(score[b]-score[a]));
        for(int i=0;i<score.length;i++){
            pq.offer(i);
        }
        int k=1;
        while(!pq.isEmpty()){
            int ele =pq.poll();
            if(k==1){
                res[ele] = "Gold Medal";
            }
            else if(k==2){
                res[ele] = "Silver Medal";
            }
            else if(k==3){
                res[ele] = "Bronze Medal";
            }
            else if(k>3){
                res[ele] =String.valueOf(k);
            }
            k++;
        }
        return res;
    }
    // public void pushEle(int ele,int[] arr,String[] res,int k){
    //     for(int i=0;i<arr.length;i++){
    //         if(ele == arr[i] && k==1){
    //             res[i] = "Gold Medal";
    //         }
    //         else if(ele == arr[i] && k==2){
    //             res[i] = "Silver Medal";
    //         }
    //         else if(ele == arr[i] && k==3){
    //             res[i] = "Bronze Medal";
    //         }
    //         else if(ele == arr[i]){
    //             res[i] =String.valueOf(k);
    //         }
    //     }
    // }
}