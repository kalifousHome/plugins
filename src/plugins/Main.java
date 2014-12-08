package plugins;

import java.io.File;

public class Main {
	
	
	
	
	
	

	public static void main(String[] args) {
		
		/* Testing the filtering plugins */
		File directory = new File("/home/git/plugins/bin/plugins");
		PluginFilter filter = new PluginFilter();
		filter.testing(directory, "FunnyPlugin.class");
		

	}
}