package sprites;

import chara.ally.Crusader;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class CrusaderSprite {
	private Crusader crusader;
	private Canvas sprite;
	private GraphicsContext gc;
	private Image origin;
	private double time;
	private double frameTime;

	public CrusaderSprite(Crusader crusader) {
		sprite = animateCrusaderIdle();
		this.crusader = crusader;

	}

	private Canvas animateCrusaderIdle() {

		Canvas canvas = new Canvas();
		gc = canvas.getGraphicsContext2D();
		origin = new Image("crusaderIdle.png");
		canvas.setWidth(140);
		canvas.setHeight(120);

		gc.drawImage(origin, 0, 0, 61, 103, 0, 0, canvas.getWidth(), canvas.getHeight());
		return canvas;

	}

	public void attack() {
		time = 0;
		frameTime = 0;

		AnimationTimer timer = new AnimationTimer() {

			@Override
			public void handle(long arg0) {
				// TODO Auto-generated method stub
				attackHandler();

			}

		};
		timer.start();

	}

	private void attackHandler() {
		if (time < 100) {
			frameTime += 1;
			if (frameTime - time == 20) {
				gc.clearRect(0, 0, sprite.getWidth(), sprite.getHeight());
				gc.drawImage(origin, 0 + 104 * (frameTime / 20), 0, 104, 145, 0, 0, sprite.getWidth(), sprite.getHeight());
				time += 20;
				if (time==60) {
					time = 0;
					frameTime = 0;
				}
			}

		}

	}
	public Canvas getSprite() {
		return sprite;
	}
}
