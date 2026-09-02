/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.ArrayList;
import java.util.List;

class Solution {
    private int currentVal;
    private int currentCount = 0;
    private int maxCount = 0;
    private List<Integer> modes = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        inOrder(root);
        
        // Convert the List to an int array
        int[] result = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            result[i] = modes.get(i);
        }
        return result;
    }

    private void inOrder(TreeNode node) {
        if (node == null) return;

        inOrder(node.left);
        if (currentCount == 0 || node.val != currentVal) {
            currentVal = node.val;
            currentCount = 1;
        } else {
            currentCount++;
        }
        if (currentCount > maxCount) {
            maxCount = currentCount;
            modes.clear();
            modes.add(currentVal);
        } else if (currentCount == maxCount) {
            modes.add(currentVal);
        }

        inOrder(node.right);
    }
}