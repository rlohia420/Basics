package basic.trees;

/*
 * 
1. If root is NULL
      then return
2. if key is found then
    a. If its left subtree is not null
        Then predecessor will be the right most 
        child of left subtree or left child itself.
    b. If its right subtree is not null
        The successor will be the left most child 
        of right subtree or right child itself.
    return
3. If key is smaller than root node
        set the successor as root
        search recursively into left subtree
    else
        set the predecessor as root
        search recursively into right subtree
 */
public class InOrderPredecessorAndSuccessorOfNode {

	static Node pre = new Node(0, null, null), suc = new Node(0, null, null);

	public void findPreSuc(Node root, int key) {
		if (root.data == key) {

			// The maximum value in left
			// subtree is predecessor
			if (root.left != null) {
				Node tmp = root.left;
				while (tmp.right != null)
					tmp = tmp.right;

				pre = tmp;
			}

			// The minimum value in
			// right subtree is successor
			if (root.right != null) {
				Node tmp = root.right;

				while (tmp.left != null)
					tmp = tmp.left;

				suc = tmp;
			}
			return;
		}

		// If key is smaller than
		// root's key, go to left subtree
		if (root.data > key) {
			suc = root;
			findPreSuc(root.left, key);
		}

		// Go to right subtree
		else {
			pre = root;
			findPreSuc(root.right, key);
		}
	}

	static Node insert(Node node, int key) {
		if (node == null)
			return new Node(key);
		if (key < node.data)
			node.left = insert(node.left, key);
		else
			node.right = insert(node.right, key);

		return node;
	}
	
}
