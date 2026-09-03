import java.util.Arrays;

class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] result = new String[n];
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = score[i];
            pairs[i][1] = i;
        }
        Arrays.sort(pairs, (a, b) -> Integer.compare(b[0], a[0]));
        for (int rank = 0; rank < n; rank++) {
            int originalIndex = pairs[rank][1];
            
            if (rank == 0) {
                result[originalIndex] = "Gold Medal";
            } else if (rank == 1) {
                result[originalIndex] = "Silver Medal";
            } else if (rank == 2) {
                result[originalIndex] = "Bronze Medal";
            } else {
                result[originalIndex] = String.valueOf(rank + 1);
            }
        }
        
        return result;
    }
}