class Solution {
    public List<Integer> getRow(int r) {
        List<Integer> temp=new ArrayList<>();
        long res=1;
        temp.add(1);
        for(int i=1;i<=r;i++){
            res=res*(r-i+1);
            res=res/i;
            temp.add((int)res);
        }
        return temp;
    }
}