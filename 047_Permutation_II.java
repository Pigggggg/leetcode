class Solution {
    private static List<List<Integer>> out = null;
	private static Set<List<Integer>> set = null;
    public List<List<Integer>> permuteUnique(int[] nums) {
        out = new LinkedList<>();
		set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
			List<Integer> temp = new LinkedList<>();
			Set<Integer> tempSet= new HashSet<>();
			temp.add(nums[i]);
			tempSet.add(i);
			dfs(nums, temp, tempSet);
		}
		
		return out;
    }
    
    	private static void dfs(int[] nums, List<Integer> arr, Set<Integer> currSet) {
		if(nums.length == arr.size() && !set.contains(arr)) {
			set.add(arr);
			out.add(arr);
			return;
		}
		
		for (int i = 0; i < nums.length; i++) {
			if(!currSet.contains(i)) {
				LinkedList<Integer> curArr = new LinkedList<>(arr);
				curArr.add(nums[i]);
				Set<Integer> curSet = new HashSet<>(currSet);
				curSet.add(i);
				dfs(nums, curArr, curSet);
			}
		}
	}
}