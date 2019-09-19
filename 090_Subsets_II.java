class Solution {
    List<List<Integer>> out = null;
    Set<List<Integer>> set = null;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        out = new LinkedList<>();
        set = new HashSet<>();
        Arrays.sort(nums);
        dfs(nums, nums.length, new LinkedList<>(), 0);
        return out;
    }
    
    private void dfs(int[] nums, int level, List<Integer> arr, int index){
        if(level >= 0 && !set.contains(arr)){
            set.add(new LinkedList<>(arr));
            out.add(new LinkedList<>(arr));   
        }
        
        for(int i = index; i < nums.length; i++){
            arr.add(nums[i]);
            dfs(nums, level - 1, arr, i + 1);
            arr.remove(arr.size() - 1);
        }
    }
}