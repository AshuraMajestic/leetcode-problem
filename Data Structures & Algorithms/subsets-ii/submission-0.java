class Solution {
    List<List<Integer>> ans;
    int[] nums;
    int n;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums=nums;
        this.n=nums.length;
        ans=new ArrayList<>();
        recurse(0,new ArrayList<>());
        return ans;
    }
    private void recurse(int idx,List<Integer> li){
        ans.add(new ArrayList<>(li));
         for (int i = idx; i < n; i++) {
            if (i > idx && nums[i] == nums[i - 1]) continue;
            li.add(nums[i]);        
            recurse(i + 1, li);    
            li.remove(li.size() - 1); 
        }

    }
}
