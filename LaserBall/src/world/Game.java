package world;

import org.newdawn.slick.Color;
import org.newdawn.slick.SlickException;

import utility.ReferenceFrame;
import entity.Grid;
import entity.Player;

public class Game extends World {
	ReferenceFrame rf;
	Player player;
	Grid grid;
	
	public Game() throws SlickException {
		
	}
	
	@Override
	public int getID() {
		return 2;
	}

	@Override
	public void init() throws SlickException {
		player = new Player();
		grid = new Grid();
		rf = new ReferenceFrame(player, 1280, 720);
		
		addObject(grid, 960, 540);
		addObject(player, 200f, 200f);
		setReferenceFrame(rf);
		setBackgroundColor(new Color(16, 30, 45));
	}

}
