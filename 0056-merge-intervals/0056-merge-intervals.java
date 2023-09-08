class Solution {
    public int[][] merge(int[][] arr) {
        int n =arr.length;
        List<int[]> result = new ArrayList<>();
        //Lambda Expresion to sort 2d array based on their first element ..
        Arrays.sort(arr , (a,b)->Integer.compare(a[0],b[0]));
        
        //Broute Force Approch :::
        for(int i=0;i<n;i++){
            int start =arr[i][0];
            int end =arr[i][1];
            
            //skip the case when [1,4] ,[2,3] == [1,4]..
            if(!result.isEmpty() && end<=result.get(result.size()-1)[1]) continue;
            
            for(int j=i+1;j<n;j++){
                if(end>=arr[j][0]){
                    end = Math.max(end,arr[j][1]);
                }else{
                    break;
                }
            }
            int[] temp ={start,end};
            result.add(temp);
        }
        return result.toArray(new int[result.size()][]);
    }
}