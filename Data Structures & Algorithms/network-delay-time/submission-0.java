class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0;i<n;i++) graph.add(new ArrayList<>());
        for(int i=0;i<times.length;i++){
            int u = times[i][0]-1;
            int v = times[i][1]-1;
            int cost = times[i][2];
            graph.get(u).add(new int[]{v,cost});
        }
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{k-1,0});
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k-1] = 0;
        while(!dq.isEmpty()){
            int[] currSet = dq.poll();
            int currNode = currSet[0];
            int cost = currSet[1];
            List<int[]> nodeSet = graph.get(currNode);
            for(int[] node: nodeSet){
                if(dist[node[0]]>cost+node[1]){
                    dist[node[0]] = cost+node[1];
                    dq.add(new int[]{node[0],cost+node[1]});
                }
            }
        }
        int ans = 0;
        for(int i=0;i<dist.length;i++)
            ans = Math.max(ans, dist[i]);
        return ans == Integer.MAX_VALUE?-1:ans;
    }
}