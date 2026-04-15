class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        Set<Integer> s=new HashSet<>();
        for(int i:nums){
            s.add(i);
        }
        int maxLength=0;
        for(int i:s){
            if(!s.contains(i-1)){
                int currentNum=i;
                int currentStreak=1;
                while(s.contains(currentNum+1)){
                    currentNum++;
                    currentStreak++;
                }
                maxLength=Math.max(currentStreak,maxLength);
            }
        }
        return maxLength;
    }
}
