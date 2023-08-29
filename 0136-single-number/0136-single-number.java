class Solution {
    public int singleNumber(int[] arr) {
        Arrays.sort(arr);
         int low = 0;
	    int high = arr.length-1;
	
	    while(low < high) {
		int mid = (low+high) / 2;

		if(mid%2 != 0) {
			mid -= 1;
		}

		if(arr[mid] == arr[mid+1]) {
			low = mid+2;
		} else {
			high = mid;
		}
	}

	return arr[low];
    }
}