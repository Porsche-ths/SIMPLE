package sprites;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CorpseSprite extends ImageView {
		public CorpseSprite(String name) {
			Image img = new Image(ClassLoader.getSystemResource(name + "Corpse.png").toString());
			setImage(img);
			setSizeByName(name);
		}
		private void setSizeByName(String name) {
			// TODO Auto-generated method stub
			if(name.equals("skellySoldier")) {
				setFitHeight(180);
				setFitWidth(200);
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
				setFitHeight(150);
				setFitWidth(200);
			}
			if(name.equals("executioner")) {
				setFitHeight(150);
				setFitWidth(200);
			}
			if(name.equals("Ranger")) {
				setFitHeight(180);
				setFitWidth(130);
			}
			if(name.equals("skellyArcher")) {
				setFitHeight(150);
				setFitWidth(170);
			}
			
			
		}
};
