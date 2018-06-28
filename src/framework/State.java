package framework;

import java.awt.Graphics;

public abstract class State {

	public abstract void init();

	public abstract void update();

	public abstract void render(Graphics g);

	public abstract void keyEvent(int keyCode, String eventType);

	public abstract void mouseEvent(String eventType);

}
