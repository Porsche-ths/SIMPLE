package sprites;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CorpseSprite extends ImageView {
	public class IdleSprite extends ImageView{
		public IdleSprite(String name) {
			Image img = new Image(ClassLoader.getSystemResource(name + "Idle.gif").toString());
			setImage(img);
			//setSizeByName(name);
		}
}
