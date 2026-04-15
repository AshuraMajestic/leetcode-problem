class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[] prefix=new int[n];
        int[] suffix=new int[n];
        prefix[0]=prices[0];
        for(int i=1;i<n;i++){
            prefix[i]=Math.min(prices[i],prefix[i-1]);
        }
        suffix[n-1]=prices[n-1];
        for(int i=n-2;i>=0;i--){
            suffix[i]=Math.max(prices[i],suffix[i+1]);
        }
        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,suffix[i]-prefix[i]);
        }
        return max;
    }
}
