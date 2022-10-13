/* Question4 : Binary Tree Zigzag Level Order Traversal */

import java.util.*;

public class ZigzagTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		
		List<List<Integer>> result = new ArrayList();
		
		if (root == null) {
			return result;
		}
		//Defining queue to add nodes
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		boolean bPrint = true;
		Stack<TreeNode> stack = new Stack<>();
		
		while (queue.size() != 0) {
			TreeNode node = queue.remove();
			
			
			if (node != null) {
				if (bPrint) {
					int index = result.size();
					if (index == 0){
						result.add(new ArrayList());
						result.get(index).add(node.val);
					} else {
						result.get(index-1).add(node.val);
					}
					
				} else {
					stack.push(node);
				}
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			} else {
				// We have reached to a new level
				while (!stack.empty()) {
					int index = result.size();
					result.get(index-1).add(stack.pop().val);
					
				}
				
				if (queue.size() == 0) {
					break;
				}
				result.add(new ArrayList());
				queue.add(null);
				bPrint = !bPrint;
			}
		}
		return result;
	}
}
