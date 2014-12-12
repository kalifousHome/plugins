package plugins.tools;

import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Constructor;

import plugins.Plugin;

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
	 * @param theClass
	 * @return returns
	 */

	protected boolean classHasParameterLessConstructor(Class<?> theClass) {

		for (Constructor<?> constructor : theClass.getConstructors()) {
			if (constructor.getParameterTypes().length == 0)
				return true;
		}

		return false;
	}

	/**
	 * Tells if the class is in in the plug-in package
	 * 
	 * @param theClass the class we want to know if it belongs to the plug-in package
	 * @return returns true if the class is contained in the plug-in package, false if not
	 */
	protected boolean classInPluginPackage(Class<?> theClass) {
		return theClass.getPackage().getName().equals("plugins");
	}

	/**
	 * Tells if a class implements the Plugin interface
	 * @param theClass we want to know if it implements the interface
	 * @return returns true if it implements Plugin, false if not.
	 */
	protected boolean inheritfromPlugin(Class<?> theClass) {
		return Plugin.class.isAssignableFrom(theClass);
	}

	/**
	 * 0
	 * @param dir
	 * @param filename
	 * @return returns
	 */
	protected Class<?> getClass(File dir, String filename) {
		String className = filename.replaceFirst("\\.class$", "");
		try {
			return Class.forName("plugins." + className);
		} catch (ClassNotFoundException e) {
			return null;
		}
	}

	/***
	 * 
	 * @param filename
	 * @return returns
	 */
	protected boolean fileExtensionIsClass(String filename) {
		return filename.endsWith(".class");
	}

	

}
