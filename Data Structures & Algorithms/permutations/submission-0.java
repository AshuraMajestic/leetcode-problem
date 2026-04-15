class Solution {
    List<List<Integer>> ans;
    int n;
    int[] nums;
    public List<List<Integer>> permute(int[] nums) {
        ans=new ArrayList<>();
        this.n=nums.length;
        this.nums=nums;
        boolean[] visited=new boolean[n];
        backTrack(new ArrayList<>(),visited);
        return ans;
    }
    private void backTrack(List<Integer> curr,boolean[] visited){
        if(curr.size()==n){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0;i<n;i++){
            if(!visited[i]){
            visited[i]=true;
            curr.add(nums[i]);
            backTrack(curr,visited);
            curr.remove(curr.size()-1);
            visited[i]=false;
            }
        }
    }
}