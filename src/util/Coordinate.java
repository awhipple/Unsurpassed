package util;

public class Coordinate {

  private int x;
  private int y;
  
  public Coordinate() {
    x = 0;
    y = 0;
  }
  
  public Coordinate(int x, int y) {
    this.x = x;
    this.y = y;
  }
  
  public void set(int x, int y) {
    this.x = x;
    this.y = y;
  }
  
  public int getX() {
    return x;
  }
  
  public int getY() {
    return y;
  }
  
}
