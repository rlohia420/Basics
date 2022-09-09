package basic.design;

public class MyHashMap<K, V> {

	private static int DEFAULT_CAPACITY = 16;

	private Entry<K, V>[] buckets;
	private int capacity;

	MyHashMap() {
		this(DEFAULT_CAPACITY);
	}

	MyHashMap(int capacity) {
		this.capacity = capacity;
		this.buckets = new Entry[capacity];
	}

	static class Entry<K, V> {
		K key;
		V value;
		Entry<K, V> next;

		Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		Entry(K key, V value, Entry<K, V> next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}

	public void put(K key, V value) {
		if (key == null) {
			return;
		}

		Entry<K, V> newEntry = new Entry<>(key, value);
		int hash = hash(key);
		if (buckets[hash] == null) {
			buckets[hash] = newEntry;
		} else {
			Entry<K, V> current = buckets[hash];
			Entry<K, V> previous = null;
			while (current != null) {
				if (current.key.equals(key)) {
					current.value = newEntry.value;
					return;
				}
				previous = current;
				current = current.next;
			}
			previous.next = newEntry;
		}
	}

	public V get(K key) {
		if (key == null) {
			return null;
		}

		int hash = hash(key);

		if (buckets[hash] != null) {
			Entry<K, V> current = buckets[hash];
			while (current != null) {
				if (current.key.equals(key)) {
					return current.value;
				}
				current = current.next;
			}
		}else {
			return null;
		}
		return null;
	}

	private int hash(K key) {
		return Math.abs(key.hashCode()) % capacity;
	}

	public static void main(String[] args) {
		MyHashMap<String, Integer> likesPerPost = new MyHashMap<String, Integer>();
		likesPerPost.put("Learning Hash Map", 5);
		System.out.println(likesPerPost.get("Learning Hash Map"));
	}
}