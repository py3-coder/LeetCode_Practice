class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //Broute Froce ::
        //Lets Play With Stack::
        Stack<Integer> st = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        int n=nums2.length;
        for(int i=n-1;i>=0;i--){
            if(st.isEmpty()){
                map.put(nums2[i],-1);
            }else if(st.peek()>nums2[i]){
                map.put(nums2[i],st.peek());
            }else{
                while(!st.isEmpty() && st.peek()<nums2[i]){
                    st.pop();
                }
                if(st.isEmpty()){
                    map.put(nums2[i],-1);
                }else{
                    map.put(nums2[i],st.peek());
                }
            }
            st.push(nums2[i]);
        }
        int k=0;
        int res[] = new int[nums1.length];
        for(int ele:nums1){
            res[k++]=map.get(ele);
        }
        return res;
        
    }
}