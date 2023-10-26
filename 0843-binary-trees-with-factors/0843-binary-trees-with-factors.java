class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        HashMap<Integer,Long> map = new HashMap<>();
        long one =1;
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],one);
        }
        for(int i=1;i<arr.length;i++){
            for(int j=0;j<i;j++){
                if((arr[i]%arr[j]==0)){
                    int n = arr[i]/arr[j];
                    long a= map.get(n)==null?0:map.get(n);  // if such element is not found the retun 0 so that value will not change..
                    long b =map.get(arr[j]);                 // previous map values that in it..
                    map.put(arr[i],map.get(arr[i])+a*b);
                }
            }
        }
        long sum =0;
        for(long a : map.values()){
            sum =sum+a;
        }
        int res =(int)(sum % 1000000007);
        return res;
    }
}