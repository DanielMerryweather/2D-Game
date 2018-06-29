package states;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import framework.State;
import managers.KeyboardManager;
import managers.SpriteManager;

public class TestState extends State {

	int xMove = 0;
	int yMove = 0;

	SpriteManager sm;
	KeyboardManager km;

	@Override
	public void init() {
		sm = new SpriteManager("resources/sprites/rogueChar.png", 32, 32);
		km = new KeyboardManager();
	}

	@Override
	public void update() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(sm.getSpriteAt(0, movementToSpriteSheetRow(xMove, yMove)), 0, 0, 100, 100, null);
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
			return 6 - y;
		}
		return 0;
	}

	@Override
	public void keyEvent(int keyCode, String eventType) {
		km.updateKeyEvent(keyCode, eventType);
		xMove = (km.checkKey(KeyEvent.VK_A)? -1:0) + (km.checkKey(KeyEvent.VK_D)? 1:0);
		yMove = (km.checkKey(KeyEvent.VK_W)? 1:0) + (km.checkKey(KeyEvent.VK_S)? -1:0);
	}

	@Override
	public void mouseEvent(String eventType) {
	}
}
