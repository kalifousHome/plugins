package plugins.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import plugins.Plugin;
import plugins.graphics.Window;
import plugins.tools.PluginEvent;

public class GraphicalMenu extends JMenu implements PluginListener {
	private static final long serialVersionUID = 1L;

	protected Window window;

	public GraphicalMenu(String label, Window window) {
		super(label);
		this.window = window;
	}

	/**
	 * l'action a faire quand il y a un ajout de plugin
	 */
	@Override
	public void pluginAdded(PluginEvent e) {
		try {

			String nomClass = e.getFileName();
			nomClass = nomClass.substring(0, (nomClass.length() - 6));
			System.out.println(nomClass);
			Class<?> tmp = Class.forName("plugins." + nomClass);

			final Plugin plugin = (Plugin) tmp.newInstance();
			JMenuItem item = new JMenuItem(plugin.getLabel());
			item.addActionListener(new ActionListener() {
				/**
				 * recuperer le text dans le text area et faire transforme
				 * dessus et le renvoyer;
				 */
				@Override
				public void actionPerformed(ActionEvent arg0) {
					String text = window.textArea.getText();
					text = plugin.transform(text);
					window.textArea.setText(text);
				}
			});
			this.window.tools.add(item);
		/*	this.window.help.add(item);*/
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
	
	}

	/**
	 * l'action a faire quand il y a un plugin retiré mais pour l'instant pas
	 * important
	 */
	@Override
	public void pluginRemoved(PluginEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getPluginFromEvent(PluginEvent e) {
		// TODO Auto-generated method stub

	}
      
}
