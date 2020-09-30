
public class Node<Key, Value> {
	Key key;
	Value value;
	public Node(Key key, Value value) {
		this.key = key;
		this.value = value;
	}
	
	public Key getKey() {
		return this.key;
	}
	
	public Value getValue(Key key) {
		return this.value;
	}
}
