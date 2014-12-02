package plugins;
import java.util.EventListener;


public interface PluginEventListener extends EventListener{
	/**
	 * 
	 * @param e
	 */
	public void pluginAdded(PluginAddedEvent e);

}
