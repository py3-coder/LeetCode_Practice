class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int temp[] = arr.clone();
        Arrays.sort(temp);
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<temp.length;i++){
           map.putIfAbsent(temp[i],map.size()+1);
        }
         for (int i=0;i<temp.length;i++)
            temp[i] = map.get(arr[i]);
        return temp;
        
    }
}

