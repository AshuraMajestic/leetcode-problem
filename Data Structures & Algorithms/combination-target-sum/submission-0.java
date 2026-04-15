class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backTrack(candidates, 0, target, new ArrayList<>(), 0, ans);
        return ans;
    }
    private void  backTrack(int[] candidates,int start,int target,List<Integer> li,int sum,List<List<Integer>> ans){
        if(sum==target){
            ans.add(new ArrayList<>(li));
            return;
        }
        if(sum>target){
            return;
        }
        for(int i=start;i<candidates.length;i++){
            li.add(candidates[i]);
             backTrack(candidates, i, target, li, sum + candidates[i], ans);
            li.remove(li.size()-1);
        }
    }
}