package input;

public class KeysPressed {
  
  boolean[] keys;
  
  public KeysPressed() {
    keys = new boolean[300];
    for(int i = 0; i < keys.length; i++) {
      keys[i] = false;
    }
  }
  
  public void setKeyPressed(int key, boolean pressed) {
    if(key < keys.length) {
      keys[key] = pressed;
    } else {
      System.out.println("Attempted to set key " + key + " but array is too small in KeysPressed class.");
    }
  }
  
  public boolean isKeyPressed(int key) {
    return keys[key];
  }
}
