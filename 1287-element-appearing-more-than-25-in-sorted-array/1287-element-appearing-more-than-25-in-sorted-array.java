class Solution {
    public int findSpecialInteger(int[] arr) {
        //Approches :
        //1. Freq Count : TC :O(n) SC :O(n)
        //2. Since sorted iterate and cnt TC:O(n) SC :O(1)
        //3. check for n/4 , 2(n/4) ,3(n/4) indexes ... it upper and lower bound ::
        int n=arr.length;
        List<Integer> list = new ArrayList<>(Arrays.asList(arr[n/4],arr[n/2],arr[(3*n)/4]));
        for(int ele:list){
            int f =firstfreq(arr,ele);
            // int l =lastfreq(arr,ele);
            // if(l-f+1>n/4){
            //     return ele;
            // }
            
            if(arr[f+n/4]==ele){
                return ele;
            }
        }
        return -1;
        
        
    }
    public static int firstfreq(int[] arr,int target){
        int l=0;
        int h=arr.length-1;
        int ans=0;
        while(l<=h){
            int mid =l+(h-l)/2;
            if(arr[mid]==target){
                ans=mid;
                h=mid-1;
            }
            else if(arr[mid]>target){
                h=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
    public static int lastfreq(int[] arr,int target){
        int l=0;
        int h=arr.length-1;
        int ans=0;
        while(l<=h){
            int mid =l+(h-l)/2;
            if(arr[mid]==target){
                ans =mid;
                l=mid+1;
            }else if(arr[mid]>target){
                h =mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
}