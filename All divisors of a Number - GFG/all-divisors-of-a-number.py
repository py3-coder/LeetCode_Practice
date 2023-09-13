#{ 
 # Driver Code Starts
#Initial Template for Python 3

# } Driver Code Ends
#User function Template for python3

class Solution:
    def print_divisors(self, N):
        # code here
        lis=[]
        for i in range(1,int(N**0.5)+1):
            if N % i == 0:
                lis.append(i)
                if i!=N/i:
                    lis.append(N//i)
        
        for i in range(len(lis)): 
            print(sorted(lis)[i], end=" ")

#{ 
 # Driver Code Starts.
if __name__ == '__main__': 
    t = int(input ())
    for _ in range (t):
        N = int(input())
        ob = Solution()
        ob.print_divisors(N)
        print()
# } Driver Code Ends