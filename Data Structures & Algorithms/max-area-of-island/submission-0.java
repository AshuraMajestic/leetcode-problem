class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        Set<String> visited=new HashSet<>();
        int size=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    size=Math.max(dfs(grid, i, j,visited),size);
                }
            }
        }
        
        return size;
    }
    private int dfs(int[][] grid, int i, int j,Set<String> visited) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1 || visited.contains(i+","+j)) {
            return 0;
        }
        
        visited.add(i+","+j);
        
        return 1+ dfs(grid, i + 1, j,visited)+
        dfs(grid, i - 1, j,visited)+
        dfs(grid, i, j + 1,visited)+
        dfs(grid, i, j - 1,visited);
    }
}
