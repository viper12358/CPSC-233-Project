package main;

import javafx.scene.Node;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public final class UnitGUI {
	private static final double IMAGEWIDTH = 100;
	private static final double IMAGEHEIGHT = 100;
	private static Image[][] unitImages = new Image[2][4];
	private static DropShadow enemyEffect;
	private static DropShadow friendlyEffect;
	
	
	public static double getImagewidth() {
		return IMAGEWIDTH;
	}

	public static double getImageheight() {
		return IMAGEHEIGHT;
	}

	private UnitGUI() {

	}
	
	
	/**
	 * Loads the images of all the unit types, and generates the color effect for enemy or friendly units
	 */
	public static void initializeImages() {
		unitImages[0][0] = new Image("file:src/assets/melee_infantry.png", IMAGEWIDTH, IMAGEHEIGHT, false, true);
		unitImages[0][1] = new Image("file:src/assets/melee_cavalry.png", IMAGEWIDTH, IMAGEHEIGHT, false, true);
		unitImages[0][2] = new Image("file:src/assets/melee_flier.png", IMAGEWIDTH, IMAGEHEIGHT, false, true);
		unitImages[0][3] = new Image("file:src/assets/melee_armor.png", IMAGEWIDTH, IMAGEHEIGHT, false, true);
		unitImages[1][0] = new Image("file:src/assets/ranged_infantry.png", IMAGEWIDTH, IMAGEHEIGHT, false, true);
		unitImages[1][1] = new Image("file:src/assets/ranged_cavalry.png", IMAGEWIDTH, IMAGEHEIGHT, false, true);
		unitImages[1][2] = new Image("file:src/assets/ranged_flier.png", IMAGEWIDTH, IMAGEHEIGHT, false, true);
		unitImages[1][3] = new Image("file:src/assets/ranged_armor.png", IMAGEWIDTH, IMAGEHEIGHT, false, true);
	
		friendlyEffect=new DropShadow(20, Color.CORNFLOWERBLUE);
		enemyEffect = new DropShadow(20,Color.RED);
	}
	/**
	 * Adds the faction color (red for enemy, blue for friendly) to the image
	 * @param unitImage
	 * @param isFriendly
	 */
	public static void applyFactionColor(ImageView unitImage, boolean isFriendly) {
		if (isFriendly)
			unitImage.setEffect(friendlyEffect);
		else
			unitImage.setEffect(enemyEffect);
	}
	/**
	 * Returns the image that represents the given unit
	 * @param unit
	 * @return
	 */
	public static Image getUnitImage(Unit unit) {
		int rangeIndex = unit.getRange()-1;
		if(rangeIndex >1) {
			rangeIndex = 1;
		}else if(rangeIndex < 0) {
			rangeIndex = 0;
		}
		return unitImages[unit.getRange()-1][unit.getMoveType().ordinal()];
	}
	
	
	
	
	
	
}
