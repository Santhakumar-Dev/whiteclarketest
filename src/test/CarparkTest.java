/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import main.Carpark;
import main.Position;


public class CarparkTest extends TestCase {

	private Carpark carpark = new Carpark();
	private Position position;
	private String command;
	private int x;
	private int y;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		x = 5;
		y = 5;
		command = "RFLFRFLF";
	}


	@Test
	public void testFindPosition() {
		
		position = carpark.findPosition(x, y, command);
		assertEquals(7, position.getX());
		assertEquals(7, position.getY());
	}

}
