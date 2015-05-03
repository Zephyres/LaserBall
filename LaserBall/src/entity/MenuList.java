package entity;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import world.World;

public class MenuList extends Entity {
	private String[] buttonNames = {"Singleplayer", "Multiplayer", "Quit"};
	private ArrayList<Button> buttons;
	
	public MenuList() {
		buttons = new ArrayList<Button>();
	}
	
	@Override
	public void update(GameContainer gc, StateBasedGame gs, int d)
			throws SlickException {
		for(int i = 0; i < buttons.size(); i++) {
			if(buttons.get(i).isClick()) {
				if(i == 0)
					gs.enterState(2, new FadeOutTransition(new Color(16, 30, 45)), new FadeInTransition(new Color(16, 30, 45)));
				if(i == 1);
					//Nothing yet
				if(i == 2)
					gc.exit();
			}
		}
	}
	
	public void initButtons() {
		World world = getWorld();
		
		for(int i = 0; i < buttonNames.length; i++) {
			buttons.add(new Button(buttonNames[i]));
			world.addObject(buttons.get(i), 630, 330 + 90 * i);
		}
	}
}
