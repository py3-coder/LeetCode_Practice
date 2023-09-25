class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int[][] mat = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]=='0'){
                    mat[i][j]=0;
                }else{
                    mat[i][j]=1;
                }
            }
        }
        return maximalAreaOfSubMatrixOfAll1(mat,n,m);
        
    }
    public static int maximalAreaOfSubMatrixOfAll1(int[][] mat, int n, int m) {
		//Lets Play with Stack :: MAH Problem :: break into 1-D array::
		int area=0;
		int temp[] = new int[m];
		for(int j=0;j<m;j++){
				temp[j] =mat[0][j];
		}
		
		area = MAH(temp, m);
		for(int i=1;i<n;i++){
			int maxi=0;
			for(int j=0;j<m;j++){
				if(mat[i][j]==0){
					temp[j]=0;
				}else{
					temp[j] =temp[j]+mat[i][j];
				}
			}
			//System.out.println();
			maxi =MAH(temp, m);
			//System.out.print(maxi+" ");
			area =Math.max(maxi,area);
		}
		return area;

	}
	public static int MAH(int arr[] ,int n){
		int[] left =nsl(arr, n);
		int[] right =nsr(arr, n);
		int width=0;
		int area=0;
		for(int i=0;i<n;i++){
			width =right[i]-left[i]-1;
			area=Math.max(width*arr[i],area);
		}
		return area;
		 
	}
	public static int[] nsl(int arr[],int n){
		int[] left =new int[n];
		Stack<Integer> st = new Stack<>();

		for(int i=0;i<n;i++){
			if(st.isEmpty()){
				left[i] =-1;
			}else if(arr[st.peek()]<arr[i]){
				left[i] =st.peek();
			}else{
				while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
					st.pop();
				}
				if(st.isEmpty()){
					left[i] =-1;
				}else{
					left[i] =st.peek();
				}
			}
			st.push(i);
		}
		return left;
	}
	public static int[] nsr(int arr[],int n){
		int[] right =new int[n];
		Stack<Integer> st = new Stack<>();

		for(int i=n-1;i>=0;i--){
			if(st.isEmpty()){
				right[i] =n;
			}else if(arr[st.peek()]<arr[i]){
				right[i] =st.peek();
			}else{
				while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
					st.pop();
				}
				if(st.isEmpty()){
					right[i] =n;
				}else{
					right[i] =st.peek();
				}
			}
			st.push(i);
		}
		return right;
	}
}