class Solution {
    public int trap(int[] height) {
        // Lets Play with Stack :::
        //Broute Force  :: TC : O(n^2) , SC : O(1):
        
        //Lets write Better One ::
        int n =height.length;
        // int leftmax[] = new int[n];
        // int rightmax[] =new int[n];
        // int maxi=0;
        // for(int i=0;i<n;i++){
        //     if(maxi<height[i]){
        //         maxi=height[i];
        //     }
        //     leftmax[i] =maxi;
        // }
        // maxi=0;
        // for(int i=n-1;i>=0;i--){
        //     if(maxi<height[i]){
        //         maxi =height[i];
        //     }
        //     rightmax[i] =maxi;
        // }
        // int area =0;
        // for(int i=0;i<n;i++){
        //     area+=Math.min(rightmax[i],leftmax[i])-height[i];
        // }
        // return area;
        
        //TC: O(n)
        //SC :O(2n)
        
        //Two Pointer::
        
        int left=0,right=n-1;
        int leftmax=0,rightmax=0;
        int res=0;
        while(left<=right){
            if(height[left]<=height[right]){
                if(leftmax<height[left]){
                    leftmax=height[left];
                }else{
                    res+=leftmax-height[left];
                }
                left++;
            }else{
                if(rightmax<height[right]){
                    rightmax =height[right];
                }else{
                    res+=rightmax-height[right];
                }
                right--;
            }
        }
        return res;
        //TC : O(n)
        //SC: O(1)
    }
}