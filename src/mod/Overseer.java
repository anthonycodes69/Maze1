package mod;

import javax.swing.JOptionPane;

import viewcon.Controller;

public class Overseer {

	private Controller _cnt;
	private Maze _maze;
	private Player _ply;
	private Minotaur _min;
	private Minotaur _min2;
	private Minotaur _min3;
	private Sword _mySword;
	private Trap _myTrap;
	public static boolean isRico =false;
	public static Location trap  = new Location(4,4);
	
	public Overseer() {	
		isRico = JOptionPane.showInputDialog("What is your name?").toLowercase().equals("rico");
		int difficulty = Integer.parseInt( JOptionPane.showInputDialog("Choose your difficulty level 1-3",));
		
		_maze = new Maze(difficulty-1);
		_ply = new Player(_maze.getStart());
		_min = new Minotaur(_maze.getSpawn());
		_min2 = new Minotaur(new Location(6,9));
		_min3 = new Minotaur(new Location(1,9));
		_myTrap = new Trap(new Location(2,1));
		_cnt = new Controller(_ply, _min, _maze, "","Type wasd to move." + _ply.hasSword(), _mySword, _min2, _min3, _myTrap);
		_mySword = new Sword(new Location(7,1));
		update();
		
		
	}
	
	private void update() {
		int pRow = _ply.getLoc().getRow();
		int pCol = _ply.getLoc().getCol();
		int mRow = _min.getLoc().getRow();
		int mCol = _min.getLoc().getCol();
		int m2Row = _min2.getLoc().getRow();
		int m2Col = _min2.getLoc().getCol();
		int trapRow = _myTrap.getLoc().getRow();
		int trapCol = _myTrap.getLoc().getCol();
		int m3Row = _min3.getLoc().getRow();
		int m3Col = _min3.getLoc().getCol();
		int endRow = _maze.getEnd().getRow();
		int endCol = _maze.getEnd().getCol();
		int swordRow = _mySword.getLoc().getRow();
		int swordCol = _mySword.getLoc().getCol();
		
		System.out.println(_ply.getLoc().getCol());
		System.out.println(_ply.getLoc().getRow());
		
		while(!(pRow == endRow && pCol == endCol) &&
				!(_ply.isDead())) {
			movePlayer(_cnt.move());
			if(_ply.getLoc() == new Location(7,1))
			{
				_ply._hasSword = true;
				System.out.println("q");
			}
			moveMinotaur();
			moveMinotaur2();
			moveMinotaur3();
			pRow = _ply.getLoc().getRow();
			pCol = _ply.getLoc().getCol();
			mRow = _min.getLoc().getRow();
			mCol = _min.getLoc().getCol();
			m2Row = _min.getLoc().getRow();
			m2Col = _min.getLoc().getCol();
			m3Row = _min.getLoc().getRow();
			m3Col = _min.getLoc().getCol();
			trapRow = _myTrap.getLoc().getCol();
			trapCol = _myTrap.getLoc().getCol();
			swordRow = _mySword.getLoc().getCol();
			swordCol = _mySword.getLoc().getCol();
			
			pVE(pRow, pCol, mRow, mCol);
			trapKill(pRow, pCol);
			swordKill(swordRow, swordCol, mRow, mCol);
			swordKill(swordRow, swordCol, m2Row, m2Col);
			swordKill(swordRow, swordCol, m3Row, m3Col);
			
		}
		if(!_ply.isDead()) {
			_cnt.victory();
		}
		else {
			_cnt.defeat();
		}
	}
	
	private void pVE(int pRow, int pCol, int mRow, int mCol) {
		if(pRow == mRow && pCol == mCol) 
			_ply.kill();
	}
	
	private void trapKill(int pRow, int pCol) {
		if(pRow == 4 && pCol == 4) 
			_ply.kill();
	}
	
	private void swordKill(int swordRow, int swordCol, int mRow, int mCol) {
		if(swordRow == mRow && swordCol == mCol) 
			_min.kill();
			_min2.kill();
			_min3.kill();
	}
		
	private void movePlayer(Direction d) {

		if(d == Direction.UP) {
			_ply.moveUp();
			_ply._position = new Location(_ply._position.getRow(),_ply._position.getCol());
		}
		else if(d == Direction.DOWN) {
			_ply.moveDown();
			_ply._position = new Location(_ply._position.getRow(),_ply._position.getCol());
		}
		
		else if(d == Direction.LEFT) {
			_ply.moveLeft();
			_ply._position = new Location(_ply._position.getRow(),_ply._position.getCol()-1);
		}
		else {
			_ply.moveRight();
			_ply._position = new Location(_ply._position.getRow(),_ply._position.getCol()+1);
		}
		
	}
	
	
	private void moveMinotaur() {
		int _minRow = _min.getLoc().getRow();
		int _minCol = _min.getLoc().getCol();
		
		boolean[][] map = _maze.getMap().getArr();
		
		int rowDist = _min.getLoc().getRow() - _ply.getLoc().getRow();
		int colDist = _min.getLoc().getCol() - _ply.getLoc().getCol();
		
		if(rowDist > 0){ // Min Row > Ply Row
			if(map[_minRow - 1][_minCol]){
				_min.moveUp();
			}
			else{
				if(colDist > 0 && map[_minRow][_minCol - 1]){ // Move Left
					_min.moveLeft();
				}
				else if(colDist < 0 && map[_minRow][_minCol + 1]){ 
					_min.moveRight();
				}
			}
		}
		else if(rowDist < 0){ // Min Row < Ply Row
			if(map[_minRow + 1][_minCol]){
				_min.moveDown();
			}
			else{
				if(colDist > 0 && !map[_minRow][_minCol - 1]){
					_min.moveLeft();
				}
				else if(colDist < 0 && map[_minRow][_minCol + 1]){
					_min.moveRight();
				}
			}
		}
		else {
			if(colDist > 0 && map[_minRow][_minCol - 1]){
				_min.moveLeft();
			}
			else if(colDist < 0 && map[_minRow][_minCol + 1]){
				_min.moveRight();
			}
			
		}
	}
	
	private void moveMinotaur2() {
		int _min2Row = _min2.getLoc().getRow();
		int _min2Col = _min2.getLoc().getCol();
		
		boolean[][] map = _maze.getMap().getArr();
		
		int rowDist = _min2.getLoc().getRow() - _ply.getLoc().getRow();
		int colDist = _min2.getLoc().getCol() - _ply.getLoc().getCol();
		
		if(rowDist > 0){ // Min Row > Ply Row
			if(map[_min2Row - 1][_min2Col]){
				_min2.moveUp();
			}
			else{
				if(colDist > 0 && map[_min2Row][_min2Col - 1]){ // Move Left
					_min2.moveLeft();
				}
				else if(colDist < 0 && map[_min2Row][_min2Col + 1]){ 
					_min2.moveRight();
				}
			}
		}
		else if(rowDist < 0){ // Min Row < Ply Row
			if(map[_min2Row + 1][_min2Col]){
				_min2.moveDown();
			}
			else{
				if(colDist > 0 && !map[_min2Row][_min2Col - 1]){
					_min2.moveLeft();
				}
				else if(colDist < 0 && map[_min2Row][_min2Col + 1]){
					_min2.moveRight();
				}
			}
		}
		else {
			if(colDist > 0 && map[_min2Row][_min2Col - 1]){
				_min2.moveLeft();
			}
			else if(colDist < 0 && map[_min2Row][_min2Col + 1]){
				_min2.moveRight();
			}
			
		}
	}
	
	private void moveMinotaur3() {
		int _min3Row = _min3.getLoc().getRow();
		int _min3Col = _min3.getLoc().getCol();
		
		boolean[][] map = _maze.getMap().getArr();
		
		int rowDist = _min3.getLoc().getRow() - _ply.getLoc().getRow();
		int colDist = _min3.getLoc().getCol() - _ply.getLoc().getCol();
		
		if(rowDist > 0){ // Min Row > Ply Row
			if(map[_min3Row - 1][_min3Col]){
				_min3.moveUp();
			}
			else{
				if(colDist > 0 && map[_min3Row][_min3Col - 1]){ // Move Left
					_min3.moveLeft();
				}
				else if(colDist < 0 && map[_min3Row][_min3Col + 1]){ 
					_min3.moveRight();
				}
			}
		}
		else if(rowDist < 0){ // Min Row < Ply Row
			if(map[_min3Row + 1][_min3Col]){
				_min3.moveDown();
			}
			else{
				if(colDist > 0 && !map[_min3Row][_min3Col - 1]){
					_min3.moveLeft();
				}
				else if(colDist < 0 && map[_min3Row][_min3Col + 1]){
					_min3.moveRight();
				}
			}
		}
		else {
			if(colDist > 0 && map[_min3Row][_min3Col - 1]){
				_min3.moveLeft();
			}
			else if(colDist < 0 && map[_min3Row][_min3Col + 1]){
				_min3.moveRight();
			}
			
		}
	}
	
	
	//cum?
	
	
	
}
