package entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import utility.Geometry;

public abstract class Entity {
	private Image image;
	private float x, y, rotation;
	
	public void setX(float x) {
		this.x = x;
	}
	
	public void setY(float y) {
		this.y = y;
	}
	
	public void changeX(float dx) {
		x += dx;
	}
	
	public void changeY(float dy) {
		y += dy;
	}
	
	public void setRotation(float r) {
		rotation = r;
		image.setRotation(rotation);
	}
	
	public void setImage(Image i) {
		this.image = i;
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public float getRotation() {
		return rotation;
	}
	
	public Image getImage() {
		return image;
	}
	
	public int getWidth() {
		return image.getWidth();
	}
	
	public int getHeight() {
		return image.getHeight();
	}
	
	public void turnTowards(float x, float y) {
		float angle = Geometry.getAngle(getX(), getY(), x, y);
		setRotation(angle);
	}
	
	public void render(GameContainer gc, StateBasedGame gs, Graphics g)
			throws SlickException {
		image.draw(x - (getWidth() / 2.0f), y - (getHeight() / 2.0f));
	}

	abstract public void update(GameContainer gc, StateBasedGame gs, int d)
			throws SlickException;
}
