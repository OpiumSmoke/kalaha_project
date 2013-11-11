/**
 * 
 */
package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import actions.Actions;

/**
 * main program window contains:
 * a menu,
 * a top panel with both player names and a status field
 * a game board with hint panel
 * 
 * @author nicky
 *
 */
public class WindowGUI extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private Color green = new Color (0, 250, 0);
	private Color red = new Color (250, 0, 0);
	private Color blue = new Color (0, 0, 250);
	private Color purple = new Color (100, 0, 100);
	
	private Dimension winsize = new Dimension(800, 600);
	
	//window parts
	public JFrame window = new JFrame("Kalaha");
//	JPanel board = new BoardGUI.Board();
	JPanel container = new JPanel();
	JMenuBar menubar = new JMenuBar();
	JMenu game = new JMenu("Game");
	JMenuItem newgame = new JMenuItem("New game");
	JMenuItem help = new JMenuItem("Help");
	JMenuItem exit = new JMenuItem ("Exit");
	

	/**
	 * @param window - main window
	 * @param container - holds elements
	 * @param menubar
	 * @param game - JMenu "Game"
	 * @param newgame - JMenuItem
	 * @param help JMenuItem
	 * @param exit JMenuItem
	 * @param red P1 color and test color
	 * @param blue P2 color
	 * @param green test color
	 * @param purple test color
	 */
	public JFrame WindowGUI() {
		/*
		 * set window properties
		 */
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setPreferredSize(winsize);
		window.setIconImage(new ImageIcon("bin/gui/kalaha.gif").getImage());
		window.setSize(winsize);
		window.setLocationRelativeTo(null);
		
		menubar.setPreferredSize(new Dimension(800, 20));
		menubar.setOpaque(true);
		
		/*
		 * build menu
		 */
		exit.setMnemonic(KeyEvent.VK_C);
		exit.setToolTipText("Exit application");
		exit.addActionListener(Actions.exit);
		
		help.setMnemonic(KeyEvent.VK_C);
		help.setToolTipText("Get help");
		help.addActionListener(Actions.help);
		
		newgame.setMnemonic(KeyEvent.VK_C);
		newgame.setToolTipText("Start a new game of kalaha");
		newgame.addActionListener(Actions.newgame);
		menubar.add(game);
		game.add(newgame);
		game.add(help);
		game.addSeparator();
		game.add(exit);
		
		container.setMinimumSize(winsize);
//		container.setBackground(blue);
		
		
		/*
		 * build container layout
		 */
		GridBagLayout layout = new GridBagLayout();
		layout.columnWidths = new int [] {1};
		layout.rowHeights = new int [] {1, 1};
		layout.columnWeights = new double[] { 1.0,
				Double.MIN_VALUE };
		layout.rowWeights = new double[] { 1.0,
				Double.MIN_VALUE }; 
		
		GridBagConstraints gbc_info = new GridBagConstraints();
		gbc_info.insets = new Insets( 0, 0, 0, 0);
		gbc_info.gridwidth = 1;
		gbc_info.gridheight = 1;
		gbc_info.fill = GridBagConstraints.BOTH;
		gbc_info.gridx = 0;
		gbc_info.gridy = 0;
		
		GridBagConstraints gbc_board = new GridBagConstraints();
		gbc_board.insets = new Insets( 0, 0, 0, 0);
		gbc_board.gridwidth = 1;
		gbc_board.gridheight = 1;
		gbc_board.fill = GridBagConstraints.BOTH;
		gbc_board.gridx = 0;
		gbc_board.gridy = 1;
		
		JPanel info = new InfoGUI().Info();
		JPanel board = new BoardGUI().Board();
		
		container.add(info, gbc_info);
		container.add(board, gbc_board);
		
		//TODO add action listeners
		
		/*
		 * build and make visible
		 */
		window.setJMenuBar(menubar);
		window.add(container);
		window.pack();
		window.setVisible(true);
		
		return window;
	}
	
	public void showWindow() {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				WindowGUI();
			}
		});
	}

}
