package managers;

import java.awt.image.BufferedImage;

import utilities.FileManager;

public class SpriteManager {

	int width = 0;
	int height = 0;
	int spriteWidth = 0;
	int spriteHeight = 0;

	BufferedImage spriteSheet;

	public SpriteManager(String file, int spriteWidth, int spriteHeight) {
		this.spriteWidth = spriteWidth;
		this.spriteHeight = spriteHeight;
		this.spriteSheet = FileManager.importImage(file);
		this.width = this.spriteSheet.getWidth() / spriteWidth;
		this.height = this.spriteSheet.getHeight() / spriteHeight;
	}

	public BufferedImage getSpriteAt(int index) {
		index %= width * height;
		System.out.println(index + ", " + index % width + ", " + (index - index % width) / width);
		return getSpriteAt(index % width, (index - index % width) / width);
	}

	public BufferedImage getSpriteAt(int xIndex, int yIndex) {
		xIndex %= width;
		yIndex %= height;
		return spriteSheet.getSubimage(xIndex * spriteWidth, yIndex * spriteHeight, spriteWidth, spriteHeight);
	}

}
