class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        int k=0;
        for(int i=1;i<=n;i++){
            if(k==target.length){
                break;
            }
            res.add("Push");
            if(i==target[k] && k<target.length){
                k++;
            }else{
                res.add("Pop");
            }
        }
        return res;
    }
}