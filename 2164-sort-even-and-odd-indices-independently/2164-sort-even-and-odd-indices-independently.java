class Solution {
    public int[] sortEvenOdd(int[] nums) {
        int res[] = new  int[nums.length];
        ArrayList<Integer> liseven = new ArrayList<>();
        ArrayList<Integer> lisodd = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                liseven.add(nums[i]);
            }else{
                lisodd.add(nums[i]);
            }
        }
        Collections.sort(liseven);
        Collections.sort(lisodd,Collections.reverseOrder());
        int m=0;
        int n=0;
        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                res[i] =liseven.get(m);
                m++;
            }else{
                res[i] =lisodd.get(n);
                n++;
            }
            
        }
        return res;
        
            
    }
}