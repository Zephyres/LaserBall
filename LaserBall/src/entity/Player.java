package entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Player extends Entity {
	private float ax, ay, vx, vy;
	
	public Player() throws SlickException {
		Image i = new Image("images/player.png").getScaledCopy(0.35f);
		
		setImage(i);
		ax = 0.1f;
		ay = 0.1f;
	}

	@Override
	public void update(GameContainer gc, StateBasedGame gs, int d)
			throws SlickException {
		Input in = gc.getInput();
		
		if(in.isKeyDown(Input.KEY_W))
			vy -= ay;
		if(in.isKeyDown(Input.KEY_A))
			vx -= ax;
		if(in.isKeyDown(Input.KEY_S))
			vy += ay;
		if(in.isKeyDown(Input.KEY_D))
			vx += ax;
		
		changeX(vx);
		changeY(vy);
		
		turnTowards(in.getMouseX(), in.getMouseY());
	}
}
