package plugins;

import static org.junit.Assert.*;

import org.junit.Test;

public class ToUpperCaseTest {

	@Test
	public void transform() {
		ToUpperCase ToUpperCase = new ToUpperCase();
		String s = "chocolat";
		assertEquals(s.toUpperCase(),ToUpperCase.transform(s));
	}
	@Test
	public void getLabel() {
		ToUpperCase ToUpperCase = new ToUpperCase();
		assertEquals(ToUpperCase.getLabel(),"to upper case");
	}
	@Test
	public void help() {
		ToUpperCase ToUpperCase = new ToUpperCase();
		assertEquals(ToUpperCase.helpMessage(),"Transform all the letters to upper case");
	}
}
