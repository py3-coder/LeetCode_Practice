class Solution {
    public int longestOnes(int[] arr, int k) {
        int n=arr.length;
        // if(k==0){
        //     return 0;
        // }
        int start=0;
		int end=0;
		int res=0;
		int count0=0;
		while(end<n){
			if(arr[end]==0) count0++;
			if(count0<k){
				end++;
			}else if(count0==k){
				res=Math.max(end-start+1,res);
				end++;
			}else{
				while(count0>k){
					if(arr[start]==0) count0--;
					start++;
				}
				end++;
			}
		}
        if(res==0 && k==0){
            return 0;
        }
		return res==0?arr.length:res;
    }
}