package states;

import java.awt.Graphics2D;

import framework.State;
import graphics.TileMap;
import managers.KeyboardManager;
import managers.PlayerManager;
import managers.PlayerSpriteManager;

public class TestState extends State {

	PlayerManager pm;
	PlayerSpriteManager psm;
	KeyboardManager km;
	
	TileMap tm;

	@Override
	public void init() {
		pm = new PlayerManager(128,128);
		psm = new PlayerSpriteManager("resources/sprites/rogueChar.png", 32, 32);
		km = new KeyboardManager();
		
		tm = new TileMap("resources/tilemaps/tilemap01.txt");
	}

	@Override
	public void update() {
		pm.update();
	}

	@Override
	public void render(Graphics2D g) {
		tm.render(g, 16, 16, 32, 32);
		pm.render(g, psm);
	}

	@Override
	public void keyEvent(int keyCode, String eventType) {
		km.updateKeyEvent(keyCode, eventType);
		pm.keyboardUpdate(km);
	}

	@Override
	public void mouseEvent(String eventType) {
	}
}
