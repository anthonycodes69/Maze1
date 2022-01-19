package mod;

public enum Map {

	Easy(new boolean[][] { 
			{ true, false, false, false, false, false, false, false, false, true },
			{ true, false, false, false, false, false, false, false, false, true },
			{ true,  true,  true,  true, false, false, false, false, false, true },
			{ false, false, false, true, false, false, false, false, false, true },
			{ false, false, false, true, false, false, false, false, false, true },
			{ false, false, false, true, false, false, false, false, false, true },
			{ false, true, 	true,  true,  true,  true,  true,  true,  true,  true },
			{ false, true, false, true, false, true, false, true, false, false },
			{ false, true, true, true, true, true, true, true, true, false },
			{ false, true, false, false, false, false, false, false, false, false } 
			}), 

	Hard(new boolean[][] { 
		{ true, true, true, true, true, true, true, true, true, true },
		{ false, false, false, false, true, false, false, false, false, true },
		{ false,  true,  true,  true, true, true, false, false, false, true },
		{ false, true, false, true, false, true, false, false, false, true },
		{ false, true, false, true, false, true, false, false, false, true },
		{ false, true, false, true, false, true, false, false, false, true },
		{ false, true, 	true,  true,  true,  true,  true,  true,  true,  true },
		{ false, true, false, false, false, false, false, false, false, false },
		{ false, true, false, false, false, false, false, false, false, false },
		{ false, true, false, false, false, false, false, false, false, false } 
		}),
	
	Hardd(new boolean[][] { 
		{ true, false, false, false, false, false, false, false, false, true },
		{ true, false, false, false, false, false, false, false, false, true },
		{ true,  false,  false,  false, false, false, false, false, false, true },
		{ true, false, false, true, true, true, true, true, true, true },
		{ true, false, false, true, false, false, false, false, false, true },
		{ true, false, false, true, false, false, false, false, false, true },
		{ true, true, 	true,  true,  true,  true,  true,  true,  true,  true },
		{ false, true, false, false, false, false, false, false, false, false },
		{ false, true, false, false, false, false, false, false, false, false },
		{ false, true, false, false, false, false, false, false, false, false } 
		});

	private boolean[][] _map;

	public boolean[][] getArr() {
		return _map;
	}

	private Map(boolean[][] map) {
		_map = map;
	}
}
