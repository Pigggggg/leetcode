class Solution {
    private List<List<Integer>> out = null;
	private Set<List<Integer>> set = null;
    public List<List<Integer>> combinationSum3(int k, int n) {
    	out = new LinkedList<>();
		set = new HashSet<>();
		
		for(int i = 1; i <= 9; i++) {
			LinkedList<Integer> tempArr = new LinkedList<>();
			tempArr.add(i);
			dfs(n - i, tempArr, k - 1, i + 1);
		}
		return out;
    }
    
    private void dfs(int curr, List<Integer> Arr, int level, int index) {
		if(curr == 0 && level == 0 && !set.contains(Arr)) {
			set.add(Arr);
			out.add(Arr);
			return;
		}
		
		for(int i = index; i <= 9; i++) {
			if(curr - i >= 0) {
				LinkedList<Integer> curArr = new LinkedList<>(Arr);
				curArr.add(i);
				dfs(curr - i, curArr, level - 1, i + 1);
			}
		}
	}
}