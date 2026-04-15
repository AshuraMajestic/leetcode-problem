class Solution {
    public List<String> generateParenthesis(int n) {
        Stack<Character> st=new Stack<>();
        List<String> ans=new ArrayList<>();
        backtrack(n,0,0,ans,st);
        return ans;
    }
    private void backtrack(int n,int startN,int endN,List<String> ans,Stack<Character> st){
        if(startN==endN && startN==n){
            StringBuilder sb=new StringBuilder();
            for(char c:st){
                sb.append(c);
            }
            ans.add(sb.toString());
            return;
        }
        if(startN<n){
            st.push('(');
            backtrack(n,startN+1,endN,ans,st);
            st.pop();
        }
        if(endN<startN){
            st.push(')');
            backtrack(n,startN,endN+1,ans,st);
            st.pop();
        }
    }
}
