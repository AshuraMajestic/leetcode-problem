class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows=matrix.length;
        int cols=matrix[0].length;
        for(int i=0;i<rows;i++){
            if(target>=matrix[i][0] && target<=matrix[i][cols-1]){
                return binarySearch(matrix,target,i);
            }
		}
        return false;
    }
    private boolean binarySearch(int[][] matrix,int target,int i){
        int cols=matrix[0].length;
        int start=0;
        int end=cols-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(matrix[i][mid]==target){
                return true;
            }else if(matrix[i][mid]>target){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return false;
    }
}
