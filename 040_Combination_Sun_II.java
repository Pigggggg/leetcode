class Solution {
    private List<List<Integer>> out = new LinkedList<>();
	private Set<List<Integer>> set = new HashSet<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
    	dfs(candidates, target, new LinkedList<>(), 0);
    	
        return out;
    }
    
    private void dfs(int[] candidates,int curr, List<Integer> arr, int index){
    if(curr == 0 && !set.contains(arr)) {
        set.add(arr);
        out.add(arr);
    }

    if(curr > 0) {
        for(int i = index; i < candidates.length; i++) {
            if(curr - candidates[i] >= 0 && i < candidates.length) {
                LinkedList<Integer> temp = new LinkedList<>(arr);
                temp.add(candidates[i]);
                dfs(candidates, curr - candidates[i], temp, i + 1);	
            }
        }
    }
}
}