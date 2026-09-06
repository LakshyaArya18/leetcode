class Solution {
    public boolean checkRecord(String s) {
        int absences = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'A') {
                absences++;
                if (absences >= 2) {
                    return false;
                }
            }
            if (c == 'L' && i >= 2 && s.charAt(i - 1) == 'L' && s.charAt(i - 2) == 'L') {
                return false;
            }
        }

        return true;
    }
}