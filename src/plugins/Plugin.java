package plugins;
/**
 *  Description :
 *  Interface defining a common type for plug-ins and specifying minimum needed methods		
 *  
 */

public interface Plugin {

	/**	Applying a transformation to a text 
	 *@param	s the text to be transformed by the plug-in
	 *@return returns the text transformed by the plug-in
	 * 	 */
	public String transform(String s);
	
	/** Getting a description of the plug-in 
	 *@return returns the label of the plug-in (i.e an explicit description )
	 */
	public String getLabel();
	
	/** Getting some help 
	 *@return returns a help message 
	 */
	public String helpMessage();
	
}
