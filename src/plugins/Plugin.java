package plugins;
/**
 *  Description :
 *  Interface defining a common type for plugins and specifying minimum needed methods		
 *  
 */

public interface Plugin {

	/**	Applying a transformation to a text 
	 * @param	s the text to be transformed by the plugin
	 * @return returns the text transformed by the plugin
	 * 	 */
	public String transform(String s);
	
	/** Getting a description of the plugin 
	 * @return returns the label of the plugin (i.e an explicit description )
	 */
	public String getLabel();
	
	/** Getting some help 
	 * @return returns a help message 
	 */
	public String helpMessage();
	
}
