package plugins;

public class ToUpperCase implements Plugin{

	/** transform all the letters to upper case
	 	 */
	public String transform(String s) {
		return s.toUpperCase();
	}

	
	public String getLabel() {
		return "to upper case";
	}

	
	public String helpMessage() {
		return "Transform all the letters to upper case";
	}
}
