package world;

import static utility.Type.*;
import org.newdawn.slick.Color;
import org.newdawn.slick.SlickException;
import utility.ReferenceFrame;
import entity.Grid;
import entity.Player;
import entity.structure.BlockStructure;

public class Game extends World {
	ReferenceFrame rf;
	Player player;
	Grid grid;

	@Override
	public void init() throws SlickException {
		player = new Player();
		grid = new Grid();
		rf = new ReferenceFrame(player, 1280, 720);
		
		addObject(grid, 960, 540);
		addObject(player, 960f, 540f);
		addObject(new BlockStructure(SMALL_BLOCK, "src/text/small1.txt"), 0, 0);
		addObject(new BlockStructure(LARGE_BLOCK, "src/text/large1.txt"), 0, 0);
		
		setReferenceFrame(rf);
		setBackgroundColor(new Color(16, 30, 45));
	}
	
	@Override
	public int getID() {
		return 3;
	}
}
