package managers;

import java.util.HashMap;

public class KeyboardManager {

	HashMap<Integer, Boolean> keys = new HashMap<Integer, Boolean>();
	
	public KeyboardManager() {}
	
	public void updateKeyEvent(int keyCode, String eventType) {
		if(eventType.equals("keyPressed")) {
			keys.put(keyCode, true);
		}else if(eventType.equals("keyReleased")) {
			keys.put(keyCode, false);
		}
	}
	
	public boolean checkKey(int keyCode) {
		try {
			return keys.get(keyCode);
		}catch(Exception e) {
			return false;
		}
	}
	
}
