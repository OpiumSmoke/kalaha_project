package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;


public class KalahaGame extends Observable implements Cloneable{
	private Player firstPlayer;
	private Player secondPlayer;
	private int activePlayer;

	private int startPlayer;

	private int[][] playingField;

	private boolean finished;
	private boolean started;
	
	public KalahaGame()  {
		finished = false;
		started = false;
		startPlayer = 0;
		playingField = new int[2][8];
	}
	
	public KalahaGame clone() throws CloneNotSupportedException {
		KalahaGame game = new KalahaGame();
		game.activePlayer = activePlayer;
		game.finished = finished;
		game.started = started;
		game.firstPlayer = firstPlayer.clone();
		game.secondPlayer = secondPlayer.clone();
		game.playingField = new int[2][8];
		for (int i = 0; i < game.playingField.length; i++)
			for (int j = 0; j < game.playingField[i].length; j++)
				game.playingField[i][j] = playingField[i][j];
		return game;
	}
	
	public int getActivePlayer() {
		return activePlayer;
	}

	public Player getFirstPlayer() {
		return firstPlayer;
	}

	public Player getPlayer() {
		if (activePlayer == 0) {
			return firstPlayer;
		}
		return secondPlayer;
	}

	public int[][] getPlayingField() {
		return playingField;
	}

	public Player getSecondPlayer() {
		return secondPlayer;
	}

	public int getSeeds(int player) {
		return playingField[0][7 * player];
	}

	public int getStartPlayer() {
		return startPlayer;
	}

	public boolean isFinished() {
		return finished;
	}

	public boolean isStarted() {
		return started;
	}

	public List<Integer> nextPossibleTurns(int position) {
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 1; i < 7; i++) {
			if (playingField[position][i] > 0) {
				result.add(i);
			}
		}
		return result;
	}

	public void resetStartPlayer() {
		startPlayer = 0;
	}

	public void reStartKalahaGame() {
		setStarted(true);
		playingField[0][0] = 0;
		playingField[0][7] = 0;
		for (int i = 1; i < 7; i++) {
			playingField[0][i] = 6;
			playingField[1][i] = 6;
		}
		this.activePlayer = startPlayer;
		this.finished = false;
		setChanged();
		notifyObservers("startKalahaGame");
	}

	public void setActivePlayer(int activePlayer) {
		this.activePlayer = activePlayer;
		setChanged();
		notifyObservers("setActivePlayer");
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
		int seeds0 = getSeeds(0);
		int seeds1 = getSeeds(1);
		if (seeds0 > seeds1) {
			startPlayer = 0;
		} else if (seeds0 < seeds1) {
			startPlayer = 1;
		} else {
			startPlayer = 1 - startPlayer;
		}
		setChanged();
		notifyObservers("setFinished");
	}

	public void setFirstPlayer(Player firstPlayer) {
		this.firstPlayer = firstPlayer;
	}

	public void setPlayingField(int[][] playingField) {
		this.playingField = playingField;
		setChanged();
		notifyObservers("setPlayingField");
	}

	public void setSecondPlayer(Player secondPlayer) {
		this.secondPlayer = secondPlayer;
	}

	public void setStarted(boolean started) {
		this.started = started;
		setChanged();
		notifyObservers("setStarted");
	}

	public void startKalahaGame(String namePlayer1, String namePlayer2,
			boolean isPlayer1AI, boolean isPlayer2AI) {

		if (isPlayer1AI) {
			firstPlayer = new Player(namePlayer1, new AlphaBetaAI(0));
		} else {
			firstPlayer = new Player(namePlayer1);
		}
		if (isPlayer2AI) {
			secondPlayer = new Player(namePlayer2, new AlphaBetaAI(1));
		} else {
			secondPlayer = new Player(namePlayer2);
		}
		reStartKalahaGame();
	}

	public String toString() {

		String res1 = "[" + playingField[0][0] + "]";
		String res2 = "";
		for (int i = 0; i < res1.length(); i++) {
			res2 += " ";
		}
		for (int i = 1; i < 7; i++) {
			res1 += "[" + playingField[0][i] + "]";
			res2 += "[" + playingField[1][i] + "]";
		}
		res1 += "[" + playingField[0][7] + "]";
		return "Firstplayer: " + firstPlayer.toString() + "\n"
				+ "SecondPlayer: " + secondPlayer.toString() + "\n" + res1
				+ "\n" + res2 + "\n" + "ActivePlayer" + activePlayer + "\n";
	}

}
