class Solution {
    List<List<Integer>> out = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, nums.length, new LinkedList<Integer>(), 0);
        return out;
    }
    
    private void dfs(int[] nums, int level, List<Integer> arr, int index){
        if(level >= 0){
            out.add(new LinkedList<Integer>(arr));
        }
        
        for(int i = index; i < nums.length; i++){
            arr.add(nums[i]);
            dfs(nums, level - 1, arr, i + 1);
            arr.remove(arr.size() - 1);
        }
    }
}