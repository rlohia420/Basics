package trees;

public class BinaryTree {
    static class Node {
        int data;
        Node left, right;

        public Node(int item){
            data = item;
            left = right = null;
        }
    }

    Node root;

    // A wrapper over leftViewUtil()
    void leftView()
    {
        LeftViewOfTree.leftViewUtil(root, 1);
    }

   /* testing for example nodes */
    public static void main(String args[])
    {
        /* creating a binary tree and entering the nodes
                 12
                / \
              10  30   -> 10,12,25
                 / \
                25  40
         */
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(12);
        tree.root.left = new Node(10);
        tree.root.right = new Node(30);
        tree.root.right.left = new Node(25);
        tree.root.right.right = new Node(40);

        tree.leftView();
    }

}
