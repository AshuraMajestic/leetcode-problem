class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> all = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(all.contains(nums[i])){
                return true;
            }
            all.add(nums[i]);
		}
        return false;
    }
}
