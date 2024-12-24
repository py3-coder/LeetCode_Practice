class Solution {
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;

        List<List<Integer>> t2 = buildTree(m, edges2);
        int d2 = getDiameter(t2, m);

        List<List<Integer>> t1 = buildTree(n, edges1);
        int d1 = getDiameter(t1, n);

        return Math.max(d1, Math.max(d2, (d1 + 1) / 2 + (d2 + 1) / 2 + 1));
    }

    private List<List<Integer>> buildTree(int size, int[][] edges) {
        List<List<Integer>> tree = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            tree.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        return tree;
    }

    private int getDiameter(List<List<Integer>> tree, int n) {
        int[] firstDFS = dfs(tree, 0, -1);
        int[] secondDFS = dfs(tree, firstDFS[0], -1);
        return secondDFS[1];
    }

    private int[] dfs(List<List<Integer>> tree, int node, int parent) {
        int farthestNode = node;
        int maxDistance = 0;

        for (int neighbor : tree.get(node)) {
            if (neighbor == parent) continue;
            int[] result = dfs(tree, neighbor, node);
            if (result[1] + 1 > maxDistance) {
                maxDistance = result[1] + 1;
                farthestNode = result[0];
            }
        }

        return new int[]{farthestNode, maxDistance};
    }
}
