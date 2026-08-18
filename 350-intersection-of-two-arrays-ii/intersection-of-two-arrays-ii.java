import java.util.Arrays;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] count = new int[1001];
        for (int num : nums1) {
            count[num]++;
        }

        int[] temp = new int[Math.min(nums1.length, nums2.length)];
        int index = 0;
        for (int num : nums2) {
            if (count[num] > 0) {
                temp[index++] = num;
                count[num]--;
            }
        }

        return Arrays.copyOfRange(temp, 0, index);
    }
}