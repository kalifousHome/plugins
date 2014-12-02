package plugins;

public class FunnyPlugin implements Plugin {

	@Override
	public String transform(String s) {
		
		return "<<  FUNNY \n    " + s +"\n ENDIND FUNNY >>\n";
	}

	@Override
	public String getLabel() {
		return "FunnyPlugin\n";
	}

	@Override
	public String helpMessage() {
		return "Being funny won't help\n";
	}

}
