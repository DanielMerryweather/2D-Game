package managers;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class PlayerManager {

	int x = 0;
	int y = 0;
	
	int xMove = 0;
	int yMove = 0;
	
	public PlayerManager(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void update() {
		x += xMove*3;
		y -= yMove*3;
	}
	
	public void render(Graphics2D g, PlayerSpriteManager psm) {
		g.drawImage(getSprite(psm), x, y, 64, 64, null);
	}
	
	public BufferedImage getSprite(PlayerSpriteManager psm) {
		return psm.get(xMove, yMove, 0);
	}
	
	public void keyboardUpdate(KeyboardManager km) {
		xMove = (km.checkKey(KeyEvent.VK_A)? -1:0) + (km.checkKey(KeyEvent.VK_D)? 1:0);
		yMove = (km.checkKey(KeyEvent.VK_W)? 1:0) + (km.checkKey(KeyEvent.VK_S)? -1:0);
	}

}
