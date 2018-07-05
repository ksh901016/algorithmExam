package datastructure;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DataStructureTest {

	@Test
	public void testQueue() {
		Queue<Integer> queue = new QueueImpl<Integer>();
		
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		queue.add(5);
		
		assertEquals(queue.remove(), new Integer(1));
		assertEquals(queue.remove(), new Integer(2));
		assertEquals(queue.remove(), new Integer(3));
		assertEquals(queue.peek()  , new Integer(4));
		assertTrue(!queue.isEmpty());
		assertEquals(queue.remove(), new Integer(4));
		assertEquals(queue.remove(), new Integer(5));
		assertTrue(queue.isEmpty());
		
	}

}
