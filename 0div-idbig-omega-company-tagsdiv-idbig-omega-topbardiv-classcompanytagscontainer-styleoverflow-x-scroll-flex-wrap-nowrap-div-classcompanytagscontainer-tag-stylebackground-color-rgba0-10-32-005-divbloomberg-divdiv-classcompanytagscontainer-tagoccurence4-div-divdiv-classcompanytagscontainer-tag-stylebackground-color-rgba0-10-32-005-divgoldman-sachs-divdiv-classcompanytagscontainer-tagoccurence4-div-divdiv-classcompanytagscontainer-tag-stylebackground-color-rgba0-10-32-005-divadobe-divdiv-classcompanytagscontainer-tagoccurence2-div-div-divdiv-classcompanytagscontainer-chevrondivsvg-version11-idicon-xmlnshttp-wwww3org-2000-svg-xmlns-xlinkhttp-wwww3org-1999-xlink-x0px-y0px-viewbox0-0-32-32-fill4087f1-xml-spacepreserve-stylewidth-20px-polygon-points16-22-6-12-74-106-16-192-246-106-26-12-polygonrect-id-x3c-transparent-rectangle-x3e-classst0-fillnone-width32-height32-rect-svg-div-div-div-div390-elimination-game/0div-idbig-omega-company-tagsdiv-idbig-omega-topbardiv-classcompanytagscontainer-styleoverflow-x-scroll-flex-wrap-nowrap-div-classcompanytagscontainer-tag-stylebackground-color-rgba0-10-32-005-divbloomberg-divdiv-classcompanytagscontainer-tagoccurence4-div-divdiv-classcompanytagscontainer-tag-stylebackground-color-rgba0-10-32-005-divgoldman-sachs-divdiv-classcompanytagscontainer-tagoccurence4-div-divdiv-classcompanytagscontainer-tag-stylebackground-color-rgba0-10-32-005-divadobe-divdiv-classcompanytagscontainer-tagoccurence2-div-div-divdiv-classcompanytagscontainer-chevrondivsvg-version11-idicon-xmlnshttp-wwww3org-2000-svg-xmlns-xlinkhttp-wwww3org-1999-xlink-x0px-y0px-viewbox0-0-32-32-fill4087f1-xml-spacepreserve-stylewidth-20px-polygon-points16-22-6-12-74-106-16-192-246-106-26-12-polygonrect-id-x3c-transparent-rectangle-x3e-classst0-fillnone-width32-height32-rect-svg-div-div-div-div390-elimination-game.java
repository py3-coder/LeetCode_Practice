class Solution {
    
    public int lastRemaining(int n) {
        
    return recursion(n,true);
        
    // ArrayList<Integer> arr = new ArrayList<>();
    //     for(int i=1;i<=n;i++){
    //         arr.add(i);
    //     }
    //     return solveRecursive(arr,true);
    //TC : O(n)
    //SC : O(n)
    //result :: TLE----
        
    }
    public static int recursion(int n , boolean flag){
        if(n==1) return n;
        if(!flag && n%2==0){
            // eliminate all the even numbers
            // [1, 2, 3, 4, 5, 6] -> [1, 3, 5]
            // It is equivalent to consider the number left in [1, 2, 3] * 2 - 1
            return recursion(n/2,!flag)*2-1;
        }else{
            // eliminate all the odd numbers
            // [1, 2, 3, 4, 5, 6] -> [2, 4, 6]
            // It is equivalent to consider the number left in [1, 2, 3] * 2
            return recursion(n / 2, !flag) * 2;
        }
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // public static int solveRecursive(ArrayList<Integer> arr,boolean flag){
    //     if(arr.size()==1){
    //         return arr.get(0);
    //     }
    //     if(flag){
    //         int i=0;
    //         while(i<arr.size()){
    //             arr.set(i,-1);
    //             i=i+2;
    //         }
    //     }
    //     if(!flag){
    //         int i=arr.size()-1;
    //         while(i>=0){
    //             arr.set(i,-1);
    //             i-=2;
    //         }
    //     }
    //     for(int i=0;i<arr.size();i++){
    //         if(arr.get(i)==-1){
    //             arr.remove(i);
    //         }
    //     }
    //     return solveRecursive(arr,!flag);
    // }
}