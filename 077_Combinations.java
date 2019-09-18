class Solution {
    private List<List<Integer>> out = null;
	private Set<List<Integer>> set = null;
    public List<List<Integer>> combine(int n, int k) {
		out = new LinkedList<>();
		set = new HashSet<>();
		
		for(int i = 1; i <= n; i++) {
			LinkedList<Integer> tempArr = new LinkedList<>();
			tempArr.add(i);
			Set<Integer> tempSet = new HashSet<>();
			tempSet.add(i);
			dfs(n, k - 1, tempArr, tempSet, i);
		}
		
		return out;
    }
    
    private void dfs(int n, int level, List<Integer> Arr, Set<Integer> curSet, int index) {
		if(level == 0 && !set.contains(Arr)) {
			set.add(Arr);
			out.add(Arr);
		}
		
		for(int i = index; i <= n; i++) {
			if(!curSet.contains(i)) {
				LinkedList<Integer> curArr = new LinkedList<>(Arr);
				curArr.add(i);
				Set<Integer> tempSet = new HashSet<>(curSet);
				tempSet.add(i);
				dfs(n, level - 1, curArr, tempSet, i + 1);
			}
		}
	}
    
}