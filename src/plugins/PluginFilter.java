package plugins;

import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Constructor;

/**
 * Class PluginFilter used to find plug-in files with .class extension
 * 
 **/

public class PluginFilter implements FilenameFilter {

	/**
	 *@param dir
	 *            drop-in directory
	 *@param name
	 *            name of the plug-in to add
	 *@return if the plug-in can be added
	 **/
	@Override
	public boolean accept(File dir, String name) {
		if (!fileExtensionIsClass(name))
			return false;

		Class<?> theClass = getClass(dir, name);
		if (theClass == null)
			return false;

		return inheritfromPlugin(theClass) && classInPluginPackage(theClass)
				&& classHasParameterLessConstructor(theClass);
	}

	/**
	 * 
	 *@param theClass
	 *@return
	 */

	protected boolean classHasParameterLessConstructor(Class<?> theClass) {

		for (Constructor<?> constructor : theClass.getConstructors()) {
			if (constructor.getParameterTypes().length == 0)
				return true;
		}

		return false;
	}

	/**
	 * 
	 * 
	 *@param theClass
	 *@return
	 */
	protected boolean classInPluginPackage(Class<?> theClass) {
		return theClass.getPackage().getName().equals("plugins");
	}

	/**
	 * 
	 *@param theClass
	 *@return
	 */
	protected boolean inheritfromPlugin(Class<?> theClass) {
		return Plugin.class.isAssignableFrom(theClass);
	}

	/**
	 * 
	 *@param dir
	 *@param filename
	 *@return
	 */
	protected Class<?> getClass(File dir, String filename) {
		String className = filename.replaceFirst("\\.class$", "");
		try {
			return Class.forName("plugins" + className);
		} catch (ClassNotFoundException e) {
			return null;
		}
	}

	/***
	 * 
	 *@param filename
	 *@return
	 */
	protected boolean fileExtensionIsClass(String filename) {
		return filename.endsWith(".class");
	}

}
