class Solution {
    HashMap<String, PriorityQueue<String>> map;

    public List<String> findItinerary(List<List<String>> tickets) {
        map = new HashMap<>();

        for (List<String> t : tickets) {
            map.computeIfAbsent(t.get(0), k -> new PriorityQueue<>())
               .add(t.get(1));
        }

        LinkedList<String> ans = new LinkedList<>();
        dfs("JFK", ans);
        return ans;
    }

    private void dfs(String curr, LinkedList<String> ans) {
        PriorityQueue<String> pq = map.get(curr);

        while (pq != null && !pq.isEmpty()) {
            dfs(pq.poll(), ans);
        }

        ans.addFirst(curr); 
    }
}