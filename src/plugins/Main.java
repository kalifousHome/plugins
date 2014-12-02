package plugins;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		
		
		/**	try {
			
				Class<?> classTest = Class.forName("plugins.test");

				Plugin test = (Plugin) classTest.newInstance();

				test.getLabel();
			
			} catch (Exception e) {

				e.printStackTrace();

			}*/
		
		
		
			File directory = new File("/home/git/plugins/src/plugins/");
			PluginFinder finder = new PluginFinder(directory);	
			ConfigurableTimer c = new ConfigurableTimer(finder);
		
			while(true){
				c.start(5);
			}
			

	}

}