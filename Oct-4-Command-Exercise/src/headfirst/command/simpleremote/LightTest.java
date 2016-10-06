package headfirst.command.simpleremote;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class LightTest {
	private PrintStream stream;
	private ByteArrayOutputStream bStream;
	private Light light;
	private PrintStream old;
	
	@Before
	public void setUp() {
		old = System.out;
		bStream = new ByteArrayOutputStream();
		stream = new PrintStream(bStream);
		System.setOut(stream);
		light = new Light();
	}

	@Test
	public void testOff() {
		light.off();
		String output = new String(bStream.toByteArray());
		System.setOut(old);
		//System.out.println(output);
		assertEquals("Light is off"+System.getProperty("line.separator"), output);
	}

	@Test
	public void testOn() {
		light.on();
		String output = new String(bStream.toByteArray());
		System.setOut(old);
		//System.out.println(output);
		assertEquals("Light is on"+System.getProperty("line.separator"), output);
	}

}
