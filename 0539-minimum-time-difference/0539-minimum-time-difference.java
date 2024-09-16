class Solution {
    public int findMinDifference(List<String> timePoints) {
        int mm = Integer.MAX_VALUE;
        List<Integer> time = new ArrayList<>();
        
        for(int i = 0; i < timePoints.size(); i++){
            Integer h = Integer.valueOf(timePoints.get(i).substring(0, 2));
            time.add(60 * h + Integer.valueOf(timePoints.get(i).substring(3, 5)));
        }
        
        Collections.sort(time, (Integer a, Integer b) -> a - b);
        
        for(int i = 1; i < time.size(); i++){
            System.out.println(time.get(i));
            mm = Math.min(mm, time.get(i) - time.get(i-1));
        }
        
        int corner = time.get(0) + (1440 - time.get(time.size()-1));
        return Math.min(mm, corner);
    }
}