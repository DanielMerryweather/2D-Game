package utilities;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
	
	public static void saveFile(String[] lines, String file) {
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter(new File(file)));
			for(String s : lines) {
				bw.write(s);
			}
			bw.close();
		}catch(Exception e) {
			System.out.println("COULD NOT SAVE FILE");
		}
	}

}
