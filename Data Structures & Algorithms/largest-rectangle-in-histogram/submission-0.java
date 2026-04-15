class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea=0;
        Stack<int[]> pair = new Stack<>();
        for(int i=0;i<heights.length;i++){
            int start=i;
            while(!pair.isEmpty() && pair.peek()[1]>heights[i]){
                int[] paired=pair.pop();
                maxArea=Math.max(maxArea,paired[1]*(i-paired[0]));
                start=paired[0];
            }
            pair.push(new int[]{start,heights[i]});
		}
        while(!pair.isEmpty()){
            int[] paired=pair.pop();
                maxArea=Math.max(maxArea,paired[1]*(heights.length-paired[0]));
        }
        return maxArea;
    }
}
