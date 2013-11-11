package actions;

import gui.BoardGUI;
import gui.InfoGUI;
import gui.StartGUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;

public class Actions {
	private static Color red = new Color (250, 0, 0);
	
	static private Color color1 = new Color (205, 38, 38);
	static private Color color2 = new Color (24, 116, 205);

//***		main menu listeners
	public static ActionListener exit = new ActionListener () {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	};
	
	public static ActionListener help = new ActionListener () {
		public void actionPerformed(ActionEvent e) {
			BoardGUI.hmsg.setText("You're on your own!");
			BoardGUI.hmsg.setForeground(red);
		}
	};
	
	
	public static ActionListener newgame = new ActionListener () {
		public void actionPerformed(ActionEvent e) {
			clearField();
			StartGUI start = new StartGUI();
			start.showWindow();
		}
	};
	
//***		start new game listeners
	/** 
	 * choose computer 1
	 */
	public static ActionListener choosec1 = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			StartGUI.human1.setSelected(false);
			StartGUI.name_field1.setEnabled(false);
			if (StartGUI.human2.isSelected() == true ) {
					StartGUI.name_field1.setText("Computer");
					if (StartGUI.name_field2.getText() != "Player 2" ||
										StartGUI.name2.getText() != "Computer 2" ) {
						StartGUI.name_field1.setText("Computer");
					}
			} else if (StartGUI.computer2.isSelected() == true ) {
				StartGUI.name_field1.setText("Computer 1");
				StartGUI.name_field2.setText("Computer 2");
			}
		}
	};
	
	/**
	 * choose player 1
	 */
	public static ActionListener choosep1 = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			StartGUI.computer2.setSelected(false);
			StartGUI.name_field1.setText("Player 1");
			StartGUI.name_field1.setEnabled(true);
		}
	};
	
	/**
	 * choose computer 2
	 */
	public static ActionListener choosec2 = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			StartGUI.human2.setSelected(false);
			StartGUI.name_field2.setText("Computer 2");
			StartGUI.name_field2.setEnabled(false);
			
			if (StartGUI.human1.isSelected() == true ) {
				StartGUI.name_field2.setText("Computer");
				if (StartGUI.name_field1.getText() != "Player 1" ||
									StartGUI.name_field2.getText() != "Computer 1" ) {
					StartGUI.name_field2.setText("Computer");
				}
			} else if (StartGUI.computer1.isSelected() == true ) {
				StartGUI.name_field1.setText("Computer 1");
				StartGUI.name_field2.setText("Computer 2");
			}
		}
	};
	
	/**
	 * choose player 2
	 */
	public static ActionListener choosep2 = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			StartGUI.computer2.setSelected(false);
			StartGUI.name_field2.setText("Player 2");
			StartGUI.name_field2.setEnabled(true);
		}
	};

	public static ActionListener play = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			setField();
//			Gameplay.coinToss();
//			Logics.newGame();
//			Logics.showBoard();
//			Logics.playGame(Logics.newGame());
			StartGUI.start.dispose();
			}
	};	
	
	/**
	 * clears field for new game. sets all elements to default state
	 */
	private static void clearField() {
		InfoGUI.message.setText("Kalaha game is built by Nicky =^.^=");
		InfoGUI.message.setForeground(new Color ( 0, 0, 0 ));
		InfoGUI.player1.setEnabled(false);
		InfoGUI.player2.setEnabled(false);
		InfoGUI.player1.setText("Player 1");
		InfoGUI.player2.setText("Player 2");
		
		BoardGUI.pl1h1.setBackground(color1);
		BoardGUI.pl1h1.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		BoardGUI.pl1h2.setBackground(color1);
		BoardGUI.pl1h2.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		BoardGUI.pl1h3.setBackground(color1);
		BoardGUI.pl1h3.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		BoardGUI.pl1h4.setBackground(color1);
		BoardGUI.pl1h4.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		BoardGUI.pl1h5.setBackground(color1);
		BoardGUI.pl1h5.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		BoardGUI.pl1h6.setBackground(color1);
		BoardGUI.pl1h6.setBorder(BorderFactory.createRaisedSoftBevelBorder());	
		
		BoardGUI.pl2h1.setBackground(color2);
		BoardGUI.pl2h1.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		BoardGUI.pl2h2.setBackground(color2);
		BoardGUI.pl2h2.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		BoardGUI.pl2h3.setBackground(color2);
		BoardGUI.pl2h3.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		BoardGUI.pl2h4.setBackground(color2);
		BoardGUI.pl2h4.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		BoardGUI.pl2h5.setBackground(color2);
		BoardGUI.pl2h5.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		BoardGUI.pl2h6.setBackground(color2);
		BoardGUI.pl2h6.setBorder(BorderFactory.createRaisedSoftBevelBorder());	
		
		BoardGUI.undo.setEnabled(false);
		BoardGUI.yes.setEnabled(false);
	}
	
	/**
	 * sets field for a started game
	 */
	public static void setField () {
		InfoGUI.player1.setEnabled(true);
		InfoGUI.player2.setEnabled(true);
		StartGUI.name_field1.setEnabled(true);
		StartGUI.name_field2.setEnabled(true);
		InfoGUI.player1.setText(StartGUI.name1.getText());
		InfoGUI.player2.setText(StartGUI.name2.getText());
		BoardGUI.hmsg.setText("Click a hole to choose it"); 
		
		BoardGUI.kalaha1.setEnabled(true);
		BoardGUI.kalaha2.setEnabled(true);		
		BoardGUI.pl1h1.setEnabled(true);
		BoardGUI.pl1h2.setEnabled(true);
		BoardGUI.pl1h3.setEnabled(true);
		BoardGUI.pl1h4.setEnabled(true);
		BoardGUI.pl1h5.setEnabled(true);
		BoardGUI.pl1h6.setEnabled(true);		
		BoardGUI.pl2h1.setEnabled(true);
		BoardGUI.pl2h2.setEnabled(true);
		BoardGUI.pl2h3.setEnabled(true);
		BoardGUI.pl2h4.setEnabled(true);
		BoardGUI.pl2h5.setEnabled(true);
		BoardGUI.pl2h6.setEnabled(true);
		
		//TODO figure out what to show on the panels
		BoardGUI.k1.setText("0");
		BoardGUI.h11.setText("6");
		BoardGUI.h12.setText("6");
		BoardGUI.h13.setText("6");
		BoardGUI.h14.setText("6");
		BoardGUI.h15.setText("6");
		BoardGUI.h16.setText("6");
		
		BoardGUI.k2.setText("0");
		BoardGUI.h21.setText("6");
		BoardGUI.h22.setText("6");
		BoardGUI.h23.setText("6");
		BoardGUI.h24.setText("6");
		BoardGUI.h25.setText("6");
		BoardGUI.h26.setText("6");
		// testing
//		GameBoard.undo.setEnabled(true);
//		GameBoard.go.setEnabled(true);
	}
}
