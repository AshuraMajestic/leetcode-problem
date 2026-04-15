class Solution {
    int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};
    public void islandsAndTreasure(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[2]-b[2]);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    pq.offer(new int[]{i,j,0});
                }
		    }
        }
        while(!pq.isEmpty()){
            int[] temp=pq.poll();
            int x=temp[0];
            int y=temp[1];
            int w=temp[2];
            if(w>grid[x][y])continue;
            grid[x][y]=w;
            for(int[] d:dir){
                int newx=x+d[0];
                int newy=y+d[1];
                if(newx<0 || newx>=n || newy<0 || newy>=m || grid[newx][newy]==-1) continue;
                if (grid[newx][newy] > w + 1) {
                    pq.offer(new int[]{newx, newy, w + 1});
                }
            }
        }
    }
}
