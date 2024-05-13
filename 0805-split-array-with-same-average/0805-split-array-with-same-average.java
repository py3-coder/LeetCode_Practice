class Solution {
    public boolean splitArraySameAverage(int[] nums) {
        int n = nums.length;
        if(n==1) return false;
        if(n==2) return nums[0]==nums[1];
        
        int total = Arrays.stream(nums).sum();
        
        int N = n/2;
        
        List<List<Integer>> left = new ArrayList<>();
        List<List<Integer>> right = new ArrayList<>();
        
        
        for(int i=0;i<=N;i++){
            left.add(new ArrayList<>());
            right.add(new ArrayList<>());
        }
        
        // let generate all subset 0-N -left & N+1 -n -right
        // total no. of subset -- 2^n ---: left - 2^N
        for(int i=0;i<(1<<N);i++){
            int setbit=0;
            int sum=0;
            // check every bits 
            for(int j=0;j<N;j++){
                // if it set means - we gona pick that ele:
                if((i & (1<<j))!=0){
                    setbit++;
                    sum+=nums[j];
                }
            }
            left.get(setbit).add(sum);
        }
        
        
        //right half :
        for(int i=0;i<(1<<N);i++){
            int setbit=0;
            int sum=0;
            // check every bits 
            for(int j=0;j<N;j++){
                // if it set means - we gona pick that ele:
                if((i & (1<<j))!=0){
                    setbit++;
                    sum+=nums[j+N];
                }
            }
            right.get(setbit).add(sum);
        }
        
        for(int i=0;i<left.size();i++){
            for(int j=0;j<right.size();j++){
                List<Integer> l = left.get(i);
                List<Integer> r = right.get(j);
                
                Collections.sort(l);
                Collections.sort(r);
                
                if((total*(i+j))%n>0 || i+j==0 || i+j==n){
                    continue;
                }
                
                int t = total*(i+j)/n ;
                int a=0,b=r.size()-1;
                
                while(a<l.size() && b>=0){
                    int val = l.get(a)+r.get(b);
                    if(val == t){
                        return true;
                    }else if(val>t){
                        b--;
                    }else{
                        a++;
                    }
                }
            }
        }
        return false;
    }
}

