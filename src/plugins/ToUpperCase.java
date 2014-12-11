package plugins;

public class ToUpperCase {

	/** transform all the letters to upper case
	 * @see plugin.Plugin#transform(java.lang.String)
	 */
	public String transform(String s) {
		return s.toUpperCase();
	}

	/**
	 * @see plugin.Plugin#getLabel()
	 */
	public String getLabel() {
		return "to upper case";
	}

	/**
	 * @see plugin.Plugin#helpMessage()
	 */
	public String helpMessage() {
		return "Transform all the letters to upper case";
	}
}
