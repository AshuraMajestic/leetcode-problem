class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq1=new int[26];
        for(char i:s1.toCharArray()){
            freq1[i-'a']++;
        }
        int n=s2.length();
        for(int i=0;i<=n-s1.length();i++){
            int[] freq2=new int[26];
            for(int j=i;j<i+s1.length();j++){
                freq2[s2.charAt(j)-'a']++;
            }
            if(match(freq1,freq2)){
                return true;
            }
        }
        return false;
    }
    private boolean match(int[] freq1,int[] freq2){
        for(int i=0;i<26;i++){
            if(freq1[i]!=freq2[i]){
                return false;
            }
        }
        return true;
    }
}
