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

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for(int i = 0; i<nums.length; i++) {
            int size = res.size();
            for(int j = 0;j<size;j++) {
                List<Integer> temp = new ArrayList<>(res.get(j));
                temp.add(nums[i]);
                res.add(temp);
            }
        }
        return res;
    }
}
