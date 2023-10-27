//{ Driver Code Starts
import java.util.*;



class Get_Min_From_Stack
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int q = sc.nextInt();
			GfG g = new GfG();
			while(q>0)
			{
				int qt = sc.nextInt();
				
				if(qt == 1)
				{
					int att = sc.nextInt();
					g.push(att);
					//System.out.println(att);
				}
				else if(qt == 2)
				{
					System.out.print(g.pop()+" ");
				}
				else if(qt == 3)
				{
					System.out.print(g.getMin()+" ");
				}
			
			q--;
			}
			System.out.println();
		T--;
		}
		
	}
}



// } Driver Code Ends


class GfG
{
    int mini;
    Stack<Integer> st;
    
    GfG()
	{
	    st =new Stack<>();
	    mini=Integer.MAX_VALUE;
	}
    int getMin()
    {
        if(!st.isEmpty()){
            return mini;
        }
        return -1;
    }
    int pop()
    {
        if(!st.isEmpty()){
        int val=st.pop();
        if(val<mini){
            int temp=mini;
            mini =2*mini-val;
            return temp;
        }
         return val;
        }else{
            return -1;
        }
    }
    void push(int x)
    {
        if(st.isEmpty()){
            st.push(x);
            mini=x;
        }else{
            if(x<mini){
                st.push(2*x-mini);
                mini=x;
            }else{
                st.push(x);
            }
        }
    }
}

