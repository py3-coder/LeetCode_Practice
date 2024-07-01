class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
//         int cnt=0;
//         for(int ele : arr){
//             if(ele%2==0){
//                 cnt=0;
//             }else{
//                 cnt+=1;
                
//                 if(cnt == 3){
//                     return true;
//                 }
//             }
//         }
//         return false;
        
      return  IntStream.range(0, arr.length - 2)
      .anyMatch(i -> arr[i] % 2 == 1 && arr[i + 1] % 2 == 1 && arr[i + 2] % 2 == 1);
    }
}