class Solution {
    public boolean isPathCrossing(String path) {
        HashSet<String> set = new HashSet<>();
        int row =0;
        int col=0;
        set.add(row+","+col);
        for(char ch : path.toCharArray()){
            if(ch=='N'){
                col+=1;
            }else if(ch=='S'){
                col-=1;
            }else if(ch=='W'){
                row-=1;
            }else{
                row+=1;
            }
            
            if(!set.contains(row+","+col)){
                set.add(row+","+col);
            }else{
                return true;
            }
        }
        return false;
    }
}