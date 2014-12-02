public class Main {

	public static void main(String[] args) {

		try {
			Class<?> classTest = Class.forName("plugin.test");

			Plugin test = (Plugin) classTest.newInstance();

			test.fct();
		} catch (Exception e) {
			
			e.printStackTrace();
		
		}
	}

}