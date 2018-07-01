package managers;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
	
	public static String[] importFile(String file) {
		try {
			BufferedReader bw = new BufferedReader(new FileReader(new File(file)));
			String[] lines = new String[(int)bw.lines().count()];
			bw = new BufferedReader(new FileReader(new File(file)));
			int pos = 0;
			while(bw.ready()) {
				lines[pos++] = bw.readLine();
			}
			return lines;
		}catch(IOException e) {
			System.out.println("FILE DOES NOT EXIST");
			return null;
		}
	}

}
