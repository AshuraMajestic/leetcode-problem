
class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = intervals.length;
        int q = queries.length;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int[][] qArr = new int[q][2];
        for (int i = 0; i < q; i++) {
            qArr[i][0] = queries[i];
            qArr[i][1] = i;
        }
        Arrays.sort(qArr, (a, b) -> a[0] - b[0]);

        int[] ans = new int[q];
        Arrays.fill(ans, -1);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]   // min by interval length
        );

        int i = 0;

        for (int[] query : qArr) {
            int val = query[0];
            int idx = query[1];

            // Add valid intervals
            while (i < n && intervals[i][0] <= val) {
                int start = intervals[i][0];
                int end = intervals[i][1];
                int len = end - start + 1;
                pq.offer(new int[]{len, end});
                i++;
            }

            // Remove invalid intervals
            while (!pq.isEmpty() && pq.peek()[1] < val) {
                pq.poll();
            }

            if (!pq.isEmpty()) {
                ans[idx] = pq.peek()[0];
            }
        }

        return ans;
    }
}
