package plugins.tools;

import static org.junit.Assert.*;

import org.junit.Test;

import plugins.listeners.PluginListener;
import plugins.listeners.GraphicalMenu;

public class PluginFinderTest {

	@Test
	public void addListener() {
		PluginListener listener = new GraphicalMenu(null, null);
		PluginFinder finder = new PluginFinder(null);
		assertFalse(finder.getListeners().contains(listener));
		finder.addListener(listener);
		assertTrue(finder.getListeners().contains(listener));

	}

	@Test
	public void removeListener() {
		PluginListener listener = new GraphicalMenu(null, null);
		PluginFinder finder = new PluginFinder(null);
		finder.addListener(listener);
		assertTrue(finder.getListeners().contains(listener));
		finder.removeListener(listener);
		assertFalse(finder.getListeners().contains(listener));

	}


}
