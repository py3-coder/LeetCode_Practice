class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n =values.length;
        // Lets Make Graph ::
        HashMap<String,HashMap<String,Double>> map = new HashMap<>();
        
        for(int i=0;i<equations.size();i++){
            String start = equations.get(i).get(0);
            String end = equations.get(i).get(1);
            double ratio = values[i];
            map.putIfAbsent(start, new HashMap<>());
            map.get(start).put(end, ratio);
            map.putIfAbsent(end, new HashMap<>());
            map.get(end).put(start, 1.0 / ratio);
        }
        double[] res =new double[queries.size()];
        int k=0;
        for(List<String> temp : queries){
            Set<String> vis = new HashSet<>();
            String start =temp.get(0);
            String end =temp.get(1);
            if (!map.containsKey(start) || !map.containsKey(end)) {
                res[k] = -1.0;
                k++;
                continue;
            }
            double val = dfs(start,end,map,vis);
            res[k] =val;
            k++;
        }
        return res;
    }
    public double dfs(String start,String end,HashMap<String,HashMap<String,Double>> graph,Set<String> vis){
        if(graph.get(start).containsKey(end)) {
            return graph.get(start).get(end);
        }
        vis.add(start);
        for (Map.Entry<String, Double> entry : graph.get(start).entrySet()) {
            if (vis.contains(entry.getKey())) continue;
            double res = dfs(entry.getKey(),end,graph,vis);
            if (res == -1.0) continue;
            return res * entry.getValue();
        }
        return -1.0;
    }
}