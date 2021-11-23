/**
 * 
 */
package application.model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle; 

/**
 * @author aidanthomas
 *
 */
public class GamePiece {
	Rectangle mc;
	Rectangle missle;
	Rectangle c;
	Rectangle d;
	Color color;
	
	public Rectangle GP() {
		mc = new Rectangle(22, 22);
		color = Color.WHITE;
		this.mc.setFill(color);
		return mc;
	}
	
	public Rectangle spaceMissle() {
		missle = new Rectangle(22, 5);
		color = Color.BLUE;
		this.missle.setFill(color);
		return missle;
	}
}
