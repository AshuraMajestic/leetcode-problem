class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        int maxFreq = 0;
        int maxLength = 0;

        for (int end = 0; end < n; end++) {
            char endChar = s.charAt(end);
            map.put(endChar, map.getOrDefault(endChar, 0) + 1);

            maxFreq = Math.max(maxFreq, map.get(endChar));

            while ((end - start + 1) - maxFreq > k) {
                char startChar = s.charAt(start);
                map.put(startChar, map.get(startChar) - 1);
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}
