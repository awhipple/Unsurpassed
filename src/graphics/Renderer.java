package graphics;

import assets.ResourceLibrary;
import gameobjects.World;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import ui.UIState;
import util.Coordinate;

public class Renderer {
  
  public static int TILE_SIZE = 80;

  private final Image mapImage;
  private final Graphics mapImageGraphics;
  private final World world;
  private final ResourceLibrary resourceLibrary;
  
  public Renderer(World world, ResourceLibrary resourceLibrary) throws SlickException {
    this.world = world;
    this.resourceLibrary = resourceLibrary;
    
    mapImage = new Image(World.MAP_WIDTH * TILE_SIZE, World.MAP_HEIGHT * TILE_SIZE);
    mapImageGraphics = mapImage.getGraphics();
    
    int[][] map = world.getMap();
    for (int x = 0; x < map.length; x++) {
      for (int y = 0; y < map[x].length; y++) {
        drawTile(resourceLibrary.getImage("tile00" + map[x][y]), x , y);
      }
    }
  }
    
  public void render(Graphics g, Camera camera, UIState ui) throws SlickException {
    Rectangle bounds = camera.getBounds();
    mapImage.draw(bounds.getX(), bounds.getY(), bounds.getWidth(), bounds.getHeight());
    
    Coordinate selectedTile = ui.getSelectedTile();
    int visualTileSize = (int)((double)bounds.getWidth() / (double)World.MAP_WIDTH);
    int selectorX = (int)(((double)selectedTile.getX() / (double)World.MAP_WIDTH) * bounds.getWidth()) + (int)bounds.getX();
    int selectorY = (int)(((double)selectedTile.getY() / (double)World.MAP_HEIGHT) * bounds.getHeight()) + (int)bounds.getY();
    Rectangle selectorRectangle = new Rectangle(selectorX, selectorY, visualTileSize, visualTileSize);
    drawSelector(g, selectorRectangle);  
  }
  
  public void update() {
    Coordinate coords = world.getUpdatedTile();
    if (coords != null) {
      drawTile(resourceLibrary.getImage("tile00" + world.getMap()[coords.getX()][coords.getY()]), coords.getX(), coords.getY());
    }      
  }
  
  private void drawSelector(Graphics g, Rectangle selector) {
    int selectorThickness = 4;
    
    g.draw(selector);
    for(int i = 0; i < selectorThickness - 1; i++) {
      selector.setBounds(selector.getX() + 1, selector.getY() + 1, selector.getWidth() - 2, selector.getHeight() - 2);
      g.draw(selector);
    }
  }
  
  private void drawTile(Image image, int x, int y) {
    mapImageGraphics.drawImage(image, x * TILE_SIZE, y * TILE_SIZE);
    mapImageGraphics.flush();
  }
  
}
