package input;

import gameobjects.GameGlobals;
import gameobjects.World;
import org.newdawn.slick.Input;
import org.newdawn.slick.MouseListener;
import org.newdawn.slick.geom.Rectangle;

public class GameMouseListener implements MouseListener {

  private final GameGlobals globals;
  
  public GameMouseListener(GameGlobals globals) {
    this.globals = globals;
  }
  
  @Override
  public void mouseWheelMoved(int i) {
    globals.getCamera().scroll(i);
  }

  @Override
  public void mouseClicked(int oldX, int oldY, int newX, int newY) {
    
  }

  @Override
  public void mousePressed(int button, int i1, int i2) {
    globals.getMouseState().setButtonPressed(button, true);
  }

  @Override
  public void mouseReleased(int button, int i1, int i2) {
    globals.getMouseState().setButtonPressed(button, false);
  }

  @Override
  public void mouseMoved(int oldX, int oldY, int newX, int newY) {
    globals.getUI().getMousePosition().set(newX, newY);
    
    Rectangle bounds = globals.getCamera().getBounds();
    double cursorBoundsXPercent = (newX - bounds.getX()) / bounds.getWidth();
    double cursorBoundsYPercent = (newY - bounds.getY()) / bounds.getHeight();
    int cursorBoundsX = (int)((double)World.MAP_WIDTH * cursorBoundsXPercent);
    int cursorBoundsY = (int)((double)World.MAP_HEIGHT * cursorBoundsYPercent);
    globals.getUI().getSelectedTile().set(cursorBoundsX, cursorBoundsY);
  }

  @Override
  public void mouseDragged(int oldX, int oldY, int newX, int newY) {
    mouseMoved(oldX, oldY, newX, newY);
  }

  @Override
  public void setInput(Input input) {
  }

  @Override
  public boolean isAcceptingInput() {
    return true;
  }

  @Override
  public void inputEnded() {
  }

  @Override
  public void inputStarted() {
  }
  
}
