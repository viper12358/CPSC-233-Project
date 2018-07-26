/**
 * 
 */
package main;

import javafx.scene.Group;
import javafx.scene.image.ImageView;

/**
 * Class used to display the map
 * 
 * @author charl
 */
public class MapGUI {
	private ImageView[][] terrainDisplay;
	private ImageView[][] unitDisplay;
	private Group root;
 private Map map;
	public MapGUI(Map map,ImageView[][] terrainDisplay, ImageView[][] unitDisplay, Group root) {
		this.map=map;
		this.terrainDisplay = terrainDisplay;
		this.unitDisplay=unitDisplay;
		this.root=root;
		// TODO Auto-generated constructor stub
	}

	public void loadMapGUI() {
		terrainDisplay = new ImageView[map.MAXY][map.MAXY];
		unitDisplay = new ImageView[map.MAXY][map.MAXY];

		TerrainGUI.initializeImages();
		for (int y = 0; y < map.MAXY; y++) {
			for (int x = 0; x < map.MAXX; x++) {
				switch (map.getTerrainMap()[y][x]) {
				case TREE:
					terrainDisplay[y][x] = new ImageView(TerrainGUI.getTreeImage());
					break;
				case FLAT:
					terrainDisplay[y][x] = new ImageView(TerrainGUI.getFlatImage());
				default:
					break;
				}
				terrainDisplay[y][x].setX(x * TerrainGUI.getImagewidth());
				terrainDisplay[y][x].setY(y * TerrainGUI.getImageheight());
				terrainDisplay[y][x].setOnMouseClicked(new SelectedTile(x, y));
				terrainDisplay[y][x].setOnMouseEntered(new HighlightTile(terrainDisplay[y][x], true));
				terrainDisplay[y][x].setOnMouseExited(new HighlightTile(terrainDisplay[y][x], false));
				root.getChildren().add(terrainDisplay[y][x]);
			}
		}
		UnitGUI.initializeImages();
		for (int y = 0; y < map.MAXY; y++) {
			for (int x = 0; x < map.MAXX; x++) {
				if (map.getUnitMap()[y][x] != null) {
					switch (map.getUnitMap()[y][x].getMoveType()) {
					case CAVALRY:
						unitDisplay[y][x] = UnitGUI.getHorse();

						break;
					case INFANTRY:
						unitDisplay[y][x] = UnitGUI.getSword();
					default:
						break;
					}
					UnitGUI.applyFactionColor(unitDisplay[y][x], map.getUnitMap()[y][x].isFriendly());
					unitDisplay[y][x].setX(x * UnitGUI.getImagewidth());
					unitDisplay[y][x].setY(y * UnitGUI.getImageheight());
					unitDisplay[y][x].setMouseTransparent(true);
					root.getChildren().add(unitDisplay[y][x]);
				}
			}

		}

	}
}
