class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left=1;
        int right=Arrays.stream(piles).max().getAsInt();
        int res=right;
        while(left<right){
            int k=left+(right-left)/2;
            if(eatPiles(piles,h,k)){
                right=k;
            }else{
                left=k+1;
            }
        }
        return left;
    }
    private boolean eatPiles(int[] piles,int h,int k){
        int totalTime=0;
        for(int i:piles){
            totalTime+=Math.ceil((double)i/k);
        }
        return totalTime<=h;
    }
}
