package managers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FileManager {

	public static BufferedImage importImage(String file) {
		try {
			return ImageIO.read(new File(file));
		} catch (IOException e) {
			System.out.println("File not found");
			return null;
		}
	}

}
