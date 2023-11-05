class Solution {
    public int getWinner(int[] arr, int k) {
        int max=Math.max(arr[0],arr[1]);
        if(k==1){
            return Math.max(arr[0],arr[1]);
        }
        int cnt=1;
        for(int i=2;i<arr.length;i++){
            if(max<arr[i]){
                max =arr[i];
                cnt=1;
            }else{
                cnt++;
            }
            if(cnt==k){
                return max;
            }
        }
        return max;

    }
}