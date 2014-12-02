package plugins;

public interface Plugin {

	public String transform(String s);
	
	public String getLabel();
	
	public String helpMessage();
	
}
