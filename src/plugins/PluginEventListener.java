package plugins;
import java.util.EventListener;


public interface PluginEventListener extends EventListener{

	public void pluginAdded(PluginAddedEvent e);

}
