package viewcon;

import javax.swing.JOptionPane;

import mod.Direction;
import mod.Maze;
import mod.Minotaur;
import mod.Player;
import mod.Sword;
import mod.Trap;

public class Controller {
	
	private Player _ply;
	private Minotaur _min;
	private Maze _map;
	private String _name;
	private String _msg;
	private Sword _mySword;
	private Minotaur _min2;
	private Minotaur _min3;
	private Trap _myTrap;
	private boolean _isRico = false;
	
	public Controller(Player ply, Minotaur min, Maze map, String name, String m, Sword swo, Minotaur min2, Minotaur min3, Trap t) {
		_ply = ply;
		_min = min;
		_map = map;
		_name = name;
		_msg = m;
		_mySword = swo;
		_min2 = min2;
		_min3 = min3;
		_myTrap = t;
	}
	
	public Direction move() {
		String s = JOptionPane.showInputDialog(drawMap() + "\n" + _msg + "\n");
		Direction d = convertInput(s);
		while(!isValid(d)) {
			JOptionPane.showMessageDialog(null, "not a valid move!");
			s = JOptionPane.showInputDialog(drawMap() + "\n" + _msg + "\n");
			d = convertInput(s);
		}
		return d;
	}
	
	private boolean isValid(Direction d) {
		boolean[][] map = _map.getMap().getArr();
		int row = _ply.getLoc().getRow();
		int col = _ply.getLoc().getCol();
		
		if(d == Direction.UP) {
			if(row == 0)
				return false;
			row--;
			return map[row][col];
		}
		else if(d == Direction.DOWN) {
			if(row == map.length - 1)
				return false;
			row++;
			return map[row][col];
		}
		else if(d == Direction.LEFT) {
			if(col == 0)
				return false;
			col--;
			return map[row][col];
		}
		else {
			if(col == map[row].length - 1)
				return false;
			col++;
			return map[row][col];
		}
	}
	
	private Direction convertInput(String s) {
		if(s.equals("w")) {
			return Direction.UP;			
		}
		else if(s.equals("a")) {
			return Direction.LEFT;
		}
		else if(s.equals("s")) {
			return Direction.DOWN;
		}
		else if(s.equals("d")) {
			return Direction.RIGHT;
		}
		else {
			return Direction.UP;
		}
	}
	
	public void victory() {
		JOptionPane.showMessageDialog(null, drawMap() + "\n" + "Congratulations, you won the game!" + "\n");
	}
	
	public void defeat() {
		JOptionPane.showMessageDialog(null, drawMap() + "\n" + "Congratulations, you're bad at the game!" + "\n");
	}

	
	private String drawMap() {
		String MAP = "";
		String ply = "P";
		String wall = "x";
		String path = "o";
		String space = "   ";
		String min = "M";
		String trap = "卍";
		String end = "E";
		String Sword = "S";
		String min2 = "M";
		String min3 = "M";
		String t = "T";
		
		
		
		int pRow = _ply.getLoc().getRow();
		int pCol = _ply.getLoc().getCol();
		int mRow = _min.getLoc().getRow();
		int mCol = _min.getLoc().getCol();
		int m2Row = _min2.getLoc().getRow();
		int m2Col = _min2.getLoc().getCol();
		int m3Row = _min3.getLoc().getRow();
		int m3Col = _min3.getLoc().getCol();
		int eRow = _map.getEnd().getRow();
		int eCol = _map.getEnd().getCol();
		int sRow = 7;
		int sCol = 1;
		int trapRow = 4;
		int trapCol = 4;
		
		
		
		boolean[][] map = _map.getMap().getArr();
		
		for(int r = 0; r < map.length; r++) {
			for(int c = 0; c < map[r].length; c++) {
				if(r == mRow && c == mCol) {
					MAP += min + space;
				}
				else if(r == m2Row && c == m2Col) {
					MAP += min2 + space;
				}
				else if(r == m3Row && c == m3Col) {
					MAP += min3 + space;
				}

				else if(r == pRow && c == pCol) {
					MAP += ply + space;
				}
				else if(r == eRow && c == eCol) {
					MAP += end + space;
				}
				else if(r == sRow && c == sCol) {
					if(Overseer.hasSword)
					{
						MAP += path + space;
					}
					else{
						MAP += Sword + space;
					}
					
				}
				else if(r == trapRow && c == trapCol) {
					if(Overseer.isRico)
					{
						MAP += trap + space;
					}
					
				}
				else if(map[r][c]) {
					MAP += path + space;
				}
				
				else {
					MAP += wall + space;
				}

			}
			MAP += "\n";
		}
		
		return MAP;
	}
	
	
}
