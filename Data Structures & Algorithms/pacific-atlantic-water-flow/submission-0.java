class Solution {
    int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();

        // Initialize queues for both oceans
        for (int i = 0; i < n; i++) {
            pacific[i][0] = true;
            pacificQueue.offer(new int[]{i, 0});
            atlantic[i][m - 1] = true;
            atlanticQueue.offer(new int[]{i, m - 1});
        }

        for (int j = 0; j < m; j++) {
            pacific[0][j] = true;
            pacificQueue.offer(new int[]{0, j});
            atlantic[n - 1][j] = true;
            atlanticQueue.offer(new int[]{n - 1, j});
        }

        // BFS from both oceans
        bfs(heights, pacific, pacificQueue, n, m);
        bfs(heights, atlantic, atlanticQueue, n, m);

        // Result: cells reachable from both oceans
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    private void bfs(int[][] heights, boolean[][] visited, Queue<int[]> queue, int n, int m) {
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0];
            int y = cell[1];

            for (int[] d : dir) {
                int nx = x + d[0];
                int ny = y + d[1];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny]) {
                    continue;
                }

                // Move only if the next height is >= current (reverse flow condition)
                if (heights[nx][ny] >= heights[x][y]) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
    }
}
