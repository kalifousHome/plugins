package plugins;

/**
 * Description :
 * Class need to notify that a plug-in has been properly added 
 */
public class PluginAddLogger  implements PluginEventListener{
	/**
	 *@param e the the added plug-in that we need to notify the user about
	 */
	@Override
	public void pluginAdded(PluginAddedEvent e) {
		System.out.println("Plugin ajouté ");
	}
	/**
	 *@param e the the removed plug-in that we need to notify the user about
	 */
	@Override
	public void pluginRemoved(PluginAddedEvent e) {
		
	}

}
