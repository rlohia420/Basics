package basic.trees;

public class HeightBalancedTree {

	public boolean isHeightBalancedTree(Node node) {
		if(node==null) {
			return true;
		}
		int leftHeigth = height(node.left);
		int rightHeigth = height(node.right);
		if(Math.abs(rightHeigth-leftHeigth)<=1 && isHeightBalancedTree(node.left) && isHeightBalancedTree(node.right)) {
			return true;
		}
		return false;
	}
	
	public int height(Node node) {
		if(node==null)
			return 0;
		return 1+ Math.max(height(node.left), height(node.right));
	}
}
