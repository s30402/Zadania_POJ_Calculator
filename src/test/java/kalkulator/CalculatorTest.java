package kalkulator;

import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class CalculatorTest {

	// Adding

	@Test
	public void testAddOne(){
		Calculator sut = new Calculator();
		sut.add(1);
		assertEquals("0+1 = 1", 1, sut.getState());
	}

	@Test
	public void testAddZero() {
		Calculator sut = new Calculator();
		sut.add(0);
		assertEquals("0 + 0 = 0", 0, sut.getState());
	}

	@Test
	public void testAddOverflow() {
		Calculator sut = new Calculator();
		sut.setState(Integer.MIN_VALUE);
		assertThrows(ArithmeticException.class, () -> sut.add(-52));
	}

	@Test
	public void testAddMemory() {
		Calculator sut = new Calculator();
		sut.setState(5);
		sut.add(1);
		assertEquals("5+1 = 6", 6, sut.getState());

		sut.saveToMemory();
		sut.setState(0);
		sut.add(30);
		assertEquals("0+30 = 30", 30, sut.getState());

		sut.loadFromMemory();
		sut.add(6);
		assertEquals("6+6 = 12", 12, sut.getState());
	}

	// Substraction

	@Test
	public void testSubOne(){
		Calculator sut = new Calculator();
		sut.subtract(1);
		assertEquals("0-1 = -1", -1, sut.getState());
	}

	@Test
	public void testSubZero() {
		Calculator sut = new Calculator();
		sut.subtract(0);
		assertEquals("0 + 0 = 0", 0, sut.getState());
	}

	@Test
	public void testSubOverflow() {
		Calculator sut = new Calculator();
		sut.setState(Integer.MIN_VALUE);
		assertThrows(ArithmeticException.class, () -> sut.subtract(52));
	}

	@Test
	public void testSubMemory() {
		Calculator sut = new Calculator();
		sut.setState(50);
		sut.subtract(15);
		assertEquals("50-15 = 35", 35, sut.getState());

		sut.saveToMemory();
		sut.setState(501);
		sut.subtract(21);
		assertEquals("501-21 = 480", 480, sut.getState());

		sut.loadFromMemory();
		sut.subtract(5);
		assertEquals("35-5 = 30", 30, sut.getState());
	}

	// Multiplying

	@Test
	public void testMultOneByTwo(){
		Calculator sut = new Calculator();
		sut.setState(1);
		sut.mult(2);
		assertEquals("1*2 = 2", 2, sut.getState());
	}

	@Test
	public void testMultZero() {
		Calculator sut = new Calculator();
		sut.setState(5);
		sut.mult(0);
		assertEquals("5 * 0 = 0", 0, sut.getState());
	}

	@Test
	public void testMultOverflow() {
		Calculator sut = new Calculator();
		sut.setState(Integer.MAX_VALUE);
		assertThrows(ArithmeticException.class, () -> sut.mult(5));
	}

	@Test
	public void testMultMemory() {
		Calculator sut = new Calculator();
		sut.setState(50);
		sut.mult(10);
		assertEquals("50*10 = 500", 500, sut.getState());

		sut.saveToMemory();
		sut.setState(1000);
		sut.mult(-2);
		assertEquals("1000*(-2) = -2000", -2000, sut.getState());

		sut.loadFromMemory();
		sut.mult(5);
		assertEquals("500*5 = 2500", 2500, sut.getState());
	}

	// Power

	@Test
	public void testPowerOneByFive(){
		Calculator sut = new Calculator();
		sut.setState(1);
		sut.power(5);
		assertEquals("1^5 = 1", 1, sut.getState());
	}

	@Test
	public void testPowerZero() {
		Calculator sut = new Calculator();
		sut.setState(500000000);
		sut.power(0);
		assertEquals("5^0 = 1", 1, sut.getState());
	}

	@Test
	public void testPowerOverflow() {
		Calculator sut = new Calculator();
		sut.setState(Integer.MAX_VALUE);
		assertThrows(ArithmeticException.class, () -> sut.power(-6));
	}

	@Test
	public void testPowerMemory() {
		Calculator sut = new Calculator();
		sut.setState(2);
		sut.power(3);
		assertEquals("2^3 = 8", 8, sut.getState());

		sut.saveToMemory();
		sut.setState(4);
		sut.power(4);
		assertEquals("4^4 = 256", 256, sut.getState());

		sut.loadFromMemory();
		sut.power(8);
		assertEquals("8^8 = 16777216", 16777216, sut.getState());
	}

	// Memory

	@Test
	public void testMemorySaveAndLoad(){
		Calculator sut = new Calculator();
		sut.setState(5);
		sut.saveToMemory();
		sut.setState(0);
		sut.loadFromMemory();
		assertEquals("5", 5, sut.getState());
	}

	@Test
	public void testClearMemory(){
		Calculator sut = new Calculator();
		sut.setState(5);
		sut.saveToMemory();
		sut.setState(0);
		sut.loadFromMemory();
		assertEquals("5", 5, sut.getState());

		sut.clearMemory();
		assertThrows(IllegalStateException.class, () -> sut.loadFromMemory());
	}
}
