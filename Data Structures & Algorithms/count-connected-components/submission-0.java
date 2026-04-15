class Solution {
    List<List<Integer>> map;
    public int countComponents(int n, int[][] edges) {
        map=new ArrayList<>();
        for(int i=0;i<n;i++){
            map.add(new ArrayList<>());
		}
        for(int[] e:edges){
            int u=e[0];
            int v=e[1];
            map.get(u).add(v);
            map.get(v).add(u);
        }
        boolean[] visited=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i,visited);
                count++;
            }
		}
        return count;
    }
    private void dfs(int node,boolean[] visited){
        visited[node]=true;
        for(int i:map.get(node)){
            if(!visited[i]){
                dfs(i,visited);
            }
        }
    }
}
