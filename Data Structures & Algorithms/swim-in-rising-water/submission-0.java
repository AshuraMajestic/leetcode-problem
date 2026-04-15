class Solution {
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        int[][] dist=new int[n][n];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{grid[0][0],0,0});
        dist[0][0]=1;
        int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int t=curr[0];
            int r=curr[1];
            int c=curr[2];

            if(r==n-1 && c==n-1) return t;
            for(int[] d:dir){
                int nr=r+d[0];
                int nc=c+d[1];

                if(nr>=0 && nc>=0 && nr<n && nc<n && dist[nr][nc]==0){
                    if(grid[nr][nc]<=t){
                        pq.add(new int[]{t,nr,nc});
                        dist[nr][nc]=1;
                    }
                    else{
                        pq.add(new int[]{grid[nr][nc],nr,nc});
                        dist[nr][nc]=1;
                    }
                }
            }
        }
        return 0;
    }
}