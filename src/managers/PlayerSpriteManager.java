package managers;

import java.awt.image.BufferedImage;

public class PlayerSpriteManager {


	SpriteManager sm;
	
	public PlayerSpriteManager(String file, int width, int height) {
		sm = new SpriteManager(file, width, height);
	}
	
	public BufferedImage get(int xMove, int yMove, int pos) {
		return sm.getSpriteAt(pos, movementToSpriteSheetRow(xMove, yMove));
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

}
