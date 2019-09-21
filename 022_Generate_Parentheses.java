class Solution {
    private List<String> out = null;
    public List<String> generateParenthesis(int n) {
        out = new LinkedList<>();
        dfs(n, n, new StringBuilder());
        return out;
    }
    
    private void dfs(int pre, int back, StringBuilder str) {
    	
    	if(pre < 0 || back < 0) {
    		return;
    	}
    	
    	if(pre == 0 && back == 0) {
    		out.add(str.toString());
    	}
    	
    	if(back >= pre) {
    		if(pre == 0) {
    			dfs(pre, back - 1, str.append(')'));
    			str.deleteCharAt(str.length() - 1);
    		}else {
    			dfs(pre - 1, back, str.append('('));
    			str.deleteCharAt(str.length() - 1);
    			dfs(pre, back - 1, str.append(')'));
    			str.deleteCharAt(str.length() - 1);
    		}
    	}
    }
}