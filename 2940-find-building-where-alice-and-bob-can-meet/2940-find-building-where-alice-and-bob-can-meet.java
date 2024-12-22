class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length, m = queries.length;
        List<int[]>[] arr = new List[n];
        for(int i=0;i<n;i++) {
            arr[i] = new ArrayList<>();
        }
        int[] res = new int[m];
        for(int i=0;i<m;i++) {
            int[] query = queries[i];
            if(query[0] > query[1]) {
                int tmp = query[0];
                query[0] = query[1];
                query[1] = tmp;
            }
            int a = query[0], b = query[1];
            if(a == b || heights[a] < heights[b]) {
                res[i] = b;
            } else {
                arr[b].add(new int[]{heights[a], i});
            }   
        }
        List<Integer> queue = new ArrayList<>();
        int length = 0;
        for(int i=n-1;i>=0;i--) {
            while(length>0 && heights[i] >= heights[queue.get(length-1)]) {
                queue.remove(length-1);
                length--;
            }
            List<int[]>list = arr[i];
            for(int[] pair: list) {
                int height = pair[0];
                int index = pair[1];
                res[index] = search(queue, heights, height);
            }
            queue.add(i);
            length++;
        }
        return res;
    }
    public int search(List<Integer> list, int[] heights, int height) {
        int n = list.size();
        if(n == 0 || height >= heights[list.get(0)]) return -1;
        int s = 0, e = n-1;
        while(s <= e) {
            int mid = (s+e)/2;
            int cur = heights[list.get(mid)];
            if(cur > height) {
                s = mid + 1;
            } else {
                e = mid-1;
            }
        }
        return list.get(e);
    }
}