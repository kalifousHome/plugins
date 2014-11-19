import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 */

/**
 * @author kalifou
 * 
 */
public class PluginFinder implements ActionListener {

	private static final int REFRESH_INTERVAL_MS = 1000;
	protected final File directory;
	protected final List<PluginEventListener> listeners = new ArrayList<PluginEventListener>();
	protected final ConfigurableTimer timer;
	protected Set<File> knownFiles = new HashSet<File>();
	protected PluginFilter filter;

	public PluginFinder(File directory) {

		this.directory = directory;
		this.timer = new ConfigurableTimer(this);
	}

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

	private Set<File> ListFiles() {

		return new HashSet<File>(Arrays.asList(directory.listFiles(filter)));

	}

	private void notifyListeners(File file) {

		ArrayList<PluginEventListener> listenerCopy = new ArrayList<PluginEventListener>(
				listeners);

		for (PluginEventListener listener : listenerCopy) {
			listener.pluginAdded(new PluginAddedEvent(file));
		}
	}

	public void start() {

		timer.start(REFRESH_INTERVAL_MS);

	}

	public synchronized void addListener(PluginEventListener listener) {

		listeners.add(listener);

	}
}