class Solution {
    public boolean canFinish(int numCourses, int[][] pre) {
        int[] indegree=new int[numCourses];
        boolean[] all=new boolean[numCourses];
        List<List<Integer>> map=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            map.add(new ArrayList<>());
        }
        for(int[] e:pre){
            int u=e[0];
            int v=e[1];
            indegree[v]++;
            map.get(u).add(v);
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
                all[i]=true;
            }
        }
        while(!q.isEmpty()){
            int node=q.poll();
            for(int i:map.get(node)){
                indegree[i]--;
                if(indegree[i]==0 && !all[i]){
                    q.add(i);
                    all[i]=true;
                }
            }
        }
        for(boolean b:all){
            if(!b){
                return false;
            }
        }
        return true;
    }
}