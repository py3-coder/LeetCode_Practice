class Solution {
    public int numWaterBottles(int numB, int numE) {
        int res =numB;
        while(numB>=numE){
            int rem = numB%numE;
            res += numB/numE;
            numB = numB/numE;
            numB+=rem;
        }
        return res;
    }
}