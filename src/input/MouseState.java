package input;

public class MouseState {
  
  public static int LEFT_BUTTON = 0;
  public static int RIGHT_BUTTON = 1;
  
  private final boolean[] buttonsPressed;
  
  public MouseState() {
    buttonsPressed = new boolean[2];
  }
  
  public void setButtonPressed(int button, boolean pressed) {
    buttonsPressed[button] = pressed;
  }
  
  public boolean isButtonPressed(int button) {
    return buttonsPressed[button];
  }
}
