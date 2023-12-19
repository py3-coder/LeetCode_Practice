class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // Lets Implement Floyd Warshall ::
        int[][] dist =new int[n][n];
        Arrays.stream(dist).forEach(a->Arrays.fill(a,(int)1e9));
        for(int i=0;i<edges.length;i++){
            int[] temp =edges[i];
            dist[temp[0]][temp[1]] = temp[2];
            dist[temp[1]][temp[0]] = temp[2];
        }
        for(int i=0;i<n;i++){
            dist[i][i]=0;
        }
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dist[i][k]==(int)1e9 || dist[k][j]==(int)1e9) continue;
                    dist[i][j] =Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                }
            }
        }
        int cntcity =n;
        int cityNo=-1;
        
        for(int i=0;i<n;i++){
            int cnt=0;
            for(int j=0;j<n;j++){
                if(dist[i][j]<=distanceThreshold){
                    cnt++;
                }
            }
            if(cnt<=cntcity){
                cntcity=cnt;
                cityNo=i;
            }
        }
        return cityNo;
    }
}