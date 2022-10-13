/* Question 3 Binary Tree Right Side View */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
	public List<Integer> rightSideView(TreeNode root) {
		
		
		List<Integer> result = new ArrayList();
		
		if (root == null) {
			return result;
		}
		//Declaring queue to add the nodes
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		
		TreeNode prevNode = null;
		
		while (queue.size() != 0) {
			TreeNode node = queue.remove();
			
			if (node != null) {
				prevNode = node;
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			} else {
				// We have reached to a new level
				result.add(prevNode.val);
				//System.out.println(prevNode.data);
				if (queue.size() == 0) {
					break;
				}
				queue.add(null);
			}
		}
		return result;
	}
}
