package gameobjects;

import input.MouseState;
import java.util.Random;
import util.Coordinate;

public class World {
  public static int MAP_WIDTH = 50;
  public static int MAP_HEIGHT = 50;
  
  int[][] map;
  GameGlobals globals;
  Coordinate updatedTile;
  
  public World(GameGlobals globals) {
    this.globals = globals;
    this.updatedTile = null;
    
    Random rand = new Random();
    map = new int[MAP_WIDTH][MAP_HEIGHT];
    for (int y = 0; y < MAP_HEIGHT; y++) {
      for (int x = 0; x < MAP_WIDTH; x++) {
        map[x][y] = rand.nextInt(2);
      }
    }
  }
   
  void update(MouseState mouseState, Coordinate selectedTile) {
    if(mouseState.isButtonPressed(MouseState.LEFT_BUTTON)) {
      setTile(selectedTile, 2);
    }
    if(mouseState.isButtonPressed(MouseState.RIGHT_BUTTON) && getTile(selectedTile) == 2) {
      setTile(selectedTile, (new Random().nextInt(2)));
    }
  }
  
  public int[][] getMap() {
    return map;
  }
  
  public int getTile(Coordinate coord) {
    return map[coord.getX()][coord.getY()];
  }
  
  public void setTile(Coordinate coord, int type) {
    if(map[coord.getX()][coord.getY()] != type) {
      map[coord.getX()][coord.getY()] = type;
      updatedTile = coord;
    }
  }
  
  public Coordinate getUpdatedTile() {
    if(updatedTile != null) {
      Coordinate renderTile = updatedTile;
      updatedTile = null;
      return renderTile;
    }
    return null;
  }
}
 
