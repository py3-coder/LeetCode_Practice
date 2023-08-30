class Solution {
    public void nextPermutation(int[] arr) {
        int n =arr.length;
        int idx=-1;
        for(int i=n-2;i>=0;i--){
            if(arr[i]<arr[i+1]){
                idx=i;
                break;
            }
        }
        if(idx==-1){
            // Just Reverse the Array
            Reverse(0,n,arr);
            return ;
        }
        for(int i =n-1;i>idx;i--){
            if(arr[i]>arr[idx]){
                int temp=arr[i];
                arr[i]=arr[idx];
                arr[idx]=temp;
                break;
            }
           
        }
        Reverse(idx+1,n,arr);
        
        
    }
    public static void Reverse(int start ,int end,int[] arr){
        for (int i = start, j = end-1, tmp; i < j; i++, j--) {
            tmp= arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        } 
    }
}