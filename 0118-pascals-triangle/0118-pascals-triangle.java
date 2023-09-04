class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            res.add(genRow(i));
        }
        return res;
        
    }
    public List<Integer> genRow(int row){
        List<Integer> temp = new ArrayList<>();
        long res=1;
        temp.add(1);
        for(int col=1;col<=row;col++){
            res =res*(row-col+1);
            res=res/col;
            temp.add((int)res);
        }
        return temp;
    }
}