class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        int n = edges.length;

        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new HashSet<>()).add(edge[0]);
        }

        for (int i = n - 1; i >= 0; i--) {
            int u = edges[i][0];
            int v = edges[i][1];

            graph.get(u).remove(v);
            graph.get(v).remove(u);

            Set<Integer> visited = new HashSet<>();
            dfs(graph, edges[0][0], visited);

            if (visited.size() == graph.size()) {
                return edges[i];
            }

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return new int[0];
    }

    private void dfs(Map<Integer, Set<Integer>> graph, int node, Set<Integer> visited) {
        if (!visited.add(node)) return;
        for (int nei : graph.getOrDefault(node, Collections.emptySet())) {
            dfs(graph, nei, visited);
        }
    }
}
