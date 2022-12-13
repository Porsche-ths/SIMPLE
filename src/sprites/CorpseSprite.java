package sprites;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CorpseSprite extends ImageView {
		public CorpseSprite(String name) {
			Image img = new Image(ClassLoader.getSystemResource(name + "Corpse.gif").toString());
			setImage(img);
			setSizeByName(name);
		}
		public void setSizeByName(String name) {
			
		}
};
