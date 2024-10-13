class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {
        HashSet<Integer> set = new HashSet<>();
        long[] line = new long[100002];
        
        int maxend=-1;
        for(int[] segment : segments){
            line[segment[0]]+=segment[2];
            line[segment[1]]-=segment[2];
            set.add(segment[0]);
            set.add(segment[1]);
            maxend = Math.max(maxend,segment[1]);
        }
        List<List<Long>> res = new ArrayList<>(); 
        long last_i=0,sum=0;
        for(int i=1;i<line.length;i++){            
            if( set.contains(i) && sum > 0){
                res.add(Arrays.asList(last_i, (long)i, sum));    
            }
            last_i =set.contains(i) ? i : last_i;
            sum += line[i];
            if(i==maxend){
                break;
            }
        }
        
        return res;
        
       
    }
}