class Solution {
     List<List<String>> ans;
    String s;

    private void backtrack(int start,List<String> curr){
            if (start == s.length()) {
                ans.add(new ArrayList<>(curr));
                return;
            }

            for (int end = start; end < s.length(); end++) {
                String substr = s.substring(start, end + 1);
                if (isPalindrome(substr)) {
                    curr.add(substr);
                    backtrack(end + 1, curr);
                    curr.remove(curr.size() - 1);
                }
            }
        }
    private boolean isPalindrome(String a){
        int i=0;
        int j=a.length()-1;
        while(i<j){
            if(a.charAt(i)!=a.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        this.s = s;
        backtrack(0, new ArrayList<>());
        return ans;
    }
  }