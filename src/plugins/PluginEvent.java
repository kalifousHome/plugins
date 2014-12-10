package plugins;
import java.io.File;
import java.util.EventObject;
/**
 * Description : 
 *	Class representing an identified plug-in as an event.
 */

public class PluginEvent extends EventObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1343070984436215419L;
	
	private File file;
	/**
	 *@param file the event trigger
	 */
	public PluginEvent(File file) {
			super(file);
			this.file =file;
		}
	/**
	 * 
	 *@return returns the name of the plugin's file name
	 */
	public String getFileName(){
		return file.getName();
	}
}
