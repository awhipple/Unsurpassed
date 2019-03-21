package unsurpassed;

import gameobjects.GameState;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Unsurpassed extends BasicGame {
  
  public static final int SCREEN_W = 1920, SCREEN_H = 1080;
  private static final boolean FULLSCREEN_FLAG = false;
  private static final int TARGET_FPS = 60;

  private final GameState gs;
  
  public Unsurpassed(String gamename) throws SlickException {
    super(gamename);
    gs = new GameState();
  }

  @Override
  public void init(GameContainer gc) throws SlickException {
    gc.setAlwaysRender(true);
    gs.init(gc);
  }

  @Override
  public void update(GameContainer gc, int i) throws SlickException {
    Input input = gc.getInput();
    if (input.isKeyDown(Input.KEY_ESCAPE)) gc.exit();
    
    gs.update(input);
  }

  @Override
  public void render(GameContainer gc, Graphics g) throws SlickException {
    gs.render(g);
  }

  public static void main(String[] args) {
    try {
      AppGameContainer app = new AppGameContainer(new Unsurpassed("Unsurpassed"));
      app.setDisplayMode(SCREEN_W, SCREEN_H, FULLSCREEN_FLAG);
      app.setTargetFrameRate(TARGET_FPS);
      app.start();
    } catch (SlickException ex) {
      Logger.getLogger(Unsurpassed.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
