package main;


import java.io.File;

import plugins.graphics.Window;
import plugins.tools.PluginFinder;



public class Main {
	protected PluginFinder finder ;
	protected Window window ;
	
	public Main(File directory){
		this.window = new Window("tp_plugins");
		this.finder = new PluginFinder(directory);
		this.finder.addListener(this.window.tools);
	}
	
	/*
	 * imprime pour le moment error en boucle
	 * peut etre changer configurableTimer (qui est Timer en moins bien)
	 * et voir pourquoi on ne voit pas Window alors que si on la crée 
	 * dans le main on la voit ...
	 */
	public static void main(String[] args) {
		File directory = new File("git/plugins/dropins/");
		Main main = new Main(directory);
		System.out.println("lancement du main");
		main.finder.start();
		main.window.frame.setVisible(true);
		

	}
}
