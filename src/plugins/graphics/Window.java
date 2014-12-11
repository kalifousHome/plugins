package plugins.graphics;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JTextArea;

import plugins.listeners.ToolsMenu;

/**
 * 
 * @author caron
 * The Graphic class who has to know the plugins and can send an Action when you click somewhere.
 */
public class Window {
	public JFrame frame ;
	protected JTextArea textArea ;
	protected JMenu file ;
	public ToolsMenu tools;
	protected JMenu help;
	
	/**
	 * constructor which take the name of the window
	 */
	public Window(String name){
		this.frame=new JFrame(name);
		this.textArea = new JTextArea();
		this.file = new JMenu("file") ;
		this.help = new JMenu("help") ;
		this.tools = new ToolsMenu("tools",this);
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(file);
		menuBar.add(tools);
		menuBar.add(help);
		frame.setJMenuBar(menuBar);
		frame.add(textArea);
		frame.setSize(800, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
}
