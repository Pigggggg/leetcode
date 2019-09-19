class Solution {
    List<List<Integer>> out = null;
    Set<List<Integer>> metaSet = null;
    public List<List<Integer>> permuteUnique(int[] nums) {
        out = new LinkedList<>();
        metaSet = new HashSet<>();
        dfs(nums, new LinkedList<Integer>(), new HashSet<Integer>());
        return out;
    }
    
    private void dfs(int[] nums, List<Integer> arr, Set<Integer> set){
        if(arr.size() == nums.length && !metaSet.contains(arr)){
            metaSet.add(new LinkedList<>(arr));
            out.add(new LinkedList<>(arr));
        }
        
        for(int i = 0; i < nums.length; i++){
            if(!set.contains(i)){
                set.add(i);
                arr.add(nums[i]);
                dfs(nums, arr, set);
                set.remove(i);
                arr.remove(arr.size() - 1);
            }
        }
    }
}