package graphics;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.net.URL;
import javax.imageio.ImageIO;

public class Sprite implements Serializable {
	private static final long serialVersionUID = 1L;
	private transient BufferedImage img;
	
	public Sprite(String path) {
		URL url=null;
		try
		{
			url = getClass().getClassLoader().getResource("img/" + path);
			img = ImageIO.read(url);
		}
		catch(Exception e) {
			System.out.println("Przy otwieraniu " + path +" jako " + url);
			System.out.println("Wystapil blad : " + e.getClass().getName() + "" + e.getMessage());
			System.exit(0);
			img = null;
		}
	}
	
	public BufferedImage getImage() {
		return img;
	}
}