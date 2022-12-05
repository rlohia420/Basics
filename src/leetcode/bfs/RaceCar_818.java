package leetcode.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class Pair<K, V> {

	private K key;
	private V value;

	public Pair(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}
}

public class RaceCar_818 {
	public int racecar(int target) {
		Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
		HashSet<Pair<Integer, Integer>> visited = new HashSet<>();

		// pos, speed
		queue.add(new Pair(0, 1));
		visited.add(queue.peek());
		int instructions = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				Pair<Integer, Integer> node = queue.poll();
				int position = node.getKey();
				int speed = node.getValue();

				// once we hit target, return instructions count
				if (position == target)
					return instructions;

				// we have 2 possibilities
				// accelerate
				offer(queue, target, visited, speed * 2, position + speed);

				// reverse
				offer(queue, target, visited, speed > 0 ? -1 : 1, position);
			}

			// increase instruction
			instructions++;
		}

		return -1;
	}

	public void offer(Queue<Pair<Integer, Integer>> queue, int target, HashSet<Pair<Integer, Integer>> set, int speed,
			int position) {

		Pair<Integer, Integer> node = new Pair<>(position, speed);

		// we aren't supposed to go reverse from position 0, if we do, it will
		// only increase instructions, so we make sure we are >= 0 position

		// we might go beyond target, but we can reverse and come back to target
		if (position >= 0 && position <= 2 * target && !set.contains(node)) {
			set.add(node);
			queue.add(node);
		}
	}
}
