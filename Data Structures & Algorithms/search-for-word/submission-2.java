class Solution {
    char[][] board;
    String word;
    int m,n;
    public boolean exist(char[][] board, String word) {
        this.board=board;
        this.word=word;
        this.n=board.length;
        this.m=board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==word.charAt(0)){
                    boolean[][] visited=new boolean[n][m];
                    if(check(i,j,0,visited)){
                        return true;
                    }
                }
		    }
		}
        return false;
    }
    private boolean check(int i,int j,int idx,boolean[][] visited){
        if(i<0 || i>=n || j<0 || j>=m || idx>=word.length() || board[i][j]!=word.charAt(idx) || visited[i][j]) return false;
        if(idx==word.length()-1) return true;
        visited[i][j]=true;
         boolean found = check(i + 1, j, idx + 1, visited) ||
                    check(i - 1, j, idx + 1, visited) ||
                    check(i, j + 1, idx + 1, visited) ||
                    check(i, j - 1, idx + 1, visited);
        visited[i][j] = false; 

    return found;
        
    }
}
