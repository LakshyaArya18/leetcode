import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> first = new HashMap<>();
        Map<Integer, Integer> last = new HashMap<>();
        
        int degree = 0;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            first.putIfAbsent(x, i);
            last.put(x, i);
            count.put(x, count.getOrDefault(x, 0) + 1);
            degree = Math.max(degree, count.get(x));
        }
        
        int minLength = nums.length;
        for (int x : count.keySet()) {
            if (count.get(x) == degree) {
                int length = last.get(x) - first.get(x) + 1;
                minLength = Math.min(minLength, length);
            }
        }
        
        return minLength;
    }
}