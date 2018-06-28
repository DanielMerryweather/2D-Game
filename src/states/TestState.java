package states;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import framework.State;
import managers.SpriteManager;

public class TestState extends State {

	int xMove = 0;
	int yMove = 0;

	SpriteManager sm;

	@Override
	public void init() {
		sm = new SpriteManager("resources/sprites/rogueChar.png", 32, 32);
	}

	@Override
	public void update() {

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(sm.getSpriteAt(0, movementToSpriteSheetRow(xMove, yMove)), 0, 0, 100, 100, null);
		// 0, -1 = 0
		// 1, -1 = 1
		// 1, 0 = 2
		// 1, 1 = 3
		// 0, 1 = 4
		// -1, 1 = 5
		// -1, 0 = 6
		// -1, -1= 7
	}

	public int movementToSpriteSheetRow(int x, int y) {
		if (x == 0) {
			if (y == 1) {
				return 4;
			} else {
				return 0;
			}
		} else if (x == 1) {
			return 2 + y;
		} else if (x == -1) {
			return 6 + y;
		}
		return 0;
	}

	@Override
	public void keyEvent(int keyCode, String eventType) {
		if (eventType.equals("keyPressed")) {
			if (keyCode == KeyEvent.VK_A) {
				if (xMove == 0) {
					xMove = -1;
				} else {
					xMove = 0;
				}
			} else if (keyCode == KeyEvent.VK_D) {
				if (xMove == 0) {
					xMove = 1;
				} else {
					xMove = 0;
				}
			}
		}
	}

	@Override
	public void mouseEvent(String eventType) {
	}
}
