class Solution
{
    private HashMap<String, PriorityQueue<String>> map= new HashMap<>();//Starting airport -> Destination airport(lexically asc sorted)
    private LinkedList<String> res= new LinkedList<>();//result 
    
    public List<String> findItinerary(List<List<String>> tickets)
    {
        /*Note::
         *->The main idea is to traverse every edge atmost once
         *->And we are starting from JFK airport
         *->We use Priority Queue to store the adjacent airport in Lexically sorted manner
         *->We use a topological sort like approach for displaying the result, i.e, we start from an no in-dependency edge to the most in-dependenncy edge
         *->We are considering the euler path to traverse the graph 
         *->Priority Queue is also helping us keep track of the visited and non-visited edge 
         *->Hash Map is Used like a adjacency list here 
         */
        
        for (List<String> ticket: tickets)
        {
            String u= ticket.get(0);//starting airport
            String v= ticket.get(1);//destination airport
            
            PriorityQueue<String> temp= map.getOrDefault(u, new PriorityQueue<>());
            temp.offer(v);//adding the desitination airport 
            map.put(u, temp);//adding to the map 
        }
        
        dfs("JFK");//Journey Starting Airport
        
        return res;
    }
    private void dfs(String src)
    {
        PriorityQueue<String> pq= map.get(src);//Adjacent Airports
        
        while (pq != null && pq.size() > 0){//processsing all the destination Airport of the current Airport(src)
            String temp= pq.poll();//removing the edge//visited 
            dfs(temp);//recursing down 
        }
        res.addFirst(src);//adding the Airport while backtracking//least in-dependency as far as possible 
        return;
    }
}