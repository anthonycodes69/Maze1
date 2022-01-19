package mod;

public class Sword {
	private Location _position;
	
	public Location getLoc() { return _position; }
	
	private boolean breakSword() {
		int x = (int)(101 * Math.random());
		return x > 50;
	}
	
	public Sword(Location pos) {
		_position = pos;
	}
}
