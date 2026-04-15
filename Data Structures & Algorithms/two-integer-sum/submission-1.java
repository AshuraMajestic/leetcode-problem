class Solution {
    public int[] twoSum(int[] nums, int target) {
       HashMap<Integer,Integer> all = new HashMap<>();
       for(int i=0;i<nums.length;i++){
        int num=nums[i];
        int diff=target-num;
        if(all.containsKey(diff)){
            return new int[]{all.get(diff),i};
        }
        all.put(num,i);
		}
        return new int[]{};
    }
    
}
