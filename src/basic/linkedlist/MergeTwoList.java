package basic.linkedlist;

public class MergeTwoList {
	Node head;
	public static class Node{
		public int data;
		public Node next;
		Node(){
		}
		Node(int data){
			this.data=data;
		}
	}

	public static Node mergeTwoLists(Node list1, Node list2) {
		if (list1 == null)
			return list2;
		else if (list2 == null)
			return list1;
		else if (list1.data < list2.data) {
			list1.next = mergeTwoLists(list1.next, list2);
			return list1;
		} else {
			list2.next = mergeTwoLists(list1, list2.next);
			return list2;
		}
	}
	
	public static Node merge(Node a , Node b) {
		Node prev = new Node();
		Node temp = prev;
		while(a!=null && b!=null) {
				if(a.data<=b.data) {
					temp.next = a;
					a= a.next;
				}else {
					temp.next = b;
					b = b.next;
				}
				temp = temp.next;
		}
		temp.next = a==null? b:a;
		return prev.next;
	}

	public void printList(Node node) {
		while(node!=null) {
			System.out.println(node.data);
			node = node.next;
		}
	}
	public static void main(String args[]) {
		MergeTwoList ll = new MergeTwoList();
		ll.head = new Node(1);
		Node n1 = new Node(2);
		Node n2 = new Node(3);
		Node n3 = new Node(4);
		ll.head.next = n1;
		n1.next = n2;
		n2.next = n3;
		//ll.printList(ll.head);
		
		
		MergeTwoList ll1 = new MergeTwoList();
		ll1.head = new Node(11);
		Node n11 = new Node(12);
		Node n12 = new Node(13);
		Node n13 = new Node(14);
		Node n14 = new Node(7);
		ll1.head.next = n11;
		n11.next = n12;
		n12.next = n13;
		n13.next = n14;
		//ll1.printList(ll1.head);
		Node newNode = merge(ll.head,ll1.head);
		ll1.printList(newNode);
	}
}
