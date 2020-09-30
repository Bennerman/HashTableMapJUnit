import java.util.NoSuchElementException;
import java.util.LinkedList;
import skdjf;

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
        for(int i = size; )
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
        
    }
    
    public void resize() {
    	//TODO resize hashtable
    }
    /**
     * Hash the key to an int
     */
    public int hashKey(Key key) {
        
        return key.hashCode();
    }


    


}
