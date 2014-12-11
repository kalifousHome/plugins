package plugins.listeners;
import java.util.EventListener;

import plugins.tools.PluginEvent;
/**
 * Description :
 * Class representing event-listeners for plug-ins
 *
 */

public interface PluginListener extends EventListener{
	/** 	 * 
	 *@param e the added plug-in
	 */
	public void pluginAdded(PluginEvent e);
	/**
	 * 
	 *@param e the removed plug-in
	 */
	public void pluginRemoved(PluginEvent e);

	public void getPluginFromEvent(PluginEvent e);
	
}
