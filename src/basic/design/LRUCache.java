package basic.design;

import java.util.HashMap;


public class LRUCache {
	Node head, tail;
    HashMap<Integer, Node> map;
    int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = tail = null;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node curr = map.get(key);
            makeLast(curr);
            return curr.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node curr = map.get(key);
            curr.value = value;
            map.put(key, curr);
            makeLast(curr);
            return;
        }
        Node newAdd = new Node(key, value);
        if(map.size() >= capacity){
            removeHead();
        }
        makeLast(newAdd);
        map.put(key, newAdd);
    }
    private void makeLast(Node node){
        if(head == tail && head == null){ // first node
            head = tail = node;
            return;
        }
        if(node == tail)
            return;
        if(node == head){
            head = node.next;
            head.prev = null;
        }
        else{
            if(node.prev != null)
                node.prev.next = node.next;
            if(node.next != null)
                node.next.prev = node.prev;
        }
        
        node.prev = tail;
        tail.next = node;
        tail = node;
    }
    
    private void removeHead(){
        map.remove(head.key);
        if(head == tail){
            head = tail = null;
            return;
        }
        head = head.next;
        head.prev = null;
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
        System.out.println("top value = "+ca.tail.value);
        System.out.println("***********");
        System.out.println("fetch 5th = " +ca.get(5));
        System.out.println("***********");
        
        System.out.println("fetch 3rd = " +ca.get(3));
        System.out.println("top value = "+ca.tail.value);
        
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
