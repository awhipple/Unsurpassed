package assets;

import java.util.HashMap;
import java.util.Map;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class ImageLibrary {

  Map<String, ImageCache> imageMap;

  public ImageLibrary() {
    imageMap = new HashMap<>();
  }

  public void loadImage(String key, String fileName) throws SlickException {

    if (imageMap.containsKey(key)) {
      throw new SlickException("ERROR: Tried to load an image and save it under pre existing key: " + key);
    }

    imageMap.put(key, new ImageCache(new Image(fileName)));
  }
  
  public void saveImage(String key, Image image) throws SlickException {
    if (imageMap.containsKey(key)) {
      throw new SlickException("ERROR: Tried to load an image and save it under pre existing key: " + key);
    }
    
    imageMap.put(key, new ImageCache(image));
  }

  public Image getImage(String key) {
    return imageMap.get(key).getBaseImage();
  }

  public Image getFlippedImage(String key) {
    return imageMap.get(key).getFlippedImage();
  }

  private class ImageCache {

    Image baseImage, flippedImage;

    public ImageCache(Image baseImage) throws SlickException {
      this.baseImage = baseImage;
      flippedImage = null;
    }

    public Image getBaseImage() {
      return baseImage;
    }

    public Image getFlippedImage() {
      if (flippedImage == null) {
        flippedImage = baseImage.getFlippedCopy(true, true);
      }
      return flippedImage;
    }
  }

}
