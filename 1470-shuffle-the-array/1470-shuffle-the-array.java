class Solution {
    public int[] shuffle(int[] nums, int n) {
        ArrayList<Integer> lis = new ArrayList<>();
        for(int i=0;i<n;i++){
            lis.add(nums[i]);
            lis.add(nums[n+i]);
        }
        int[] arr = new int[nums.length];
        int k=0;
        for(int a : lis){
            arr[k++] = a; 
        }
       return arr; 
    }
}