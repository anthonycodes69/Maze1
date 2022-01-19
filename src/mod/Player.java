package mod;

public class Player {

	public Location _position;
	private boolean _isDead;
	public boolean _hasSword;
	
	public Location getLoc() { return _position; }
	public boolean isDead() { return _isDead; }
	public boolean hasSword() { return _hasSword; }
	
	public void moveUp() { _position.moveUp(); }
	public void moveDown() { _position.moveDown(); }
	public void moveLeft() { _position.moveLeft(); }
	public void moveRight() { _position.moveRight(); }
	
	public void kill() { _isDead = true; }
	public void revive() { _isDead = false; }
	
	public Player(Location pos) {
		_position = pos;
		_isDead = false;
		_hasSword = false;
		
	}
	
}
