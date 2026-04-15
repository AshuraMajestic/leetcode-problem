class Solution {
    List<List<Integer>> map;
    public boolean validTree(int n, int[][] edges) {
        if(edges.length>n-1) return false;
        map=new ArrayList<>();
        for(int i=0;i<n;i++){
            map.add(new ArrayList<>());
        }
        for(int[] i:edges){
            int u=i[0];
            int v=i[1];
            map.get(u).add(v);
            map.get(v).add(u);
        }
        HashSet<Integer> visited=new HashSet<>();
        if(!dfs(0,-1,visited)){
            return false;
        }
        return visited.size()==n;
    }
    private boolean dfs(int node,int parent,HashSet<Integer> visit){
        if(visit.contains(node)) return false;
        visit.add(node);
        for(int i:map.get(node)){
            if(i==parent) continue;
            if(!(dfs(i,node,visit))){
                return false;
            }
        }
        return true;
    }
}
