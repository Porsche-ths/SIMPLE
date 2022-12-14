package sprites;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AttackedSprite extends ImageView {
	public AttackedSprite(String name) {
		Image img = new Image(ClassLoader.getSystemResource(name + "Attacked.gif").toString());
		setImage(img);
		setSizeByName(name);
	}

	private void setSizeByName(String name) {
		// TODO Auto-generated method stub
		if(name.equals("skellySoldier")) {
			setFitHeight(180);
			setFitWidth(130);
		}
		if(name.equals("Crusader")) {
			setFitHeight(180);
			setFitWidth(130);
		}
		if(name.equals("Priest")) {
			setFitHeight(180);
			setFitWidth(130);
		}
		if(name.equals("Rogue")) {
			setFitHeight(180);
			setFitWidth(100);
		}
		if(name.equals("hemomancer")) {
			setFitHeight(300);
			setFitWidth(320);
		}
		if(name.equals("executioner")) {
			setFitHeight(220);
			setFitWidth(280);
		}
		if(name.equals("Ranger")) {
			setFitHeight(180);
			setFitWidth(130);
		}
		if(name.equals("skellyArcher")) {
			setFitHeight(200);
			setFitWidth(130);
		}
		
	}
}
