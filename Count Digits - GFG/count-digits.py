#User function Template for python3


class Solution:
    def evenlyDivides (self, N):
        # code here
        count=0
        div=N
        while(N>0):
            r=N%10
            if(r!=0 and div%r==0):
                count+=1;
            N//=10
        return count

#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__': 
    t = int (input ())
    for _ in range (t):
        N = int(input())
       

        ob = Solution()
        print(ob.evenlyDivides(N))
# } Driver Code Ends