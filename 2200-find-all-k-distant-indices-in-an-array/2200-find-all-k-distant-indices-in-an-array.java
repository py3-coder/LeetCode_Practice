class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> res = new ArrayList<>();
        SortedSet<Integer> ts= new TreeSet<Integer>();
        List<Integer> keylist = new ArrayList<>();
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]==key ){
                keylist.add(i);
            }
        }
        for(int j=0;j<nums.length;j++){
            for(int ele:keylist){
                if(Math.abs(j-ele)<=k){
                    ts.add(j);
                }
            }
        }
        for(int val:ts){
            res.add(val);
        }
        return res;
        
    }
}