package plugins.tools;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import plugins.Plugin;
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
		assertFalse(f.inheritfromPlugin(new ConfigurableTimer(null).getClass()));

	}
	@Test
	public void getclass() {

		PluginFilter f = new PluginFilter();
		File dir = new File("plugins/");
		File chocolat = new File(dir,"Chocolat.class");
		File toUpperCase = new File(dir,"ToUpperCase.class");
		
		assertNull( f.getClass(null,chocolat.getName()));	

		assertEquals( f.getClass(null,chocolat.getName()),new ToUpperCase().getClass());
		
	}
	
}
