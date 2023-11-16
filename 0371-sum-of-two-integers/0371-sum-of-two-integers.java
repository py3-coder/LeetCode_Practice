class Solution {
    public int getSum(int a, int b) {
        //Not Solved :: Copied Idea  form other ::)
        //Cheated IDEA ::
        return solveADD(a,b);
    }
    //TC : O(1)
    // SC: O(1)
    //Iterative::Addtion::
    public static int solve(int a,int b){
        int carry=0;
        while(b!=0){
             carry =(a&b);
             a = (a^b);
             b = (carry<<1);
        }
        return a;
    }
    //Recursive ::)
    public static int solveADD(int a,int b){
        return (b==0)?a:solveADD(a^b,(a&b)<<1);
    }
    //Iterative Substract ::)
    public static int solvesub(int a,int b){
        while(b!=0){
            int borrow=(~a)&b;
            a=a^b;
            b=borrow<<1;
        }
        return a;
    }
    //Recursive Substract ::
    public static int solveSUB(int a,int b){
        return (b==0)?a:solveSUB(a^b ,((~a)&b)<<1);
    }
    // Get negative number
    public static int negate(int x) {
        return ~x + 1;
    }
}



