package input;

import gameobjects.GameGlobals;
import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;

public class GameKeyListener implements KeyListener {

  GameGlobals globals;
  
  public GameKeyListener(GameGlobals globals) {
    this.globals = globals;
  }
  
  @Override
  public void keyPressed(int i, char c) {
    globals.getKeysPressed().setKeyPressed(i, true);
  }

  @Override
  public void keyReleased(int i, char c) {
    globals.getKeysPressed().setKeyPressed(i, false);
  }

  @Override
  public void setInput(Input input) {
//    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public boolean isAcceptingInput() {
//    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    return true;
  }

  @Override
  public void inputEnded() {
//    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void inputStarted() {
//    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
  
}
