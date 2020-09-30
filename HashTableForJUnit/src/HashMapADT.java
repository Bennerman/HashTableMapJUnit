import java.util.NoSuchElementException;

public interface HashMapADT<Key, Value> {

    public boolean put(Key key, Value value);
    public Value get(Key key) throws NoSuchElementException;
    public int size();
    public boolean containsKey(Key key);
    public Value remove(Key key);
    public void clear();
    
}