class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums2.length == 0) {
        	return;
        }
        int last = m + n - 1;
        m = m - 1;
        n = n - 1;
        while(last >= 0 && n >= 0) {
        	if(m >= 0 && nums1[m] >= nums2[n]) {
        		nums1[last] = nums1[m];
        		m--;
        	}else {
        		nums1[last] = nums2[n];
        		n--;
        	}
        	last--;
        }
    }
}