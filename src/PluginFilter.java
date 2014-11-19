import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Constructor;

public class PluginFilter implements FilenameFilter {

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

	protected boolean classHasParameterLessConstructor(Class<?> theClass) {
		for(Constructor<?> constructor : theClass.getConstructors()){
			if(constructor.getParameterTypes().length == 0)
				return true;
		}
		
		return false;
	}

	protected boolean classInPluginPackage(Class<?> theClass) {
		return theClass.getPackage().getName().equals("plugin");
	}

	protected boolean inheritfromPlugin(Class<?> theClass) {
		return Plugin.class.isAssignableFrom(theClass);
	}

	protected Class<?> getClass(File dir, String filename) {
		String className = filename.replaceFirst("\\.class$", "");
		try {
			return Class.forName("plugin" + className);
		} catch (ClassNotFoundException e) {
			return null;
		}
	}

	protected boolean fileExtensionIsClass(String filename) {
		return filename.endsWith(".class");
	}

}
