package plugins.tools;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;

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
		assertFalse(f.inheritfromPlugin(new Timer(1000, null).getClass()));

	}

	@Test
	public void getclass() {

		PluginFilter f = new PluginFilter();

		File dir = new File("plugins/");
		File chocolat = new File(dir, "Chocolat.class");
		File toUpperCase = new File(dir, "ToUpperCase.class");

		 assertNull( f.getClass(null,chocolat.getName())); 

	}
}
 