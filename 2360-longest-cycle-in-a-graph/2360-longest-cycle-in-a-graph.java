class Solution {
    public int longestCycle(int[] edges) {
        int longestCycleLen = -1;
        int timeStep = 1;
        int[] nodeVisitedAtTime = new int[edges.length];

        for (int currentNode = 0; currentNode < edges.length; ++currentNode) {
            if (nodeVisitedAtTime[currentNode] > 0)
                continue;
            final int startTime = timeStep;
            int u = currentNode;
            while (u != -1 && nodeVisitedAtTime[u] == 0) {
                nodeVisitedAtTime[u] = timeStep++;
                u = edges[u];
            }
            if (u != -1 && nodeVisitedAtTime[u] >= startTime)
                longestCycleLen = Math.max(longestCycleLen, timeStep - nodeVisitedAtTime[u]);
        }

        return longestCycleLen;
    }
}