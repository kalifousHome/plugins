package plugins;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Description :
 *  Class representing action listeners for plug-ins
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
	protected final ConfigurableTimer timer;
	/* Set of identified plug-ins */
	protected Set<File> knownFiles = new HashSet<File>();
	protected PluginFilter filter;

	/**
	 *@param directory
	 *            the directory where we are going to check the content in order
	 *            to find the .class
	 * */
	public PluginFinder(File directory) {

		this.directory = directory;
		this.timer = new ConfigurableTimer(this);
	}

	/**
	 *@param e not used
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		Set<File> currentFiles = ListFiles();
		Set<File> newFiles = new HashSet<File>(currentFiles);
		newFiles.removeAll(knownFiles);

		for (File file : newFiles) {
			notifyListeners(file);
		}

		knownFiles = currentFiles;
	}

	/**
	 *@return returns a set containing the files or directory both contained in
	 *         the attribute directory and satisfying a the attribute filter
	 * 
	 */
	protected Set<File> ListFiles() {

		return new HashSet<File>(Arrays.asList(directory.listFiles(filter)));

	}

	/**
	 * 
	 *@param file the file to be added as a event and concerning every listener
	 */
	protected void notifyListeners(File file) {

		ArrayList<PluginListener> listenerCopy = new ArrayList<PluginListener>(
				listeners);

		for (PluginListener listener : listenerCopy) {
			/* Only in case if it satisfies the conditions defined by filters ?? */
			listener.pluginAdded(new PluginEvent(file));
		}
	}

	/**
	 * starts the timer using the attribute REFRESH_INTERNAL_MS as the checking frequency
	 */
	public void start() {

		timer.start(REFRESH_INTERVAL_MS);

	}
	/** 
	 * 
	 *@param listener the listener to add to the list of listeners
	 */
	public synchronized void addListener(PluginListener listener) {

		listeners.add(listener);

	}
}