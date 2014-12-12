package plugins.tools;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class PluginEventTest {

	@Test
	public void getFileName() {
		String name = "AZERTYUIOPSDFGHJKLCVBNJ?K.FGHJK";
		File file = new File("/home",name);
		PluginEvent E = new PluginEvent(file);
		assertEquals(E.getFileName(),name);
				
	}

}
