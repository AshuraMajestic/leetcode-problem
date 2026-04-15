class Solution {
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int orangesRotting(int[][] grid) {
        int maxTime = 0;
        int n = grid.length;
        int m = grid[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int oranges = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    oranges++;
                }
                if (grid[i][j] == 2) {
                    pq.offer(new int[]{i, j, 0});
                }
            }
        }

        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            int x = temp[0];
            int y = temp[1];
            int t = temp[2];
            maxTime = Math.max(maxTime, t);

            for (int[] d : directions) {
                int newx = x + d[0];
                int newy = y + d[1];
                if (newx < 0 || newy < 0 || newx >= n || newy >= m || grid[newx][newy] != 1) continue;

                oranges--;
                grid[newx][newy] = 2; // ✅ correct: mark the neighbor as rotten
                pq.offer(new int[]{newx, newy, t + 1});
            }
        }

        return oranges == 0 ? maxTime : -1;
    }
}
