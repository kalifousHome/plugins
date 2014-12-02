package plugins;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

/**
 *
 *
 */
public class ConfigurableTimer implements ActionListener{

	protected int MAX_ITERATIONS;
	protected int nb_iterations;
	protected final ActionListener listener;
	
	public ConfigurableTimer(ActionListener listener, int max_iterations){
		
		this.listener = listener;
		this.MAX_ITERATIONS = max_iterations;
	
	}
	public ConfigurableTimer(ActionListener listener){
		
		this(listener, 0);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		MAX_ITERATIONS++;
		listener.actionPerformed(e);
		
	}
	/**
	 * 
	 * @param milliseconds
	 */
	public void start(int milliseconds){
		
		nb_iterations = 0;
		Timer timer = new Timer( milliseconds, this);
		timer.start();
		
		while(MAX_ITERATIONS == 0 || nb_iterations < MAX_ITERATIONS){
			System.err.print("ERROR\n");
		}	
		timer.stop();
		
	}
}


