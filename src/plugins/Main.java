package plugins;
public class Main {

	public static void main(String[] args) {

		try {
			Class<?> classTest = Class.forName("plugin.test");

			Plugin test = (Plugin) classTest.newInstance();

			test.getLabel();
		} catch (Exception e) {
			
			e.printStackTrace();
		
		}
	}

}