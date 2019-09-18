class Solution {
    private List<List<Integer>> out = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
    	dfs(candidates, target, new LinkedList<>(), 0);
    	
        return out;
    }
    
    private void dfs(int[] candidates,int curr, List<Integer> arr, int index){
    	if(curr == 0) {
    		out.add(arr);
    	}
    	
    	if(curr > 0) {
    		for(int i = index; i < candidates.length; i++) {
    			if(curr - candidates[i] >= 0) {
    				LinkedList<Integer> temp = new LinkedList<>(arr);
    				temp.add(candidates[i]);
            		dfs(candidates, curr - candidates[i], temp, i);	
    			}
        	}
    	}
    }
}