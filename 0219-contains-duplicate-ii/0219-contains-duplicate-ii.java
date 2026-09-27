import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            // If the set already contains the number, a duplicate within k distance exists
            if (set.contains(nums[i])) {
                return true;
            }
            
            // Add the current number to the set
            set.add(nums[i]);
            
            // Maintain the sliding window size of at most k elements
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        
        return false;
    }
}