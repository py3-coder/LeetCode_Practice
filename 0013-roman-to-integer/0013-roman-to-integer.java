class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        return solveRec(s,s.length()-1,0,map);
        
    }
    public static int solveRec(String s,int indx,int prev,HashMap<Character,Integer> map){
        //Base Case :)
        if(indx<0) return 0;
        int val =map.get(s.charAt(indx));
        if(prev>val){
            return solveRec(s,indx-1,val,map)-val;
        }
        return solveRec(s,indx-1,val,map)+val;
        
    }
}