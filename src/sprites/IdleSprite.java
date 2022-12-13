package sprites;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class IdleSprite extends ImageView{
	public IdleSprite(String name) {
		Image img = new Image(ClassLoader.getSystemResource(name + "Idle.gif").toString());
		setImage(img);
		setSizeByName(name);
	}

	private void setSizeByName(String name) {
		// TODO Auto-generated method stub
		if(name.equals("Crusader")) {
			setFitHeight(200);
			setFitWidth(100);
		}
		if(name.equals("Priest")) {
			setFitHeight(200);
			setFitWidth(110);
		}
		if(name.equals("Ranger")) {
			setFitHeight(200);
			setFitWidth(110);
		}
		if(name.equals("Rogue")) {
			setFitHeight(200);
			setFitWidth(125);
		}
		
	}
}
