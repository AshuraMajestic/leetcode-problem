class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n=position.length;
        double[][] pair=new double[n][2];
        for(int i=0;i<n;i++){
            pair[i][0]=position[i];
            pair[i][1]=speed[i];
		}
        Arrays.sort(pair,(a,b)->Double.compare(b[0],a[0]));
       int fleets = 0;
        double lastTime = 0;
        
        // Calculate time for each car and count fleets
        for (int i = 0; i < n; i++) {
            double time = (target - pair[i][0]) / pair[i][1];
            if (time > lastTime) {
                fleets++;
                lastTime = time;
            }
        }
        
        return fleets;
    }
}
