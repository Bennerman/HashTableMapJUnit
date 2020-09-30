import java.util.NoSuchElementException;
import java.util.LinkedList;
import skdjf;

public class HashTableMap<Key, Value> implements HashMapADT<Key, Value> {

	private int size;
	private int tableSize;
	private LinkedList<Node<Key, Value>>[] hashTable;

	public HashTableMap() {
		tableSize = 10;
		size = 0;
		hashTable = new LinkedList[tableSize];

		for (int i = 0; i < tableSize; i++) {
			hashTable[i] = new LinkedList<Node<Key, Value>>();
		}

	}

	@Override
	public boolean put(Key key, Value value) {
		if (containsKey(key)) {
			return false;
		}
		int hashedKey = hashKey(key);
		int index = hashedKey % tableSize;

		Node<Key, Value> node = new Node<Key, Value>(key, value);
		hashTable[index].add(node);
		size++;

		if (size / tableSize >= 0.8) {
			resize();
		}
		return true;
	}

	@Override
	public Value get(Key key) throws NoSuchElementException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean containsKey(Key key) {
		// TODO Auto-generated method stub
		int index = hashKey(key);

		for (int i = 0; i < hashTable[index].size(); i++) {
			if (hashTable[index].get(i).getKey().equals(key)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Value remove(Key key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		for (int i = 0; i < tableSize; i++) {
			if(hashTable[i] != null) {
				hashTable[i].clear();
			}
		}
	}

	public void resize() {

		LinkedList<Node<Key, Value>>[] oldTable = hashTable;
		int oldTableSize = tableSize;
		tableSize *= 2;
		hashTable = new LinkedList[tableSize];

		for (int i = 0; i < oldTableSize; i++) {
			if (oldTable[i] != null) {
				for (int j = 0; j < oldTable[i].size(); j++) {
					Node currNode = oldTable[i].get(j);
					int index = currNode.getKey().hashCode();
					hashTable[index].add(currNode);
				}
			}
		}

	}

	/**
	 * Hash the key to an int
	 */
	public int hashKey(Key key) {

		return key.hashCode();
	}

}
