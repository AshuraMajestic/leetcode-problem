class WordDictionary {
    class TrieNode {
        TrieNode[] children=new TrieNode[26];
        boolean isEnd;
    }
    TrieNode root;
    public WordDictionary() {
        root=new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode crawler=root;
        for(int i=0;i<word.length();i++){
            int index=word.charAt(i)-'a';
            if(crawler.children[index]==null){
                crawler.children[index]=new TrieNode();
            }
            crawler=crawler.children[index];
        }
        crawler.isEnd=true;
    }
    private boolean find(String word,int idx,TrieNode crawl){
        if (idx == word.length()) return crawl.isEnd;
        if(idx>word.length()) return false;
        if(word.charAt(idx)!='.'){
            int index=word.charAt(idx)-'a';
            if(crawl.children[index]!=null){
                return find(word,idx+1,crawl.children[index]);
            }else{
                return false;
            }
        }else{

            for(int i=0;i<26;i++){
                if(crawl.children[i]!=null){
                    if(find(word,idx+1,crawl.children[i])){
                        return true;
                    }
                } 
                
            }
        }
        return false;
    }
    public boolean search(String word) {
        TrieNode crawler=root;
        return find(word,0,crawler);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */