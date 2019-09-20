class Solution {
    public int[][] kClosest(int[][] points, int K) {
    	int[] arr = new int[points.length];
    	int[][] res = new int[K][2];
    	for(int i = 0; i < points.length; i++) {
    		arr[i] = points[i][0] * points[i][0] + points[i][1] * points[i][1];
    	}
    	
    	Arrays.sort(arr);
        
    	int j = 0;
    	for(int i = 0; i < points.length; i++) {
    		if(arr[K - 1] >= points[i][0] * points[i][0] + points[i][1] * points[i][1]) {
    			res[j][0] = points[i][0];
    			res[j][1] = points[i][1];
    			j++;
    		}
    	}
    	
        return res;
    }
}