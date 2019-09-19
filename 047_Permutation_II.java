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

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        Set<Integer> visited = new HashSet<>();
        dfs(res, new ArrayList<>(), visited, nums, 0);
        return res;
    }
    private void dfs(List<List<Integer>> res, List<Integer> curr, Set<Integer> visited, int[] nums, int idx) {
        if(idx == nums.length) {
            res.add(new ArrayList<>(curr));
        }
        for(int i = 0;i<nums.length;i++) {
            if(i>0 && visited.contains(i-1) && nums[i-1] == nums[i]) continue;
            if(!visited.contains(i)) {
                curr.add(nums[i]);
                visited.add(i);
                dfs(res, curr, visited, nums,idx + 1);
                curr.remove(curr.size() - 1);
                visited.remove(i);
            }
        }
    }
}
