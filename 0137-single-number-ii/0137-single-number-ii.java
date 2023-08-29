class Solution {
    public int singleNumber(int[] arr) {
       Arrays.sort(arr);
        for(int i=1;i<arr.length;i+=3){
            if(arr[i-1]!=arr[i+1]){
                return arr[i-1];
            }
        }
        return arr[arr.length-1];
    }
}