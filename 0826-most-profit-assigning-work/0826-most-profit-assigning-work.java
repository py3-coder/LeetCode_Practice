class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = profit.length;
        List<List<Integer>> lis = new ArrayList<>();
        for(int i=0;i<profit.length;i++){
            List<Integer> temp = new ArrayList<>(Arrays.asList(difficulty[i],profit[i]));
            lis.add(temp);
        }
        Collections.sort(lis , (a,b)->(a.get(0)-b.get(0)!=0?a.get(0)-b.get(0):b.get(1)-a.get(1)));
        
        int[] max = new int[n];
        max[0]=lis.get(0).get(1);
        for (int i=1;i<n;i++) {
            max[i]=Math.max(lis.get(i).get(1),max[i-1]); 
        }
        
        int maxi=0;
        for(int ele : worker) {
            int res = bs(lis,ele);
            maxi+=res==-1?0:max[res];
        }
        return maxi;
    }
                         
    public int bs(List<List<Integer>> lis , int target){
        int l =0;
        int h =lis.size()-1;
        if(target>=lis.get(h).get(0)){
            return h;
        }
        int ans=-1;
        while(l<=h){
            int m = l+(h-l)/2;
            if(lis.get(m).get(0) <= target){
                ans = m;
                l= m+1;
            }else{
                h = m-1;
            }
        }
        return ans;
    }
}