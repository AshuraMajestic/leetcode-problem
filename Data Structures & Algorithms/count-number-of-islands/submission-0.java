class Solution {
    public int numIslands(char[][] grid) {
       int rows=grid.length;
       int cols=grid[0].length;
       int count=0;
       for(int i=0;i<rows;i++){
        for(int j=0;j<cols;j++){
                if(grid[i][j]=='1'){
                    count++;
                    bfs(i,j,rows,cols,grid);
                }
    		}
	    }
        return count;
    }
    private void bfs(int i,int j,int n,int m,char[][] grid){
        if(i<0 || i>=n || j<0 || j>=m || grid[i][j]=='0'){
            return;
        }
        grid[i][j]='0';
        bfs(i-1,j,n,m,grid);
        bfs(i+1,j,n,m,grid);
        bfs(i,j+1,n,m,grid);
        bfs(i,j-1,n,m,grid);
    }
}
