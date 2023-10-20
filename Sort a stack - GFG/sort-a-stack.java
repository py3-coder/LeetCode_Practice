//{ Driver Code Starts
import java.util.Scanner;
import java.util.Stack;
class SortedStack{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			Stack<Integer> s=new Stack<>();
			int n=sc.nextInt();
			while(n-->0)
			s.push(sc.nextInt());
			GfG g=new GfG();
			Stack<Integer> a=g.sort(s);
			while(!a.empty()){
				System.out.print(a.peek()+" ");
				a.pop();
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


/*Complete the function below*/
class GfG{
	public Stack<Integer> sort(Stack<Integer> st)
	{
		//Lets Play with Recursion:
		sortStack(st);
		return st;
		
	}
	public static void sortStack(Stack<Integer> st){
	    if(st.size()==1)  return ;
	    
	    int pop =st.pop();
	    sortStack(st);
	    insert(st,pop);
	}
	public static void insert(Stack<Integer> st,int target){
	    if(st.isEmpty()){
	        st.push(target);
	        return;
	    }
	    if(st.peek()<=target){
	        st.push(target);
	        return;
	    }
	    int remove =st.pop();
	    insert(st,target);
	    st.push(remove);
	} 
}