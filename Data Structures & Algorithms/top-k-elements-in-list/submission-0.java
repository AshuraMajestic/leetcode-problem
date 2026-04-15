class Solution {
    public int[] topKFrequent(int[] nums, int k) {
         int[] freq = new int[20001];
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> freq[b] - freq[a]);

        for (int i : nums) {
            freq[i + 10000]++;
        }

        for (int i = 0; i < 20001; i++) {
            if (freq[i] != 0) pq.add(i);
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll() - 10000;
        }

        return ans;
    }
}
