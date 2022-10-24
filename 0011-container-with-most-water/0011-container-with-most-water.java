class Solution {
    public int maxArea(int[] height) {
        int max_area=0;
        int left =0 ,right=height.length-1;
        while(left<right){
            max_area = Math.max(max_area,Math.min(height[left],height[right])*(right-left));
            if(height[left]>height[right]){
                right--;
            }
            else{
                left++;
            }
        }
        return max_area;
    }
}