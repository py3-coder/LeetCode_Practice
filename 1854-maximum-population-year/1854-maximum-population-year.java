class Solution {
    public int maximumPopulation(int[][] logs) {
        // Sweep Line Algo.
        
//         int[] line = new int[2055];
        
//         for(int[] log : logs){
//             line[log[0]]+=1;
//             line[log[1]+1]-=1;
//         }
        
//         int maxi =-1;
//         int year=1950;
//         for(int i=1950;i<2055;i++){
//             line[i]+=line[i-1];
//             if(maxi<line[i]){
//                 year=i;
//                 maxi = line[i];
//             }
//         }
//         return year ;
        
        
        
        // Tree Map Impl :
        
        TreeMap<Integer,Integer> map = new TreeMap<>();
        
        for(int[] log : logs ){
            map.put(log[0], map.getOrDefault(log[0],0)+1);
            map.put(log[1], map.getOrDefault(log[1],0)-1);
        }
        
        int maxi =-1, year=0,pop=0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            pop+=entry.getValue();
            if(pop>maxi){
                maxi = pop;
                year = entry.getKey();
            }
        }
        return year;
    }
}