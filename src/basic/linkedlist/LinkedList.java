package basic.linkedlist;

public class LinkedList {
	Node head;
	public static class Node{
		public int data;
		public Node next;
		Node(int data){
			this.data=data;
		}
	}
	public void printList(Node node) {
		while(node!=null) {
			System.out.println(node.data);
			node = node.next;
		}
	}
	public void push(int data) {
		Node newNode = new Node(7);
		newNode.next = head;
		head = newNode;
	}
	public void deleteAfter(Node node) {
		Node temp = head;
		while(temp!=null && temp.data!=node.data) {
			temp = temp.next;
		}
		if(temp.next!=null) {
			temp.next = temp.next.next;
		}
	}
	public Node printMiddle(Node node) {
		Node fastPtr = node;
		Node slowPtr = node;
		while(fastPtr!=null && fastPtr.next!=null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}
		System.out.println(slowPtr.data);
		return slowPtr;
	}
	public void findNthElementFromEnd(int n) {
		Node fastPtr = head;
		Node slowPtr = head;
		for(int i=0;i<n;i++ ) {
			fastPtr = fastPtr.next;
		}
		while(fastPtr!=null ) {
			fastPtr = fastPtr.next;
			slowPtr = slowPtr.next;
		}
		System.out.println(slowPtr.data);
	}
	public void addingNodeAtLast(Node node) {
		if(head==null) {
			head = node;
		}else {
			Node temp = head;
			while(temp.next!=null) {
				temp = temp.next;
			}
			temp.next=node;
		}
	}
	public void detectALoop() {
		Node fastPtr = head;
		Node slowPtr = head;
		while(fastPtr!=null && fastPtr.next!=null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
			if(fastPtr==slowPtr) {
				System.out.println(true);
			}
		}
		System.out.println(false);
	}
	public Node reverseList(Node node) {
		Node current = node;
		Node previous = null;
		Node next = null;
		while(current!=null) {
			next = current.next;
			current.next = previous;
			previous = current ;
			current = next;
		}
		return previous;
	}
	public boolean isPallindrom(Node node) {
		Node middle = printMiddle(node);
		Node secondHalf = middle.next;
		Node revereseSecond = reverseList(secondHalf);
		while(node!=null && revereseSecond!=null) {
			if(node.data!=revereseSecond.data) {
				return false;
			}else {
				node= node.next;
				revereseSecond= revereseSecond.next;
				continue;
			}
		}return true;
	}
	
	public Node findIntersection(Node a, Node b) {
		int lengthA = 0;
		int lengthB =0; int difference=0;
		for(;a!=null;a= a.next) {
			lengthA++;
		}
		for(;b!=null;b=b.next) {
			lengthB++;
		}
		if( lengthA>lengthB ) {
			difference=lengthA-lengthB;
			for(int i=0;i<difference;i++) {
				a=a.next;
			}
		}else {
			difference=lengthB-lengthA;
			for(int i=0;i<difference;i++) {
				b=b.next;
			}
		}
		while(a!=null && b!=null) {
			if(a.data==b.data) {
				return a;
			}a= a.next; b = b.next;
		}
		return null;
	}
	public Node reverseLinkedListInGroup(Node node , int groupSize) {
		Node previous = null;
		Node current = node;
		Node next = null; int count=0;
		while(current!=null && count<groupSize ) {
			next = current.next;
			current.next= previous;
			previous= current;
			current = next;
			count++;
		}
		if(next!=null) {
			node.next= reverseLinkedListInGroup(next, groupSize);
		}
		return previous;
	}
	public void kThAlternativeReverse(Node node , int groupSize) {
		Node previous = null;
		Node current = node;
		Node next = null; int count=0;
		while(current!=null && count<groupSize ) {
			next = current.next;
			current.next= previous;
			previous= current;
			current = next;
			count++;
		}
		if(node!=null) {
			node.next= current;
		}
		for(int i=0;i<groupSize && current!=null;i++) {
			current = current.next;
		}
		if(current!=null) {
			current.next= reverseLinkedListInGroup(current.next, groupSize);
		}
	}
	public Node removeDuplicate(Node node) {
		Node duplicate=null;
		for(Node ptr1=node;ptr1!=null ; ptr1=ptr1.next ) {
			for(Node ptr2=ptr1.next;ptr2!=null ;ptr2=ptr2.next) {
				if(ptr1.data==ptr2.data) {
					duplicate=ptr1;
					ptr2=ptr2.next;
				}
			}
		}return duplicate;
	}
	public int compareTwoLinkdList(Node n1,Node n2) {
		if(n1==null && n2==null) {
			return 1;
		}
		while(n1!=null && n2!=null && n1.data==n2.data) {
			n1 = n1.next;
			n2 = n2.next;
		}
		if(n1!=null && n2!=null) {
			return n1.data>n2.data?1:-1;
		}
		if(n1==null && n2!=null)
			return -1;
		return 0;
	}
	public Node removeKthNodeFromEnd(Node node ,int k) {
		int length=0;
		Node current = node;
		for(Node ptr=node;ptr!=null;ptr=ptr.next) {
			length++;
		}
		if(k>length) {
			return node;
		}
		else if(k==length) {
			return node.next;
		}
		else {
			for(int i=0;i<length-k;i++) {
				current = current.next;
			}
			current.next= current.next.next;
		}
		return node;
	}
	public Node mergeList(Node l1,Node l2) {
		Node temp = new Node(1);
		Node prev = temp;
		while(l1!=null && l2!=null) {
			if(l1.data<=l2.data) {
				prev.next=l1;
				l1=l1.next;
			}else {
				prev.next=l2;
				l2=l2.next;
			}
			prev=prev.next;
		}
		prev.next=l1==null?l2:l1;
		return temp.next;
	}
	public Node addTwoList(Node n1,Node n2) {
		Node dummy = new Node(1);
		Node p1=n1, p2=n2;int carry=0;
		Node current = dummy;
		while(p1!=null ||p2!=null) {
			int x = (p1 !=null)?p1.data:0;
			int y = (p2 !=null)?p2.data:0;
			int sum= carry+x+y;
			carry = sum/10;
			current.next = new Node(sum%10);
			current = current.next;
			if(p1!=null)p1=p1.next;
			if(p2!=null)p2=p2.next;
		}
		if(carry>0)
			current.next= new Node(carry);
		return dummy.next;
	}
	public static void main(String args[]) {
		LinkedList ll = new LinkedList();
		ll.head = new Node(1);
		Node n1 = new Node(2);
		Node n2 = new Node(3);
		Node n3 = new Node(4);
		ll.head.next = n1;
		n1.next = n2;
		n2.next = n3;
		ll.printList(ll.head);
		Node revere = ll.reverseList(ll.head);
		ll.printList(revere);
	}
	
}
