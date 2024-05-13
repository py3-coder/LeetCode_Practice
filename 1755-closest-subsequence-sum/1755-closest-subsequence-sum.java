class Solution {
    public int minAbsDifference(int[] nums, int goal) {
        int n = nums.length;
        int total = Arrays.stream(nums).sum();
        int f=0,s=0;
        if(n%2==0){
            f =n/2;
            s =n/2;
        }else{
            f=n/2+1;
            s=n-f;
        }
        
        // Meet in Middle Concept :: - we can use map also :
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        
        
        // let generate all subset 0-N -left & N+1 -n -right
        // total no. of subset -- 2^n ---: left - 2^N
        for(int i=0;i<(1<<f);i++){
            int sum=0;
            // check every bits 
            for(int j=0;j<f;j++){
                // if it set means - we gona pick that ele:
                if((i & (1<<j))!=0){
                    sum+=nums[j];
                }
            }
            left.add(sum);
        }
        
        
        //right half :
        for(int i=0;i<(1<<s);i++){
            int sum=0;
            // check every bits 
            for(int j=0;j<s;j++){
                // if it set means - we gona pick that ele:
                if((i & (1<<j))!=0){
                    sum+=nums[j+f];
                }
            }
            right.add(sum);
        }
        Collections.sort(left);
        Collections.sort(right);
        
        
        int ans = Integer.MAX_VALUE;
        int a=0,b=right.size()-1;
        
        while(a<left.size() && b>=0){
            int currSum = left.get(a)+right.get(b);
            ans = Math.min(Math.abs(currSum-goal),ans);
            if(currSum==goal){
                ans=0;
                break;
            }else if(currSum>goal){
                b--;
            }else{
                a++;
            }
        }
        return ans;
    }
}