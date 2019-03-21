package assets;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class ResourceLibrary {

  private final ImageLibrary imageLibrary;
//    private SoundLibrary soundLibrary;
//    private MusicLibrary musicLibrary;

  public ResourceLibrary() throws SlickException {
    imageLibrary = new ImageLibrary();
//        soundLibrary = new SoundLibrary();
//        musicLibrary = new MusicLibrary();
    
    imageLibrary.loadImage("tile000", "data/images/dirt00.png");
    imageLibrary.loadImage("tile001", "data/images/dirt01.png");
    
    imageLibrary.loadImage("tile002", "data/images/cement.png");
  }

  public void saveImage(String key, Image image) throws SlickException {
    imageLibrary.saveImage(key, image);
  }
  
  public Image getImage(String key) {
    return getImage(key, false);
  }

  public Image getImage(String key, boolean flipped) {
    if (flipped) {
      return imageLibrary.getFlippedImage(key);
    } else {
      return imageLibrary.getImage(key);
    }
  }

//    public void playSound(String key) { soundLibrary.getSound(key).play(1f, .02f); }
//    
//    public void playMusic(String key) { musicLibrary.getMusic(key).play(1f, .20f); }
}
