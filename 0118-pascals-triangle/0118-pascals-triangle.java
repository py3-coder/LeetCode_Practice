class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if(numRows==1){
            List<Integer> newres = new ArrayList<>();
            newres.add(1);
            result.add(newres);
            return result;
        }
        if(numRows==2){
            List<Integer> newres1 = new ArrayList<>();
            newres1.add(1);
            result.add(newres1);
            List<Integer> newres2 = new ArrayList<>();
            newres2.add(1);
            newres2.add(1);
            result.add(newres2);
            return result;
        }
         List<Integer> newres1 = new ArrayList<>();
            newres1.add(1);
            result.add(newres1);
            List<Integer> newres2 = new ArrayList<>();
            newres2.add(1);
            newres2.add(1);
            result.add(newres2);
        numRows=numRows-2;
        while(numRows-->0){
            List<Integer> newres = new ArrayList<>();
            List<Integer> last =new ArrayList<>();
            last =result.get(result.size() - 1);
            newres.add(1);
            for(int i=0;i<last.size()-1;i++){
                int val1 =last.get(i);
                int val2 =last.get(i+1);
                newres.add(val1+val2);
            }
            newres.add(1);
            result.add(newres);
        }
        return result;
    }
}