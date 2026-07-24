import java.util.HashMap;
import java.util.Map;

class Solution {
    public int romanToInt(String s) {
        // Map each Roman symbol to its integer value
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int total = 0;
        int length = s.length();

        for (int i = 0; i < length; i++) {
            int currentVal = map.get(s.charAt(i));

            // Check if a smaller value comes before a larger value
            if (i < length - 1 && currentVal < map.get(s.charAt(i + 1))) {
                total -= currentVal; // Subtraction rule (e.g., IV = -1 + 5 = 4)
            } else {
                total += currentVal; // Standard addition
            }
        }

        return total;
    }
}