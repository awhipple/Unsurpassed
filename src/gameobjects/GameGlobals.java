package gameobjects;

import graphics.Camera;
import graphics.Renderer;
import input.KeysPressed;
import input.MouseState;
import ui.UIState;

public class GameGlobals {

  private final World world;
  private final UIState ui;
  private final Camera camera;
  
  KeysPressed keysPressed;
  MouseState mouseState;
  
  public GameGlobals() {
    world = new World(this);
    ui = new UIState();
    camera = new Camera(World.MAP_WIDTH * Renderer.TILE_SIZE, World.MAP_HEIGHT * Renderer.TILE_SIZE);
    
    keysPressed = new KeysPressed();
    mouseState = new MouseState();
  }

  public void update() {
    camera.update(keysPressed);
    world.update(mouseState, ui.getSelectedTile());
  }
  
  public World getWorld() {
    return world;
  }
  
  public UIState getUI() {
    return ui;
  }
  
  public Camera getCamera() {
    return camera;
  }
  
  public KeysPressed getKeysPressed() {
    return keysPressed;
  }
  
  public MouseState getMouseState() {
    return mouseState;
  }

}
