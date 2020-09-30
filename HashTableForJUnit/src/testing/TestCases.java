package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestCases<Key, Value> {

	@Test
	void test() {
		HashTableMapTesting<Key,Value> test = new HashTableMapTesting<Key,Value>();
		Node<Key, Value> node = new Node("Ben", "Radosevich");
		
		test.put(node.getKey(), node.getValue());
		
		Value value = test.get(node.getKey());
		assertEquals("Radosevich", value);
				
	}

}
