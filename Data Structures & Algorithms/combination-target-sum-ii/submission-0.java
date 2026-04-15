class Solution {
    private int[] candidates;
    private int target;
    private int n;
    private List<List<Integer>> ans;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans=new ArrayList<>();
        Arrays.sort(candidates);
        this.candidates=candidates;
        this.target=target;
        this.n=candidates.length;
        backTrack(0,new ArrayList<>(),0);
        return ans;
    }
    private void backTrack(int start,List<Integer> li,int sum){
        if(sum==target){
            ans.add(new ArrayList<>(li));
            return;
        }
        if(sum>target){
            return;
        }
        for(int i=start;i<n;i++){
            if(i>start && candidates[i]==candidates[i-1]) continue;
            if(candidates[i]>target) continue;
                li.add(candidates[i]);
                backTrack(i+1,li,sum+candidates[i]);
                li.remove(li.size()-1);
            }
        }
    }