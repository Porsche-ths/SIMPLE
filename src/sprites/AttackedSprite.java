package sprites;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AttackedSprite extends ImageView {
	public AttackedSprite(String name) {
		Image img = new Image(ClassLoader.getSystemResource(name + "Attacked.gif").toString());
		setImage(img);
		//setSizeByName(name);
	}
}
