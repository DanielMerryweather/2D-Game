package graphics;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import managers.FileManager;

public class TileMap {

	String[] resources;
	BufferedImage[] images;
	int[][] map;
	
	public TileMap(String file) {
		String[] info = FileManager.importFile(file);
		this.resources = info[0].split(",");
		this.map = new int[info.length-1][];
		for(int y=1;y<info.length;y++) {
			System.out.println(info[y]);
			String[] cols = info[y].split("");
			this.map[y-1] = new int[cols.length];
			for(int x=0;x<cols.length;x++) {
				this.map[y-1][x] = Integer.parseInt(cols[x]);
			}
		}
		this.loadResources();
	}
	
	public TileMap(String directory, String[] resources, int[][] map) {
		this.resources = new String[resources.length];
		for(int i=0;i<resources.length;i++) {
			this.resources[i] = directory + resources[i];
		}
		this.map = map;
		this.loadResources();
	}
	
	public void render(Graphics2D g, int xOffset, int yOffset, int width, int height) {
		for(int y=0;y<map.length;y++) {
			for(int x=0;x<map[y].length;x++) {
				g.drawImage(images[map[y][x]], x*width+xOffset, y*height+yOffset, width, height, null);
			}
		}
	}
	
	public void loadResources() {
		this.images = new BufferedImage[resources.length];
		for(int i=0;i<this.resources.length;i++) {
			String file = resources[i];
			this.images[i] = FileManager.importImage(file);
		}
	}
	
	public static void main(String[] args) {
		TileMap tm = new TileMap("resources/textures/", new String[]{"tile01.png","tile02.png"}, new int[][] {
			{0,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
			{1,0,1,0,0,1,0,0,0,1,0,0,1,0,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
			{1,0,1,0,0,1,0,0,0,1,0,0,1,0,1},
			{1,0,1,0,0,1,0,0,0,1,0,0,1,0,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
			{1,0,1,0,0,1,0,0,0,1,0,0,1,0,1},
			{1,0,1,0,0,1,0,0,0,1,0,0,1,0,1},
			{1,0,1,0,0,1,0,0,0,1,0,0,1,0,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
			{1,0,1,0,0,1,0,0,0,1,0,0,1,0,1},
			{1,0,1,0,0,1,0,0,0,1,0,0,1,0,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
			{1,0,1,0,0,1,0,0,0,1,0,0,1,0,1},
			{0,1,1,1,1,1,1,1,1,1,1,1,1,1,0},

		});
		tm.save("resources/tilemaps/tilemap01.txt");
	}
	
	public void save(String file) {
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter(new File(file)));
			for(String r : resources) {
				bw.write(r + ",");
			}
			bw.write("\n");
			for(int y=0;y<map.length;y++) {
				for(int x=0;x<map.length;x++) {
					bw.write(""+map[y][x]);
				}
				bw.write("\n");
			}
			bw.close();
		}catch(Exception e) {
			System.out.println("COULD NOT SAVE FILE");
		}
	}

}
