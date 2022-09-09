package basic.design;

import java.util.HashMap;

public class LRUCache {
	Node head=null, tail =null;
    HashMap<Integer, Node> map=new HashMap<>();
    int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = tail = null;
    }
    public int get(int key) {
    	if(map.containsKey(key)) {
    		Node n = map.get(key);
    		delete(n);
    		setHead(n);
    		return n.value;
    	}
    	return -1;
    }
    
    public void put(int key, int value ) {
    	if(map.containsKey(key)) {
    		 Node old = map.get(key);
             old.value = value;
             map.put(key, old);
             delete(old);
     		 setHead(old);
             return;
    	}
    	Node newAdd = new Node(key, value);
        if(map.size() >= capacity){
        	map.remove(tail.key);
        	delete(tail);
        }
        setHead(newAdd);
        map.put(key, newAdd);
    }
    
    public void delete(Node node) {
    	if(node.prev !=null) {
    		node.prev.next = node.next;
    	}else {
    		head = node.next;
    	}
    	if(node.next!=null) {
    		node.next.prev = node.prev;
    	}else {
    		tail = node.prev;
    	}
    }
    
    public void setHead(Node node) {
    	if(head!=null) {
    		head.prev = node;
    	}
    	head = node;
    	if(tail==null) {
    		tail = head;
    	}
    }
    
    public static void main(String[] args)
    {
    	LRUCache ca = new LRUCache(4);
        ca.put(1, 11);
        ca.put(2, 12);
        ca.put(3, 13);
        ca.put(4, 14);
        ca.put(5, 15);
        ca.put(6, 16);
        System.out.println("top value = "+ca.head.value);
        System.out.println("***********");
        System.out.println("fetch 5th = " +ca.get(5));
        System.out.println("***********");
        
        System.out.println("fetch 3rd = " +ca.get(3));
        System.out.println("top value = "+ca.head.value);
        
    }
}
class Node {
    int key;
    int value;
    Node next;
    Node prev;
    
    Node(int key, int value){
        this.key = key;
        this.value = value;
        this.next = this.prev = null;
    }
}