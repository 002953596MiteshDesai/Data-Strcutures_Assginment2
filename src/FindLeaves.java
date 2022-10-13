/*Question 8 :Find Leaves of Binary Tree*/

import javafx.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FindLeaves {
	private List<Pair<Integer, Integer>> pairs;
	
	
	private int getHeight(TreeNode root) {
		
		// checking for the null nodes
		if (root == null) return -1;
		
		// calculating  the height of the left and right children
		int leftHeight = getHeight(root.left);
		int rightHeight = getHeight(root.right);
		
		// obtaining  the height of the current (parent) node from Children's height
		int currHeight = Math.max(leftHeight, rightHeight) + 1;
		// collect the pair -> (height, val)
		this.pairs.add(new Pair<Integer, Integer>(currHeight, (Integer) root.val));
		
		// returning  the height of the current node
		return currHeight;
	}
	
	
	
	public List<List<Integer>> findLeaves(TreeNode root) {
		this.pairs = new ArrayList<>();
		
		getHeight(root);
		// (height, val) pairs sorting
		Collections.sort(this.pairs, Comparator.comparing(p -> p.getKey()));
		
		int n = this.pairs.size(), height = 0, i = 0;
		
		List<List<Integer>> solution = new ArrayList<>();
		
		while (i < n) {
			List<Integer> nums = new ArrayList<>();
			while (i < n && this.pairs.get(i).getKey() == height) {
				nums.add(this.pairs.get(i).getValue());
				i++;
			}
			solution.add(nums);
			height++;
		}
		return solution;
	}
}
