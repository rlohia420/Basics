package basic.linkedlist;

public class DoubleLinkedList {

	class Node{
		int data;
		Node  next , prev;
		Node(int data){
			this.data = data;
		}
	}
	private Node head , tail; int size;
	public boolean isEmpty() {
		return (head==null);
	}
	public void insertFirst(int data) {
		Node node = new  Node(data);
		node.next= head;
		node.prev= null;
		if(head!=null) {
			head.prev=node;
		}
		head=node;
		if(tail==null)
			tail=node;
		size++;
	}
	public void insertNodeAtLast(int data) {
		Node node = new Node(data);
		node.next=null;
		node.prev=tail;
		if(tail!=null) {
			tail.next=node;
		}
		tail=node;
		if(head==null) {
			head = node;
		}
		size++;
	}
	public Node deleteNodeFromStart() {
		if(size==0) {
			System.out.println("empty");
		}
		Node node = head;
		head  = head.next;
		head.prev=null;
		size--;
		return node;
	}
	public Node deleteNodeFromEnd() {
		if(size==0) {
			System.out.println("empty");
		}
		Node node = tail;
		tail = tail.prev;
		tail.next=null;
		size--;
		return node;
	}
	public void deleteANodeAfterAParticularNode(Node node) {
		Node temp = head;
		while(temp.next!=null && temp.data != node.data) {
			temp = temp.next;
		}
		if(temp.next!=null) {
			temp.next.next.prev = temp;
			temp.next = temp.next.next;
		}
	}
}




















