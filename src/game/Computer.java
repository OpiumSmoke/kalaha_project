package game;

public abstract class Computer implements Cloneable {
	protected int playerPosition;

	public Computer(int playerPosition) {
		super();
		this.setPlayerPosition(playerPosition);
	}
	
	public Computer clone() throws CloneNotSupportedException {
		return (Computer) super.clone();
	}

	public abstract int getNextTurn(KalahaGame game);

	public int getPlayerPosition() {
		return playerPosition;
	}

	public void setPlayerPosition(int playerPosition) {
		this.playerPosition = playerPosition;
	}

}
