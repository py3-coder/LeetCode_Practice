class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] deg = new int[n];
        List<List<Integer>> gr = new ArrayList<>();
        for(int i=0;i<n;i++){
            gr.add(new ArrayList<>());
        }
        for(int[] arr:edges){
            int fr =arr[0];
            int to=arr[1];
            deg[to]++;
            gr.get(fr).add(to);
        }
        int chmap=-1;
        int cnt=0;
        for(int i=0;i<n;i++){
            if(deg[i]==0){
                if(cnt>0){
                    return -1;
                }
                chmap =i;
                    cnt++;
            }
        }
        return chmap;
    }
}