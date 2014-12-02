package plugins;
import java.util.EventListener;


public interface PluginEventListener extends EventListener{
	/** 	 * 
	 *@param e the added plug-in
	 */
	public void pluginAdded(PluginAddedEvent e);
	/**
	 * 
	 *@param e the removed plug-in
	 */
	public void pluginRemoved(PluginAddedEvent e);

}
