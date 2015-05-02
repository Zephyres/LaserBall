package entity;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import utility.Fonts;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class PrologueText extends Entity {
	private Scanner scan;
	private ArrayList<String> text;
	private TrueTypeFont font, small;
	private int count, lineNum, temp;

	public PrologueText() throws FileNotFoundException {
		text = new ArrayList<String>();
		scan = new Scanner(new File("src/text/prologue.txt"));
		font = Fonts.getRoboto(24f);
		small = Fonts.getRoboto(18f);

		count = 0;
		lineNum = 0;
		temp = 0;
	}

	public void render(GameContainer gc, StateBasedGame gs, Graphics g)
			throws SlickException {
		g.setColor(Color.white);
		g.setFont(font);

		for(int i = 0; i < text.size(); i++) {
			String s = text.get(i);
			g.drawString(s, 630 - font.getWidth(s) / 2, 140 - font.getHeight() / 2 + i * 60);
		}

		g.setFont(small);
		String cut = "PRESS (SPACE) TO SKIP";
		g.drawString(cut, 630 - small.getWidth(cut) / 2, 640);

		temp = lineNum;
	}

	@Override
	public void update(GameContainer gc, StateBasedGame gs, int d)
			throws SlickException {
		if(count <= 0) {
			count = 100;

			if(scan.hasNext()) {
				String s = scan.nextLine();

				if(!s.equals("*")) {
					text.add(s);
					lineNum++;
				}
				else {
					text.clear();
					lineNum = 0;
				}
			}

			else
				gs.enterState(3, new FadeOutTransition(), new FadeInTransition());
		}

		if(gc.getInput().isKeyPressed(Input.KEY_SPACE))
			gs.enterState(3, new FadeOutTransition(), new FadeInTransition());

		count--;
	}
}
