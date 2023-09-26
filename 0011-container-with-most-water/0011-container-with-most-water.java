class Solution {
    public int maxArea(int[] height) {
        //Lets Play ::: 
        //Broute Force :: TC : O(n^2) SC : O(1)
        
        //lets try two pointer::
        int left=0;
        int right=height.length-1;
        int area=0;
        while(left<=right){
            if(height[left]<=height[right]){
                area =Math.max(Math.min(height[left],height[right])*(right-left),area);
                left++;
            }else{
                area =Math.max(Math.min(height[left],height[right])*(right-left),area);
                right--;
            }
        }
        return area;
    }
}