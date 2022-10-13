/* Question 2 : Maximum Depth of Binary Tree */

public class MaxDepth {
	public int maxDepth(TreeNode root) {
		return height(root);
	}
	
	public int height(TreeNode node) {
		// if node is null , return 0
		if (node == null) {
			return 0;
		}
		// return max height amongst left  right node
		return 1 + Math.max(height(node.left), height(node.right));
	}
}
