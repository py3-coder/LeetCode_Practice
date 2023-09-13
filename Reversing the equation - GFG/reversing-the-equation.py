#User function Template for python3

class Solution:
    def reverseEqn(self, s):
        # code here
        x = ['*','-','/','+']
        l = []
        r = ""
        ans = ""
        
        for i in s:
            if i not in x:
                r = r + i
            else:
                l.append(r)
                r = ""
                l.append(i)
                
        l.append(r) 
        #print(l)# for the characters that were present after the last operator
        l.reverse()
        #print(l)
        for i in range(len(l)):
            ans += l[i]
        
        return ans

#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
    t = int(input())
    for _ in range(t):
        s = input().strip()
        ob = Solution()
        ans = ob.reverseEqn(s)
        print(ans)
# } Driver Code Ends