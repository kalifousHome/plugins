package plugins;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.Timer;

/**
 * Description : Class representing action listeners for plug-ins
 *
 */
public class PluginFinder implements ActionListener {
	/* Attributes */
	private static final int REFRESH_INTERVAL_MS = 1000;
	protected final File directory; /*
									 * Le repertoire qu'on va observer chaque
									 * seconde
									 */
	protected final List<PluginListener> listeners = new ArrayList<PluginListener>();
	protected final Timer timer;
	/* Set of identified plug-ins */
	protected Set<File> knownFiles = new HashSet<File>();
	protected PluginFilter filter/* = new PluginFilter() */;

	/**
	 * @param directory
	 *            the directory where we are going to check the content in order
	 *            to find the .class
	 * */
	public PluginFinder(File directory) {
		this.directory = directory;
		this.timer = new Timer(REFRESH_INTERVAL_MS, this);
	}

	/**
	 * @param e
	 *            the signal sent by the timer At every clock add or remove a
	 *            plugin
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("timer marche");
		Set<File> currentFiles = ListFiles();
		Set<File> newFiles = new HashSet<File>(currentFiles);
		newFiles.removeAll(knownFiles);
		for (File file : newFiles) {
			System.out.println("je rentre ici");
			firePluginAdded(file);
		}
		knownFiles = currentFiles;
	}

	/**
	 * @return returns a set containing the files or directory both contained in
	 *         the attribute directory and satisfying a the attribute filter
	 *
	 */
	protected Set<File> ListFiles() {
		return new HashSet<File>(
				Arrays.asList(directory.listFiles(this.filter)));
	}

	/**
	 *
	 * @param file
	 *            the file to be added as a event and concerning every listener
	 */
	protected void firePluginAdded(File file) {
		for (PluginListener listener : listeners) {
			/* Only in case if it satisfies the conditions defined by filters ?? */
			/* if(filter.accept(file, file.getName())){ */
			listener.pluginAdded(new PluginEvent(file));
			System.out.println("j ai trouve " + file.getName());
			/* } */
		}
	}

	/**
	 * starts the timer using the attribute REFRESH_INTERNAL_MS as the checking
	 * frequency
	 */
	public void start() {
		timer.start();
	}

	/**
	 *
	 * @param listener
	 *            the listener to add to the list of listeners
	 */
	public void addListener(PluginListener listener) {
		System.out.println("addListener:nouveau listener pour pluginfinder");
		listeners.add(listener);
	}

	/**
	 * @param listener
	 *            the listener to remove in the list of listeners
	 */
	public void removeListener(PluginListener listener) {
		listeners.remove(listener);
	}

}