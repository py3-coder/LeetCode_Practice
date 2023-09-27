class Solution {
    public int longestConsecutive(int[] a) {
        int n=a.length;
        if(n==0 || n==1){
            return n;
        }
        // Arrays.sort(a);
        // int counter=0;
        // int maxi=1;
        // int lastele=Integer.MIN_VALUE;
        // for(int i=0;i<a.length;i++){
        //     if(a[i]-1==lastele){
        //         counter++;
        //     }else if(a[i]!=lastele){
        //         counter=1;
        //     }
        //     lastele=a[i];
        //     maxi=Math.max(counter,maxi);
        // }
        // return maxi;
        
        //TC : O(nlogn)
        //SC : O(1)
        
        int max=0;
        HashSet<Integer> set = new HashSet<>();
        for(int ele:a){
            set.add(ele);
        }
        for(int i=0;i<n;i++){
            int count=1;
            //left ::
            int num =a[i];
            while(set.contains(--num)){
                count++;
                set.remove(num);
            }
            //right side::
            num =a[i];
            while(set.contains(++num)){
                count++;
                set.remove(num);
            }
            max = Math.max(max,count);
        }
        return max;
    }
}