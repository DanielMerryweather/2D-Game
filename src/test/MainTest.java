package test;

import framework.ClientManager;
import states.TestState;

public class MainTest {

	public static void main(String[] args) {
		ClientManager cm = new ClientManager(new TestState(), 60);
		cm.loop(60);
	}

}
