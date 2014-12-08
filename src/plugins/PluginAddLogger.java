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
	public void pluginAdded(PluginEvent e) {
		System.out.println("Plugin ajouté : "+e.getFileName());
	}
	/**
	 *@param e the the removed plug-in that we need to notify the user about
	 */
	@Override
	public void pluginRemoved(PluginEvent e) {
		System.out.println("Plugin supprimé : "+e.getFileName());
			
	}
	@Override
	public void getPluginFromEvent(PluginEvent e) {
		
	}

}
