class Solution {
    private List<List<Integer>> out = null;
    public List<List<Integer>> combinationSum3(int k, int n) {
        out = new LinkedList<>();
        dfs(k, n, new LinkedList<Integer>(), 1);
        return out;
    }
    
    private void dfs(int level, int curr, List<Integer> arr, int index){
        if(level == 0 && curr == 0){
            out.add(new LinkedList<Integer>(arr));
        }
        if(level == 0 || curr <= 0){
            return;
        }
        
        for(int i = index; i < 10; i++){
            arr.add(i);
            dfs(level - 1, curr - i, arr, i + 1);
            arr.remove(arr.size() - 1);
        }
    }
}