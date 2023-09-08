class Solution {
    public int[][] merge(int[][] arr) {
        int n =arr.length;
        List<int[]> result = new ArrayList<>();
        //Lambda Expresion to sort 2d array based on their first element ..
        Arrays.sort(arr , (a,b)->Integer.compare(a[0],b[0]));
        
        //Broute Force Approch :::
//         for(int i=0;i<n;i++){
//             int start =arr[i][0];
//             int end =arr[i][1];
            
//             //skip the case when [1,4] ,[2,3] == [1,4]..
//             if(!result.isEmpty() && end<=result.get(result.size()-1)[1]) continue;
            
//             for(int j=i+1;j<n;j++){
//                 if(end>=arr[j][0]){
//                     end = Math.max(end,arr[j][1]);
//                 }else{
//                     break;
//                 }
//             }
//             int[] temp ={start,end};
//             result.add(temp);
//         }
//         return result.toArray(new int[result.size()][]);
        
        //TC : O(nlogn)+O(2n)
        // why 2n is just we are checking every pair 2 time do run you will get it..
        //SC : O(n) --> To return result--
        
        
        // Lets Optimise :::
        for(int i=0;i<n;i++){
            if(result.isEmpty() || result.get(result.size()-1)[1]<arr[i][0]){
                int[] temp ={arr[i][0],arr[i][1]};
                result.add(temp);
            }else{
                result.get(result.size()-1)[1]=Math.max(result.get(result.size()-1)[1],arr[i][1]);
            }
        }
        return result.toArray(new int[result.size()-1][]);
    }
}