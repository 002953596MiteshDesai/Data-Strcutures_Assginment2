/* Question : 7 Lowest Common Ancestor of a Binary Tree */

public class LowestCommonAncestor {
	private TreeNode ans;
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		this.recurseTree(root, p, q);
		return this.ans;
	}
	
	private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {
		
		//  Return false if end of the tree is reached
		if (currentNode == null) {
			return false;
		}
		
		//  If left recursion returns true, set left = 1 else 0
		int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;
		// If right recursion returns true, set left = 1 else 0
		int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;
		
		// If the current node is one of p or q
		int mid = (currentNode == p || currentNode == q) ? 1 : 0;
		
		
		// If any two of the flags left, right or mid become True
		if (mid + left + right >= 2) {
			this.ans = currentNode;
		}
		
		// Return true if any one of the three bool values is True.
		return (mid + left + right > 0);
	}
}
