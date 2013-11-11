package game;

public class Player implements Cloneable {
	public String name;
	public int identity;
	public int turn;
	public Computer computer;
	
	public int [] field = new int[7];
	
	public int kalaha = field[6];
	public int pit1 = field[0];
	public int pit2 = field[1];
	public int pit3 = field[2];
	public int pit4 = field[3];
	public int pit5 = field[4];
	public int pit6 = field[5];
	
	public Player player;

	public void setName (String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public int getIdentity () {
		return identity;
	}
	
	public void setIdentity(int number) {
		this.identity = number;
	}
	
	public void setAI(Computer computer) {
		this.computer = computer;
	}
	
	public boolean isComputer() {
		return computer != null;
	}
	public void setPlayer (String name, int identity, int turn, int[] field, Computer computer) {
		setName(name);
		setIdentity(identity);
		setTurn(turn);
		setField(field);
		setAI(computer);
	}
	
	public Player(String name) {
		super();
		this.name = name;
	}
	
	public Computer getComputer() {
		return computer;
	}
	
	public Player(String name, Computer computer) {
		super();
		this.name = name;
		this.computer = computer;
	}
	
	public Player getPlayer () {
		return player;
	}
	
	public void setTurn (int turn) {
		this.turn = turn;
	}
	
	public int getTurn() {
		return turn;
	}
	
	public int[] getField() {
		return field;
	}
	
	public void setField (int[] newfield) {
		this.field = newfield;
	}
	
	public int getKalaha() {
		int [] tmp = getField();
		kalaha = tmp[6];
		return kalaha;
	}
	
	public Player clone() throws CloneNotSupportedException{
		Player p = (Player) super.clone();
		p.name = new String(name);
		if(computer != null){
			p.computer = computer.clone();
		}
		
		return p;
	}

}
