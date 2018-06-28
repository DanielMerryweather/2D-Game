package framework;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JPanel {

	private static final long serialVersionUID = -7807401978276702646L;

	int width = 0;
	int height = 0;
	int paneWidth = 0;
	int paneHeight = 0;
	String title = "DEFAULT_TITLE";

	JFrame frame;
	State state;

	public void create(int width, int height, String title, State state) {
		this.height = height;
		this.width = width;
		this.title = title;
		this.state = state;
		setupFrame();
	}

	public void setupFrame() {
		frame = new JFrame();
		setTitle();
		this.setDimensions(width, height);
		frame.add(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		unhide();
		center();
		bindKeyListener();
		bindMouseListener();
	}

	public void bindKeyListener() {
		frame.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent k) {
				state.keyEvent(k.getKeyCode(), "keyPressed");
			}

			@Override
			public void keyReleased(KeyEvent k) {
				state.keyEvent(k.getKeyCode(), "keyReleased");
			}

			@Override
			public void keyTyped(KeyEvent k) {
				state.keyEvent(k.getKeyCode(), "keyTyped");
			}
		});
	}

	public void bindMouseListener() {
		frame.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent m) {
				state.mouseEvent("mouseClicked");
			}

			@Override
			public void mouseEntered(MouseEvent m) {
				state.mouseEvent("mouseEntered");
			}

			@Override
			public void mouseExited(MouseEvent m) {
				state.mouseEvent("mouseExited");
			}

			@Override
			public void mousePressed(MouseEvent m) {
				state.mouseEvent("mousePressed");
			}

			@Override
			public void mouseReleased(MouseEvent m) {
				state.mouseEvent("mouseReleased");
			}
		});
	}

	public void hide() {
		frame.setVisible(false);
	}

	public void unhide() {
		frame.setVisible(true);
	}

	public void center() {
		frame.setLocationRelativeTo(null);
	}

	public void setDimensions(int width, int height) {
		frame.setSize(width, height);
		paneWidth = frame.getContentPane().getWidth();
		paneHeight = frame.getContentPane().getWidth();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
		frame.setTitle(title);
	}

	public void setTitle() {
		frame.setTitle(title);
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void close() {
		frame.dispose();
	}

	public void update() {
		frame.repaint();
	}

	public void paintComponent(Graphics g) {
		state.render(g);
	}

}
