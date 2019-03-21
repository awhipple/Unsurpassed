package gameobjects;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import input.GameKeyListener;
import input.GameMouseListener;
import input.KeysPressed;
import assets.ResourceLibrary;
import graphics.Renderer;
import input.MouseState;
import org.newdawn.slick.GameContainer;

public class GameState {

  ResourceLibrary resourceLibrary;
  GameGlobals globals;
  Renderer renderer;
  KeysPressed keysPressed;
  MouseState mouseState;
  
  public GameState() { }

  public void init(GameContainer gc) throws SlickException {
    globals = new GameGlobals();
    
    resourceLibrary = new ResourceLibrary();
    renderer = new Renderer(globals.getWorld(), resourceLibrary);
        
    gc.getInput().addMouseListener(new GameMouseListener(globals));
    gc.getInput().addKeyListener(new GameKeyListener(globals));
  }

  public void update(Input input) {
    globals.update();
    renderer.update();
  }

  public void render(Graphics g) throws SlickException {
    renderer.render(g, globals.getCamera(), globals.getUI());
  }

}
