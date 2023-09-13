#User function Template for python3

class Solution:
    def lcmAndGcd(self, A , B):
        # code here 
        temp = A
        temp2 = B
        while temp2 != 0:
            temp,temp2 = temp2, temp%temp2
        gcd = temp
        lcm = (A*B)//gcd
        return [lcm,gcd]
#{ 
 # Driver Code Starts
#Initial Template for Python 3

import math
if __name__ == '__main__': 
    t = int (input ())
    for _ in range (t):
        A,B=map(int,input().split())
        
        ob = Solution()
        ptr = ob.lcmAndGcd(A,B)
        
        print(ptr[0],ptr[1])
# } Driver Code Ends