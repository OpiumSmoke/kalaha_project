package game;

import java.util.List;

public class AlphaBetaAI  extends Computer implements Cloneable {

	private static final int DEPTH = 1;
	private int move;

	public AlphaBetaAI(int playerPosition) {
		super(playerPosition);
		move = -1;
	}

	private int alphabeta(int depth, int alpha, int beta, KalahaGame game)
			throws CloneNotSupportedException {
		if (depth == 0 || game.isFinished()) {
			return bewerten(game);
		}
		
		List<Integer> possibleTurns = game.nextPossibleTurns(game
				.getActivePlayer());
		if (game.getActivePlayer() == getPlayerPosition()) {
			int maxWert = alpha;
			while (!possibleTurns.isEmpty()) {
				KalahaGame gamepoint = game.clone();
//				KalahaController controller = new KalahaController(gamepoint);
				int turn = possibleTurns.remove(0);
//				controller.nextTurn(game.getActivePlayer(), turn);
				int wert = alphabeta(depth - 1, maxWert, beta, gamepoint);
				if (wert > maxWert) {
					maxWert = wert;
					if (maxWert >= beta) {
						break;
					}
					if (depth == DEPTH) {
						move = turn;
					}
				}
			}
			return maxWert;
		} else {
			int minWert = beta;
			while (!possibleTurns.isEmpty()) {
				KalahaGame gamepoint = game.clone();
//				KalahaController controller = new KalahaController(gamepoint);
				int turn = possibleTurns.remove(0);
//				controller.nextTurn(game.getActivePlayer(), turn);
				int wert = alphabeta(depth - 1, alpha, minWert, gamepoint);
				if (wert < minWert) {
					minWert = wert;
					if (minWert <= alpha)
						break;
				}
			}
			return minWert;
		}
	}

	private int bewerten(KalahaGame game) {
		int[][] playingField = game.getPlayingField();
		int player = getPlayerPosition();
		int playerPosition = 7 * player;
		int numberofSeeds = playingField[0][playerPosition];
		int numberOfEnemySeeds = playingField[0][7 - playerPosition];
		return numberofSeeds - numberOfEnemySeeds
				+ (game.getActivePlayer() == getPlayerPosition() ? 5 : 0);
	}

	@Override
	public AlphaBetaAI clone() throws CloneNotSupportedException {
		return (AlphaBetaAI) super.clone();
	}

	public int getNextTurn(KalahaGame game) {
		move = -1;
		try {
			alphabeta(DEPTH, Integer.MIN_VALUE, Integer.MAX_VALUE, game);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return move;
	}

}
