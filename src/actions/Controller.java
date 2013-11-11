package actions;

import java.util.Observer;

import game.Computer;
import game.KalahaGame;
import game.Player;

public class Controller {
	private Observer window;
	private KalahaGame game;
	private boolean virtuell;

	public Controller(KalahaGame game) {
		this.game = game;
		virtuell = true;
	}

	public Controller(Observer mainWindow, KalahaGame game) {
		this.window = mainWindow;
		virtuell = false;
		this.game = game;
	}

	private void checkKi(Player player) {
		if (player.isComputer() && !virtuell) {
			Computer computer = player.getComputer();
			int choice = computer.getNextTurn(game);
			nextTurn(game.getActivePlayer(), choice);
		}

	}

	private int countSeeds(int i) {
		int[][] playingField = game.getPlayingField();
		int count = 0;
		for (int j = 1; j < 7; j++) {
			count += playingField[i][j];
		}
		return count;
	}

	private void finishGame() {
		game.setFinished(true);
	}

	public void nextTurn(int i, int j) {
		int[][] playingField = game.getPlayingField();
		int numberofSeeds = playingField[i][j];
		playingField[i][j] = 0;

		while (numberofSeeds > 0) {
			if (i == 0) {
				j--;
			} else {
				j++;
			}
			if (j == 0) {
				if (game.getActivePlayer() == 0) {
					playingField[0][0] += 1;
				} else {
					numberofSeeds++;
				}
				i = 1 - i;
			} else if (j == 7) {
				if (game.getActivePlayer() == 1) {
					playingField[0][7] += 1;
				} else {
					numberofSeeds++;
				}
				i = 1 - i;
			} else {
				playingField[i][j] += 1;
			}
			numberofSeeds--;
		}
		game.setPlayingField(playingField);

		// Fangen
		if (j > 0 && j < 7 && playingField[i][j] == 1
				&& playingField[1 - i][j] > 0) {
			if (game.getActivePlayer() == 0 && i == 0) {
				playingField[0][j] = 0;
				int enemySeeds = playingField[1][j];
				playingField[1][j] = 0;
				playingField[0][0] = playingField[0][0] + enemySeeds + 1;
			} else if (game.getActivePlayer() == 1 && i == 1) {
				playingField[1][j] = 0;
				int enemySeeds = playingField[0][j];
				playingField[0][j] = 0;
				playingField[0][7] = playingField[0][7] + enemySeeds + 1;
			}
		}

		// Check if game is over
		int playGroundSeedsPlayer1 = countSeeds(0);
		int playGroundSeedsPlayer2 = countSeeds(1);
		if (playGroundSeedsPlayer1 == 0) {
			for (int k = 1; k < 7; k++) {
				playingField[0][7] += playingField[1][k];
				playingField[1][k] = 0;
			}
			finishGame();
			return;
		} else if (playGroundSeedsPlayer2 == 0) {
			for (int k = 1; k < 7; k++) {
				playingField[0][0] += playingField[0][k];
				playingField[0][k] = 0;
			}
			finishGame();
			return;
		}

		// Extra Runde abfangen
		if ((game.getActivePlayer() == 0 && j != 0)
				|| (game.getActivePlayer() == 1 && j != 7)) {
			game.setActivePlayer(1 - game.getActivePlayer());
		}
		Player player = game.getPlayer();
		if (player.isComputer() && !virtuell) {
			Computer computer = player.getComputer ();
			int choice = computer.getNextTurn(game);
			nextTurn(game.getActivePlayer(), choice);
			return;
		}
	}

	public void newGame() {
		game.setStarted(false);
	}

	public void reStartGame() {
		game.reStartKalahaGame();
		checkKi(game.getPlayer());
	}

	public void startGame(String namePlayer1, boolean isPlayer1KI,
			String namePlayer2, boolean isPlayer2KI) {
		game.addObserver(window);
		game.resetStartPlayer();
		game.startKalahaGame(namePlayer1, namePlayer2, isPlayer1KI, isPlayer2KI);
		game.addObserver(window);
		game.notifyObservers();
		checkKi(game.getPlayer());

	}

}
