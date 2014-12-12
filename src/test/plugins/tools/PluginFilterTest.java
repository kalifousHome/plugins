package plugins.tools;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.swing.Timer;

import org.junit.Test;

import plugins.ToUpperCase;

public class PluginFilterTest {

		@Test
	public void fileExtensionIsClass() {
		String isTxt = "file.txt";
		String isClass = "file.class";
		PluginFilter f = new PluginFilter();
		assertFalse(f.fileExtensionIsClass(isTxt));
		assertTrue(f.fileExtensionIsClass(isClass));
	}

	@Test
	public void inheritfromPlugin() {

		PluginFilter f = new PluginFilter();
		assertTrue(f.inheritfromPlugin(new ToUpperCase().getClass()));
		assertFalse(f.inheritfromPlugin(new Timer(1000,null).getClass()));

	}
	@Test
	public void getclass() {

		PluginFilter f = new PluginFilter();
		assertTrue(f.inheritfromPlugin(new ToUpperCase().getClass()));
		assertFalse(f.inheritfromPlugin(new Timer(0,null).getClass()));

	}
	
}
