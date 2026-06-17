class Solution {
    public int minimumLines(int[][] stockPrices) {
        int n = stockPrices.length;
        
        if(n == 1) return 0;
        
        Arrays.sort(stockPrices, (a, b) -> a[0] - b[0]);
        
        int count = 1;
        long prevDy = stockPrices[1][1] - stockPrices[0][1];
        long prevDx = stockPrices[1][0] - stockPrices[0][0];
        
        for(int i = 2; i < n; i++) {
            long dy = stockPrices[i][1] - stockPrices[i-1][1];
            long dx = stockPrices[i][0] - stockPrices[i-1][0];
            
            if(dy * prevDx != dx * prevDy) {
                count++;
                prevDy = dy;
                prevDx = dx;
            }
        }
        
        return count;
    }
}