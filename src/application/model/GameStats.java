/**
 * Final Project
 * Team RetroStack
 */
package application.model;


/**
 * @author aidanthomas
 *
 */
public class GameStats {
	private static int lvl;
	private static int pts;
	private static int enm;
	
	/**
	 * sets the users game stats
	 */
	public static void setGS(int level, int points, int enemies) {
		lvl = level;
		pts = points;
		enm = enemies;
	}
	
	/**
	 * @return the lvl
	 */
	public static int getLvl() {
		return lvl;
	}
	/**
	 * @param lvl the lvl to set
	 */
	public static void setLvl(int lvl) {
		GameStats.lvl = lvl;
	}
	/**
	 * @return the pts
	 */
	public static int getPts() {
		return pts;
	}
	/**
	 * @param pts the pts to set
	 */
	public static void setPts(int pts) {
		GameStats.pts = pts;
	}
	/**
	 * @return the enm
	 */
	public static int getEnm() {
		return enm;
	}
	/**
	 * @param enm the enm to set
	 */
	public static void setEnm(int enm) {
		GameStats.enm = enm;
	}
	
}
