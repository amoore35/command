package headfirst.command.simpleremote;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class LightOnCommandTest {
	private PrintStream stream;
	private ByteArrayOutputStream bStream;
	private PrintStream old;
	private LightOnCommand command;
	private Light light;

	@Before
	public void setUp() {
		old = System.out;
		bStream = new ByteArrayOutputStream();
		stream = new PrintStream(bStream);
		System.setOut(stream);
		light = new Light();
		command = new LightOnCommand(light);
	}
	
	@Test
	public void testExecute() {
		command.execute();
		String output = new String(bStream.toByteArray());
		System.setOut(old);
		//System.out.println(output);
		assertEquals("Light is on"+System.getProperty("line.separator"), output);
	}

}
