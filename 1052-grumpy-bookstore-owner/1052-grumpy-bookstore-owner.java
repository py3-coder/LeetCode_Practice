class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        
        // find the number of satisfied customers without applying the secret technique
        int satisfiedCustomers = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                satisfiedCustomers += customers[i];
            } 
        }
        
        int max = 0;
        int currSum = 0;
        int windowStart = 0;
        
        for (int windowEnd = 0; windowEnd < customers.length; windowEnd++) {
            if (grumpy[windowEnd] == 1) {
                currSum += customers[windowEnd];
            }
            
            if (windowEnd - windowStart + 1 >= X) {
                max = Math.max(max, currSum);
                if (grumpy[windowStart] == 1) {
                    currSum -= customers[windowStart];
                }
                windowStart++;
            }
        }
        
        return satisfiedCustomers + max;   
}
}