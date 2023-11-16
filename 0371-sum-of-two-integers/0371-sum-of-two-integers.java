class Solution {
    public int getSum(int a, int b) {
        //Not Solved :: Copied Idea  form other ::)
        //Cheated IDEA ::
        return solve(a,b);
    }
    //TC : O(1)
    // SC: O(1)
    //Iterative::
    public static int solve(int a,int b){
        int carry=0;
        while(b!=0){
             carry =(a&b);
             a = (a^b);
             b = (carry<<1);
        }
        return a;
    }
    
    
}