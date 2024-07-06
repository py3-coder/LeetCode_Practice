class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int flag =-1;
        for(int i=n-2;i>=0 ;i--){
            if(nums[i]<nums[i+1]){
                flag =i;
                break;
            }
        }
        
        if(flag == -1){
            Reverse(0 , n , nums);
            return ;
        }
        
        for(int i = n-1 ;i>flag ;i--){
            if(nums[flag]<nums[i]){
                //swap ::
                int temp = nums[flag];
                nums[flag] = nums[i];
                nums[i] = temp;
                break;
            }
        }
        //Reverse :
        Reverse(flag+1 , n , nums) ;
        
        
    }
    
     public static void Reverse(int start ,int end,int[] arr){
        for (int i = start, j = end-1, tmp; i < j; i++, j--) {
            tmp= arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        } 
    }
}