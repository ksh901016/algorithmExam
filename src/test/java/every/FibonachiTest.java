package every;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FibonachiTest {


	@Test
	public void test() {
		System.out.println(Fibonachi.fibonachi1(0));
		System.out.println(Fibonachi.fibonachi1(1));
		System.out.println(Fibonachi.fibonachi1(2));
		System.out.println(Fibonachi.fibonachi1(3));
		System.out.println(Fibonachi.fibonachi1(4));
		System.out.println(Fibonachi.fibonachi1(5));
		System.out.println(Fibonachi.fibonachi1(6));
		System.out.println(Fibonachi.fibonachi1(7));
		System.out.println(Fibonachi.fibonachi1(8));
		System.out.println(Fibonachi.fibonachi1(9));
		System.out.println(Fibonachi.fibonachi1(10));
	}
	
	@Test
	public void fibonachi2Test(){
		assertEquals(Fibonachi.fibonachi2(1), 0);
		assertEquals(Fibonachi.fibonachi2(2), 1);
		assertEquals(Fibonachi.fibonachi2(3), 1);
		assertEquals(Fibonachi.fibonachi2(4), 2);
		assertEquals(Fibonachi.fibonachi2(5), 3);
		assertEquals(Fibonachi.fibonachi2(6), 5);
		assertEquals(Fibonachi.fibonachi2(7), 8);
		assertEquals(Fibonachi.fibonachi2(8), 13);
	}
	
	@Test
	public void fibonachi3Test(){
		assertEquals(Fibonachi.fibonachi3(1), 0);
		assertEquals(Fibonachi.fibonachi3(2), 1);
		assertEquals(Fibonachi.fibonachi3(3), 1);
		assertEquals(Fibonachi.fibonachi3(4), 2);
		assertEquals(Fibonachi.fibonachi3(5), 3);
		assertEquals(Fibonachi.fibonachi3(6), 5);
		assertEquals(Fibonachi.fibonachi3(7), 8);
		assertEquals(Fibonachi.fibonachi3(8), 13);
	}

}
