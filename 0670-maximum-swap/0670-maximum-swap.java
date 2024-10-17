class Solution {
    public int maximumSwap(int num) {
        // TC : O(nlogn)
        // SC : O(n) + O(n) 
        
//         String st = String.valueOf(num);
       
//         List<Integer> arr = new ArrayList<>();
//         HashMap<Integer,Integer> map = new HashMap<>();
//         int k=0;
//         for(char ch : st.toCharArray()){
//             map.put(ch-'0',k);
//             arr.add(ch-'0');
//             k++;
//         }
//         //System.out.println(map);
//         Collections.sort(arr, Collections.reverseOrder());
//         //System.out.print(arr);
//         for(int i=0;i<arr.size();i++){
//             if(st.charAt(i)-'0'<arr.get(i)){
//                 //swap
//                 return Integer.valueOf(swap(st,i,map.get(arr.get(i))));
//             }
//         }
//         return Integer.valueOf(st);
        
        
        
        
        // tc - O(N)
        // SC - O(N) 
        
//             String st = String.valueOf(num);
//             int arr[] = new int[st.length()];
//             int[] last = new int[10];
           
//             for(int i=0;i<st.length();i++){
//                 arr[i] = st.charAt(i)-'0';
//                 last[arr[i]] =i;
//             }
        
//             for(int i=0;i<arr.length;i++){
                
//                 for(int d=9;d>arr[i];d--){
//                     if(last[d]>i){
//                         //swap
//                         return Integer.valueOf(swap(st , i , last[d]));
//                     }
//                 }
//             }
//             return Integer.valueOf(st);
        
        
        
        
        //TC : O(n)
        // SC : O(1)
        
        int maxbase =0,max=-1;
        int base=1,delta=0;
        int temp = num;
        while(num>0){
            int d = num%10;
            if(d>max){
                maxbase=base;
                max = d ;
            }else{
                delta = Math.max(delta , (base - maxbase) * ( max - d));
            }
            num/=10;
            base*=10;
        }
        return temp+delta;
        
        
    }
    public String swap(String st , int indx , int pos){
        char[] ch = st.toCharArray();
        char temp = ch[indx];
        ch[indx] = ch[pos];
        ch[pos] = temp;

        return new String(ch);
        
    }
}