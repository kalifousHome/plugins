package plugins.tools;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import plugins.Plugin;
import plugins.ToUpperCase;

public class PluginFilterTest {

	private static final Class<?> ToUpperCase = null;
	private static final Class<?> ConfigurableTimer = null;

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
		assertFalse(f.inheritfromPlugin(ToUpperCase.getClass()));
		assertFalse(f.inheritfromPlugin(ConfigurableTimer.getClass()));

	}
	/*
	 * public void testing(File dir, String name) {
	 * 
	 * if (this.accept(dir, name)) {
	 * 
	 * try {
	 * 
	 * Class<?> classTest = Class.forName("plugins.FunnyPlugin");
	 * 
	 * Plugin test = (Plugin) classTest.newInstance();
	 * 
	 * System.out.print(test.getLabel());
	 * 
	 * System.out.print(test.helpMessage());
	 * 
	 * } catch (Exception e) {
	 * 
	 * e.printStackTrace();
	 * 
	 * }
	 * 
	 * } else System.out.print("DOESNT ACCEPT THE PLUGIN\n");
	 * 
	 * }
	 */
}
