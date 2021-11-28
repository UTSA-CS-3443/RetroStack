/**
 * 
 */
package application.model;

import java.util.ArrayList;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle; 

/**
 * @author aidanthomas
 *
 */
public class GamePiece {
	ArrayList<Rectangle> rc = new ArrayList<Rectangle>();
	Rectangle mc;
	Rectangle missle;
	Rectangle em;
	Color color;
	
	public void GP() {
		mc = new Rectangle(20, 20);
		color = Color.WHITE;
		this.mc.setFill(color);
		//return mc;
	}
	
	public void spaceMissle() {
		missle = new Rectangle(20, 5);
		color = Color.BLUE;
		this.missle.setFill(color);
	}
	
	public void EGP() {
		int i = 0;
		int num = 8;
		while (i < num) {
			em = new Rectangle(20, 20);
			color = Color.RED;
			this.em.setFill(color);
			addRc(em);
			i++;
		}
	}
	
	public void addRc(Rectangle rcP) {
		rc.add(rcP);
	}

	/**
	 * @return the rc
	 */
	public ArrayList<Rectangle> getRc() {
		return rc;
	}

	/**
	 * @param rc the rc to set
	 */
	public void setRc(ArrayList<Rectangle> rc) {
		this.rc = rc;
	}

	/**
	 * @return the mc
	 */
	public Rectangle getMc() {
		return mc;
	}

	/**
	 * @param mc the mc to set
	 */
	public void setMc(Rectangle mc) {
		this.mc = mc;
	}

	/**
	 * @return the missle
	 */
	public Rectangle getMissle() {
		return missle;
	}

	/**
	 * @param missle the missle to set
	 */
	public void setMissle(Rectangle missle) {
		this.missle = missle;
	}

	/**
	 * @return the em
	 */
	public Rectangle getEm() {
		return em;
	}

	/**
	 * @param em the em to set
	 */
	public void setEm(Rectangle em) {
		this.em = em;
	}

	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	
	
}
