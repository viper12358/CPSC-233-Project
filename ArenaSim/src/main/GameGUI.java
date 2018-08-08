package main;

import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.effect.Effect;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class GameGUI extends Application {

	public int sceneHeight;
	public int sceneWidth;
	public final static double FPS = 120;
	private Scene scene;
	private Group root;
	private Map map;
	private Stage stage;
	private MapGUI mapGUI;

	Stage window;
	Scene scene1;

	public static void main(String[] args) {

		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		window = primaryStage;

		boolean gameOver = false;

		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setId("pane");
	      
		grid.setVgap(8);
		grid.setHgap(10);
		
		
		// scene.getStylesheets().add("Style.css");
		Label label1 = new Label("ARENA SIMULATOR V.1.01 ALPHA");
		label1.setTextFill(Color.web("#0076a3"));
		
		GridPane.setConstraints(label1, 25, 0);

		Button button1 = new Button("NEW GAME");
		button1.setStyle("-fx-background-color: linear-gradient(#dc9656, #ab4642)");
		
		
		GridPane.setConstraints(button1, 25, 25);
		button1.setOnAction(e -> window.setScene(scene));
		
		Button button2 = new Button("CHOOSE A STAGE");
		button2.setStyle("-fx-background-color: linear-gradient(#dc9656, #ab4642)");
		GridPane.setConstraints(button2, 25, 27);
		
		Button button3 = new Button("QUIT GAME");
		button3.setStyle("-fx-background-color: linear-gradient(#dc9656, #ab4642)");
		button3.setOnAction(e -> window.hide());
		GridPane.setConstraints(button3, 25, 29);
		
		Button button4 = new Button("Reset");
		button4.setStyle("-fx-background-color: linear-gradient(#dc9656, #ab4642)");
		button4.setOnAction(e -> primaryStage.setScene(scene));
		
		
		
		grid.getChildren().addAll(label1, button1, button2, button3);
		
		

		// Layout1
		scene1 = new Scene(grid, 850, 950);
		scene1.getStylesheets().addAll("/assets/style.css");
		
		root = new Group();
		mapGUI = new MapGUI("src/assets/map_1_1.txt", root);
		mapGUI.loadMapGUI();
		
		
		scene = new Scene(root, Color.hsb(255 * 0.0, 0, 0.5, 1));
		
		primaryStage.setTitle("Arena Sim");
		primaryStage.setScene(scene1);

		primaryStage.sizeToScene();
		primaryStage.setResizable(false);
		primaryStage.show();

//		
//		window.setScene(scene1);

		window.show();

	}

}
