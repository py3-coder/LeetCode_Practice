class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
		ArrayList<Integer> temp = new ArrayList<>();
		LinkedHashSet<ArrayList<Integer>> res = new LinkedHashSet<>();
		res.add(temp);
		//call
		allSubsets(nums,0, res, temp);
		//
		return new ArrayList<>(res);
    }
    public static void allSubsets(int input[],int indx,LinkedHashSet<ArrayList<Integer>> res,ArrayList<Integer> temp){
		if(indx==input.length){
			return;
		}
		//pick
		temp.add(input[indx]);
		res.add(new ArrayList<>(temp));
		allSubsets(input, indx+1, res, temp);
		//remove the last one all call to no pick
		temp.remove(temp.size()-1);
		allSubsets(input, indx+1, res, temp);
	}
}