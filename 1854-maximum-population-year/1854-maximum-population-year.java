class Solution {
    public int maximumPopulation(int[][] logs) {
        // Line Sweep Algo.
        
        int[] line = new int[2055];
        
        for(int[] log : logs){
            line[log[0]]+=1;
            line[log[1]]-=1;
        }
        
        int maxi =-1;
        int year=1950;
        for(int i=1950;i<2055;i++){
            line[i]+=line[i-1];
            if(maxi<line[i]){
                //System.out.println(i+" "+line[i]);
                year=i;
                maxi=line[i];
            }
        }
        return year ;
    }
}