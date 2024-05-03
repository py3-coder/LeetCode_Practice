class Solution {
    public boolean search(int[] A, int key) {
        return bs(A,key);
    }
    public static boolean bs(int[] arr,int target){
        int start=0;
        int end =arr.length-1;
        
        while(start<=end){
            int mid = start+(end-start)/2;
            
            if(target == arr[mid]){
                return true;
            }
            if(arr[mid]>arr[start]){
                // Left Side Sorted ::
                if(target<arr[mid] && target>=arr[start]){
                    end  = mid;
                }else{
                    start = mid+1;
                }
            }else if(arr[mid] < arr[start]){
                //right side is sorted ::
                if(target>arr[mid] && target< arr[start]){
                    start=mid+1;
                }else{
                    end =mid;
                }
                
            }else{
                start++;
            }
        }
        return false;
    }
}