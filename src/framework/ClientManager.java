package framework;

import java.awt.Dimension;
import java.awt.Toolkit;

public class ClientManager {

	State currentState;
	Window window;

	public ClientManager(State initialState, float refreshRate) {
		changeState(initialState);
		window = new Window();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		float aspectRatio = 16f / 9f;
		window.create((int) (screenSize.getWidth() / 1), (int) ((1 / aspectRatio) * screenSize.getWidth() / 1),
				"TestState", currentState);
	}

	public void loop(float refreshRate) {
		long deltaTime = (long) (1000000000 / refreshRate);
		long frameTime = System.nanoTime();
		while (true) {
			if (frameTime < System.nanoTime()) {
				frameTime += deltaTime;
				currentState.update();
				window.update();
			}
		}
	}

	public void changeState(State nextState) {
		this.currentState = nextState;
		this.currentState.init();
	}

}
