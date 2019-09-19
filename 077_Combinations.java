class Solution {
    List<List<Integer>> out = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(n, k, new LinkedList<Integer>(), 1);
        return out;
    }
    
    private void dfs(int n, int level, List<Integer> arr, int index){
        if(level == 0){
            out.add(new LinkedList<Integer>(arr));
        }
        
        for(int i = index; i <= n; i++){
            arr.add(i);
            dfs(n, level - 1, arr, i + 1);
            arr.remove(arr.size() - 1);
        }
    }
}