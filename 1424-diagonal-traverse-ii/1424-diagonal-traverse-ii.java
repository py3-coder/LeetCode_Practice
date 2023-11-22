class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        // int cnt=0;
        // List<List<Integer>> temp =new ArrayList<>();
        // for(int i=0;i<nums.size();i++){
        //     List<Integer> row = nums.get(i);
        //     for(int j=0;j<row.size();j++){
        //         int indx =i+j;
        //         if(temp.size()<indx+1){
        //             temp.add(new ArrayList<>());
        //         }
        //         temp.get(indx).add(row.get(j));
        //         cnt++;
        //     }
        // }
        // int res[] =new int[cnt];
        // int k=0;
        // for(var lis:temp){
        //     for(int i=lis.size()-1;i>=0;i--){
        //         res[k++] =lis.get(i);
        //     }
        // }
        // return res;
        //}

        //Test Code Editorial :)
        Map<Integer, List<Integer>> groups = new HashMap();
        int n = 0;
        for (int row = nums.size() - 1; row >= 0; row--) {
            for (int col = 0; col < nums.get(row).size(); col++) {
                int diagonal = row + col;
                if (!groups.containsKey(diagonal)) {
                    groups.put(diagonal, new ArrayList<Integer>());
                }
                groups.get(diagonal).add(nums.get(row).get(col));
                n++;
            }
        }
        int[] ans = new int[n];
        int i = 0;
        int curr = 0;
        
        while (groups.containsKey(curr)) {
            for (int num : groups.get(curr)) {
                ans[i] = num;
                i++;
            }
            curr++;
        }
        return ans;
        
    }
}