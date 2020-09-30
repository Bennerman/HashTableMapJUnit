import java.util.NoSuchElementException;
import java.util.LinkedList;

public class HashTableMap<Key, Value > implements HashMapADT<Key, Value>{

	private int size;
	private int tableSize;
	private LinkedList<Node<Key, Value>>[] hashTable;


	public HashTableMap() {
		tableSize = 10;
		size = 0;
		hashTable = new LinkedList[tableSize];

	}
	/**
	 * create a node and insert it into your hashtable. 
	 * if there's already a node with the key inside the hashtable, return false
	 * if inserted successfully, return true;
	 */
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

		if (size/tableSize >= 0.8) {
			resize();
		}
		return true;
	}

	@Override
	public Value get(Key key) throws NoSuchElementException {
		f (containsKey(key)) {
			int hashedKey = key.hashCode();
			int index = hashedKey%tableSize;
			for (int i = 0; i < hashTable[index].size(); i++) {
				if (hashTable[index].get(i).getKey().equals(key))
					return hashTable[index].get(i).getValue(key);
			}
		}
		throw new NoSuchElementException("Key isn't in hashtable");
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean containsKey(Key key) {
		int index = hashKey(key) % tableSize;
		for (int i = 0; i < hashTable[index].size(); i++) {
			if (hashTable[index].get(i).getKey().equals(key))
				return true;
		}
		return false;
	}


	/**
	 * if the key is in the hashtable, remove it and return the associated value
	 * if not, return null
	 */
	@Override
	public Value remove(Key key) {
		// TODO Auto-generated method stub
		Value desVal = null;
		if (containsKey(key)) {
			int index = hashKey(key)%tableSize;
			for (int i = 0; i < size; i++) {
				if (hashTable[i].get(i).getKey().equals(key)) {
					desVal = hashTable[i].get(i).getValue(key);
					hashTable[i].remove(i);
				}
			}

		}
		return desVal;	
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		for(int i = 0; i < tableSize; i++) {
			if(hashTable[i] != null) {
				hashTable[i].clear();
			}
		}
	}

	public void resize() {
		LinkedList<Node<Key, Value>>[] oldHashTable = hashTable;
		tableSize*=2;
		hashTable = new LinkedList[tableSize];
		for (int i = 0; i < tableSize; i++) {
			hashTable[i] = new LinkedList<Node<Key, Value>>();
		}
		for (int i = 0; i < tableSize/2; i++) {
			for(int j = 0; j < oldHashTable[i].size(); j++) {
				int hashed = hashKey(oldHashTable[i].get(j).getKey());
				int newIndex = hashed % tableSize;
				hashTable[newIndex].add(oldHashTable[i].get(j));	
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
