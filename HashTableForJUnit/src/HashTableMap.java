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
    @Override
    public boolean put(Key key, Value value) {
        // TODO Auto-generated method stub
        
        
        
        return false;
    }

    @Override
    public Value get(Key key) throws NoSuchElementException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean containsKey(Key key) {
        // TODO Auto-generated method stub
        for(int i = size; )
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
