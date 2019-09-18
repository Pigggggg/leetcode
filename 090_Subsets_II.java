class Solution {
    private static List<List<Integer>> out = null;
	private static Set<List<Integer>> set = null;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
		out = new LinkedList<>();
		set = new HashSet<>();
		
		Arrays.sort(nums);
		for(int i = 0; i < nums.length; i++) {
			LinkedList<Integer> tempArr = new LinkedList<>();
			tempArr.add(nums[i]);
			Set<Integer> tempSet = new HashSet<>();
			tempSet.add(i);
			dfs(nums, tempArr, tempSet, i);
		}
		
		out.add(new LinkedList<Integer>());
		return out;
    }
    private void dfs(int[] nums, List<Integer> Arr, Set<Integer> curSet, int index) {
		if(!set.contains(Arr)) {
			set.add(Arr);
			out.add(Arr);
		}
		
		for(int i = index; i < nums.length; i++) {
			if(!curSet.contains(i)) {
				LinkedList<Integer> curArr = new LinkedList<>(Arr);
				curArr.add(nums[i]);
				Set<Integer> tempSet = new HashSet<>(curSet);
				tempSet.add(i);
				dfs(nums, curArr, tempSet, i + 1);
			}
		}
	}
}