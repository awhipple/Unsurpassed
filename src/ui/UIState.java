package ui;

import util.Coordinate;

public class UIState {

  Coordinate selectedTile;
  Coordinate mousePosition;
  
  public UIState() {
    selectedTile = new Coordinate(4, 4);
    mousePosition = new Coordinate(500, 500);
  }
  
  public Coordinate getSelectedTile() {
    return selectedTile;
  }
  
  public Coordinate getMousePosition() {
    return mousePosition;
  }
  
  public void setMousePosition(int x, int y) {
    mousePosition.set(x, y);
  }
  
}
