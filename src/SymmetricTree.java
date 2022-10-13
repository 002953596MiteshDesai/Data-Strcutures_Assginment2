/* Question 1: Symmetric Tree */

public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		return areSymmetricTrees(root, root);
	}
	
	public boolean areSymmetricTrees(TreeNode node1, TreeNode node2) {
		/*Comparing nodes of both the tress */
		if (node1 == null && node2 == null) {
			return true;
		}
		if (node1 == null || node2 == null) {
			return false;
		}
		//Returning boolean value based on the comparison */
		return (node1.val == node2.val) &&
				areSymmetricTrees(node1.right, node2.left)
				&& areSymmetricTrees(node1.left, node2.right);
	}
}
