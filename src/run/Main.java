package run;

import gui.StartGUI;
import gui.WindowGUI;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Starts the program. 
	 * @param args
	 */
	public static void main(String[] args) {
//		StartGUI start = new StartGUI();
//		start.showWindow();
		
		WindowGUI window = new WindowGUI();
		window.showWindow();

	}

}
