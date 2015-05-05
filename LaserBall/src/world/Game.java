package world;

import java.util.ArrayList;
import org.newdawn.slick.Color;
import org.newdawn.slick.SlickException;
import utility.MapInfo;
import utility.ReferenceFrame;
import entity.Grid;
import entity.Player;
import entity.Spawner;
import entity.structure.BlockStructure;

public class Game extends World {
	private ReferenceFrame rf;
	private Player player;
	private Grid grid;

	@Override
	public void init() throws SlickException {
		ArrayList<float[]> details = new ArrayList<float[]>();
		MapInfo info = new MapInfo("map" + getMapID());
		details = info.getSpawnerDetails();
		
		player = new Player();
		grid = new Grid();
		rf = new ReferenceFrame(player, 1280, 720);
		
		addObject(grid, 960, 540);
		
		addObject(new BlockStructure("map" + getMapID()), 0, 0);
		addObject(player, info.getSpawnX(), info.getSpawnY());
		
		for(float[] a : details) {
			float x = a[0];
			float y = a[1];
			int rot = (int) a[2];
			
			Spawner s = new Spawner();
			addObject(s, x, y);
			
			switch(rot) {
				case 0:
					s.setRotation(0);
					break;
				case 1:
					s.setRotation(180);
					break;
				case 2:
					s.setRotation(270);
					break;
				case 3:
					s.setRotation(90);
			}
		}
		
		setReferenceFrame(rf);
		setBackgroundColor(new Color(16, 30, 45));
	}
	
	@Override
	public int getID() {
		return 3;
	}
	
	private int getMapID() {
		return 13;
	}
}
