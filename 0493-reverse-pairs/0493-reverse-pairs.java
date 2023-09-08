class Solution {
    public int reversePairs(int[] nums) {
        int n=nums.length;
        
        //Broute Force Method :: 
        // int count =0;
        // for(int i=0;i<n;i++){
        //     for(int j=i+1;j<n;j++){
        //         if(nums[i]>(2*nums[j])){
        //             count++;
        //         }
        //     }
        // }
        // return count;
        
        
        //Optimised :: Used Merge Sort and did some modification ::::
        return mergeSort(nums,0,n-1);
    }
    public static int mergeSort(int arr[],int low,int high){
        //base case :::
        int cnt=0;
        if(low>=high) return cnt;
        int mid = low+(high-low)/2;
        cnt +=mergeSort(arr,low,mid);
        cnt +=mergeSort(arr,mid+1,high);
        //count pairs 
        cnt +=countPairs(arr,low,mid,high);
        merge(arr,low,mid,high);
        return cnt;
    }
    public static int countPairs(int arr[] ,int low,int mid,int high){
        int count=0;
        int right=mid+1;
        for(int i=low;i<=mid;i++){
            while(right<=high && arr[i]/2.0 > arr[right]){
                right++;
            }
            count+= (right-(mid+1));
        }
        return count;
    }
    public static void merge(int arr[],int low,int mid,int high){
        List<Integer> temp = new ArrayList<>();
        int left=low;
        int right=mid+1;
        while(left<=mid && right<=high){
            if(arr[left]<=arr[right]){
                temp.add(arr[left]);
                left++;
            }else{
                temp.add(arr[right]);
                right++;
            }
        }
        while(left<=mid){
            temp.add(arr[left]);
            left++;
        }
        while(right<=high){
            temp.add(arr[right]);
            right++;
        }
        for(int i=low;i<=high;i++){
            arr[i] =temp.get(i-low);
        }
    }

    
}