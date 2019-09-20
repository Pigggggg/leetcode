class Solution {
    private Map<Integer, Integer> map = new HashMap<>();
    public int climbStairs(int n) {
        map.put(2, 2);
        map.put(1, 1);
        int res = 0;
        if(n > 0) {
        	res = dfs(n);
        }
        
        System.out.println(res);
    	return res;
    }
    
    private int dfs(int curr) {
    	if(map.containsKey(curr)) {
    		return map.get(curr);
    	}
    	
    	int curres = dfs(curr - 1) + dfs(curr -2);
    	map.put(curr, curres);
    	
    	return curres;
    }
}