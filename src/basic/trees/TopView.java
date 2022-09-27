package basic.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TopView {
	static Map<Integer, List<Node>> map = new TreeMap<>();

    public static void verticalOrderTraversalRecursive(Node root, int weight){
        if(root == null){
            return;
        }
        putToMap(weight, root);
        verticalOrderTraversalRecursive(root.left, weight - 1);
        verticalOrderTraversalRecursive(root.right, weight + 1);
    }

    private static void putToMap(int weight, Node node) {
        List nodes = map.get(weight);
        if(nodes == null) {
            nodes = new ArrayList<>();
        }
        nodes.add(node);
        map.put(weight, nodes);
    }

     public static void main(String[] args){
    	 BinaryTree tree = new BinaryTree();
         Node root = new Node(5);
         root.left = (new Node(7));
         root.right = (new Node(10));
         root.left.left = (new Node(14));
         root.left.right= (new Node(19));

         root.right.left = (new Node(30));
         root.right.right= (new Node(15));

         root.right.right.left= (new Node(25));
         TopView.verticalOrderTraversalRecursive(root, 0);
         for (Map.Entry<Integer, List<Node>> entry: map.entrySet()){
             System.out.print(entry.getKey() + ": ");
             entry.getValue().forEach(val -> System.out.print(val.data + " "));
             System.out.println();
         }
         System.out.println("********TOP VIEW********");
         printTopView();
         System.out.println("");
         System.out.println("********BOTTOM VIEW********");
         printBottomView();
     }
     
     private static void printTopView() {
         for (Map.Entry<Integer, List<Node>> entry: map.entrySet()){
             System.out.print(entry.getValue().get(0).data + " ");
         }
     }
     private static void printBottomView() {
         for (Map.Entry<Integer, List<Node>> entry: map.entrySet()){
             System.out.print(entry.getValue().get(entry.getValue().size() - 1).data + " ");
         }
     }
     
}
