class Solution {
    static HashMap<Character, List<Character>> a;
    static{
        a = new HashMap<>();
        a.put('2', new ArrayList<>(Arrays.asList('a', 'b', 'c')));
        a.put('3', new ArrayList<>(Arrays.asList('d', 'e', 'f')));
        a.put('4', new ArrayList<>(Arrays.asList('g', 'h', 'i')));
        a.put('5', new ArrayList<>(Arrays.asList('j', 'k', 'l')));
        a.put('6', new ArrayList<>(Arrays.asList('m', 'n', 'o')));
        a.put('7', new ArrayList<>(Arrays.asList('p', 'q', 'r','s')));
        a.put('8', new ArrayList<>(Arrays.asList('t', 'u', 'v')));
        a.put('9', new ArrayList<>(Arrays.asList('w', 'x', 'y','z')));
    }
    public List<String> letterCombinations(String digits) {
        List<String> ans=new ArrayList<>();
        if(digits.length()==0){
            return ans;
        }
        backTrack(new StringBuilder(),digits,0,ans);
        return ans;
    }
    private void backTrack(StringBuilder sb,String d,int idx,List<String> ans){
        if(idx==d.length()){
            ans.add(sb.toString());
            return;
        }
        if(idx>d.length()) return;
        for(Character c:a.get(d.charAt(idx))){
            sb.append(c);
            backTrack(sb,d,idx+1,ans);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}