/**
 * 
 */
package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import actions.Actions;

//import actions.StandardActions;

/**
 * Is creating a start new game dialog.
 * Is playnily copied from the last project. Minimal alterations.
 * 
 * @author nicky
 *
 */
public class StartGUI extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * initializing main variables: size and color
	 */
	public Dimension winsize = new Dimension(400, 200);
	
	Color green = new Color (0, 250, 0);
	Color red = new Color (250, 0, 0);
	Color blue = new Color (0, 0, 250);
	Color purple = new Color (100, 0, 100);
	
	/**
	 * initialize main parts
	 */
	public static JFrame start = new JFrame("Start new game of Kalaha"); // 
	JPanel container = new JPanel();
	JLabel player1 = new JLabel("Player 1:");
	JLabel player2 = new JLabel("Player 2:");
	public static JLabel name1 = new JLabel("Name:");
	public static JLabel name2 = new JLabel("Name:");
	
	public static JTextField name_field1 = new JTextField(25);
	public static JTextField name_field2 = new JTextField(25);
	public static JCheckBox human1 = new JCheckBox("Human", null, true);
	public static JCheckBox human2 = new JCheckBox("Human", null, false);
	public static JCheckBox computer1 = new JCheckBox("Computer", null, false);
	public static JCheckBox computer2 = new JCheckBox("Computer", null, true);
	public JButton play = new JButton("Play");

	/**
	 * @param start JFrame
	 * @param container JPanel, holding stuff
	 * @param player1 JLabel, Player 1
	 * @param player2 JLabel Player 2
	 * @param name1 JLabel "Name:"
	 * @param name2 JLabel "Name:"
	 * @param name_field1 JTextField P1 name
	 * @param name_field2 JTextField P2 name
	 * @param human1 JCheckBox P1 set human
	 * @param human2 JCheckbox P2 set human
	 * @param computer1 JCheckBox P1 set AI
	 * @param computer2 JCheckBox P2 set AI
	 * @param play JButton to play the game
	 * @param red P1 color and test color
	 * @param blue P2 color
	 * @param green test color
	 * @param purple test color
	 */
	public JFrame StartGUI() {
		start.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		start.setPreferredSize(winsize);
		start.setIconImage(new ImageIcon("bin/gui/kalaha.gif").getImage());
		start.setSize(winsize);
		start.setLocationRelativeTo(null);
		start.setResizable(false);
		
		GridBagLayout layout = new GridBagLayout();
		layout.columnWidths = new int[] {0, 0, 0, 0, 0, 0, 0, 0};
		layout.rowHeights = new int [] {0, 0, 0, 0, 0};
		layout.columnWeights = new double[] { 1.0, 1.0, 0.0, 1.0, 1.0, 0.0, 1.0, 1.0,
				Double.MIN_VALUE };
		layout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE }; 
		
		container.setPreferredSize(winsize);
		container.setLayout(layout);
//		container.setBackground(green);
		
		player1.setForeground(red);
		player2.setForeground(blue);
		
		// Player 1
		GridBagConstraints gbc_player1 = new GridBagConstraints();
		gbc_player1.insets = new Insets(10, 20, 0, 0); // ( top, left, bottom, right )
		gbc_player1.gridwidth = 3;
		gbc_player1.fill = GridBagConstraints.NONE;
		gbc_player1.anchor = GridBagConstraints.LINE_START;
		gbc_player1.gridx = 0;
		gbc_player1.gridy = 0;		
		
		// Player 1 Human check box
		GridBagConstraints gbc_human1 = new GridBagConstraints();
		gbc_human1.insets = new Insets(10, 20, 0, 0);
		gbc_human1.gridwidth = 2;
		gbc_human1.anchor = GridBagConstraints.LINE_START;
		gbc_human1.gridx = 3;
		gbc_human1.gridy = 0;
		
		// Player 1 computer check box
		GridBagConstraints gbc_computer1 = new GridBagConstraints();
		gbc_computer1.insets =new Insets( 10, 15, 0, 0);
		gbc_computer1.gridwidth = 2;
		gbc_computer1.anchor = GridBagConstraints.LINE_START;
		gbc_computer1.gridx = 5;
		gbc_computer1.gridy = 0;
		
		// Player 1 row 2 Name:
		GridBagConstraints gbc_name1 = new GridBagConstraints();
		gbc_name1.insets = new Insets (5, 10, 0, 0);
		gbc_name1.gridwidth = 2;
		gbc_name1.anchor = GridBagConstraints.LINE_START;
		gbc_name1.gridx = 0;
		gbc_name1.gridy = 1;
		
		// Player 1 row 2 text field
		GridBagConstraints gbc_name_field1 = new GridBagConstraints();
		gbc_name_field1.insets = new Insets( 5, 5, 0, 0);
		gbc_name_field1.gridwidth = 5;
		gbc_name_field1.fill = GridBagConstraints.HORIZONTAL;
		gbc_name_field1.anchor = GridBagConstraints.LINE_START;
		gbc_name_field1.gridx = 2;
		gbc_name_field1.gridy = 1;
		
		// Player 2
		GridBagConstraints gbc_player2 = new GridBagConstraints();
		gbc_player2.insets = new Insets(20, 20, 0, 0); // ( top, left, bottom, right )
		gbc_player2.gridwidth = 2;
		gbc_player2.fill = GridBagConstraints.NONE;
		gbc_player2.anchor = GridBagConstraints.LINE_START;
		gbc_player2.gridx = 0;
		gbc_player2.gridy = 2;
		
		// Player 2 human check box
		GridBagConstraints gbc_human2 = new GridBagConstraints();
		gbc_human2.insets = new Insets(20, 20, 0, 0);
		gbc_human2.gridwidth = 1;
		gbc_human2.anchor = GridBagConstraints.LINE_START;
		gbc_human2.gridx = 3;
		gbc_human2.gridy = 2;
		
		// Player 2 computer label
		GridBagConstraints gbc_computer2 = new GridBagConstraints();
		gbc_computer2.insets = new Insets(20, 15, 0, 0);
		gbc_computer2.gridwidth = 2;
		gbc_computer2.anchor = GridBagConstraints.LINE_START;
		gbc_computer2.gridx = 5;
		gbc_computer2.gridy = 2;
		
		// Player 2 row 2 Name:
		GridBagConstraints gbc_name2 = new GridBagConstraints();
		gbc_name2.insets = new Insets (5, 10, 0, 0);
		gbc_name2.gridwidth = 2;
		gbc_name2.anchor = GridBagConstraints.LINE_START;
		gbc_name2.gridx = 0;
		gbc_name2.gridy = 3;
		
		// Player 2 row 2 text field
		GridBagConstraints gbc_name_field2 = new GridBagConstraints();
		gbc_name_field2.insets = new Insets( 5, 5, 0, 0);
		gbc_name_field2.gridwidth = 5;
		gbc_name_field2.fill = GridBagConstraints.HORIZONTAL;
		gbc_name_field2.anchor = GridBagConstraints.LINE_START;
		gbc_name_field2.gridx = 2;
		gbc_name_field2.gridy = 3;
		
		//setting element actions
		computer1.addActionListener(Actions.choosec1);
		human1.addActionListener(Actions.choosep1);
		computer2.addActionListener(Actions.choosec2);
		human2.addActionListener(Actions.choosep2);
		play.addActionListener(Actions.play);
			
		GridBagConstraints button = new GridBagConstraints();
		button.insets = new Insets( 20, 5, 5, 5);
		button.gridwidth = 8;
		button.fill = GridBagConstraints.NONE;
		button.anchor = GridBagConstraints.PAGE_END;
		button.gridx = 0;
		button.gridy = 4;	
		
		container.add(player1, gbc_player1);
		container.add(human1, gbc_human1);
		container.add(computer1, gbc_computer1);
		container.add(name1, gbc_name1);
		container.add(name_field1, gbc_name_field1);
		container.add(player2, gbc_player2);
		container.add(human2, gbc_human2);
		container.add(computer2, gbc_computer2);
//		container.add(c2, cp2);
		container.add(name2, gbc_name2);
		container.add(name_field2, gbc_name_field2);
		container.add(play, button);
		
		start.add(container);
		
		start.pack();
		start.setVisible(true);	
		
		return start;
	}
	
	public void showWindow() {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				StartGUI();
			}
		});
	}

}
