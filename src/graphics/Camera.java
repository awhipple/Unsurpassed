package graphics;

import input.KeysPressed;
import org.newdawn.slick.geom.Rectangle;
import unsurpassed.Unsurpassed;

public class Camera {

  int screenWidth, screenHeight;
  int mapWidth, mapHeight;
  float x, y;
  float zoom;
  
  public Camera(int mapWidth, int mapHeight) {
    this.screenWidth = Unsurpassed.SCREEN_W;
    this.screenHeight = Unsurpassed.SCREEN_H;
    
    this.mapWidth = mapWidth;
    this.mapHeight = mapHeight;
            
    x = 0;
    y = 0;
    
    zoom = 1;
  }
  
  public void scroll(int i) {
    zoom += 0.0005 * i;
    if(zoom < 0.05) {
      zoom = 0.05f;
    }
  }
  
  public Rectangle getBounds() {
    int drawWidth = (int)(mapWidth * zoom);
    int drawHeight = (int)(mapHeight * zoom);
    int startX = screenWidth/2 - (int)x - drawWidth/2;
    int startY = screenHeight/2 - (int)y - drawHeight/2;
    return new Rectangle(startX, startY, drawWidth, drawHeight);
  }

  public void update(KeysPressed keysPressed) {
    if(keysPressed.isKeyPressed(30)) {
      x -= 5;
    }
    
    if(keysPressed.isKeyPressed(32)) {
      x += 5;
    }
    
    if(keysPressed.isKeyPressed(17)) {
      y -= 5;
    }
    
    if(keysPressed.isKeyPressed(31)) {
      y += 5;
    }
  }
  
}
