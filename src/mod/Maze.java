package mod;

public class Maze {

	private Map _map;
	private Location _start, _end, _spawn;

	public Map getMap() {
		return _map;
	}

	public Location getStart() {
		return _start;
	}

	public Location getEnd() {
		return _end;
	}

	public Location getSpawn() {
		return _spawn;
	}

	public Maze() {
		_map = Map.Easy;
		_start = new Location(9, 1);
		_end = new Location(0, 9);
		_spawn = new Location(0, 0);
	}

	public Maze(int x) {
		if (x == 0) {
			_map = Map.Easy;
			_start = new Location(9, 1);
			_end = new Location(0, 9);
			_spawn = new Location(0, 0);
		}
		if (x == 1) {
			_map = Map.Hard;
			_start = new Location(9, 1);
			_end = new Location(0, 9);
			_spawn = new Location(0, 0);
		}
		if (x == 2) {
			_map = Map.Hardd;
			_start = new Location(9, 1);
			_end = new Location(0, 9);
			_spawn = new Location(0, 0);
		}
		
		else {
			_map = Map.Easy;
			_start = new Location(9, 1);
			_end = new Location(0, 9);
			_spawn = new Location(0, 0);
		}
	}

}
