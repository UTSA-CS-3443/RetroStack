/**
 * 
 */
package application.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import application.Main;
import application.model.Board;
import application.model.GamePiece;
import javafx.scene.shape.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
//import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import java.util.Random;

/**
 * @author aidanthomas
 *
 */
public class GameBoardController implements EventHandler<ActionEvent> {
	
	Rectangle mc;
	Rectangle missle;
	Color color;
	
	@FXML
	private Button startGame;
	
	@FXML
	private Button fire;
	
	@FXML
	private Button leaderBoard;
	
	@FXML
	private Button moveRight;
	
	@FXML
	private Button moveLeft;
	
	@FXML
	private Button moveUp;
	
	@FXML
	private Button moveDown;
	
	@FXML
	GridPane boardGrid;
	
	public void handle(ActionEvent event) {
		Random rand = new Random();
		GamePiece gp = new GamePiece();
		int num1;
		int num2;
		if (event.getSource() == leaderBoard) { //checks to see if the user clicks the home button
			try {
				Parent root = FXMLLoader.load(getClass().getResource("../view/leaderBoard.fxml"));
				Main.stage.setScene(new Scene(root, 800, 800));
				Main.stage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if (event.getSource() == startGame) {
			mc = gp.GP();
			num1 = rand.nextInt(18);
			num2 = rand.nextInt(24);
			boardGrid.add(mc, num1, num2);
		}
		else if (event.getSource() == fire) {
			num1 = GridPane.getColumnIndex(mc);
			num2 = GridPane.getRowIndex(mc);
			missle = gp.spaceMissle();
			boardGrid.add(missle, num1, num2);
			int num3 = GridPane.getColumnIndex(missle);
			while (true) {
				if (event.getSource() == fire) {
					if (num3 == 36) {
						//boardGrid.getChildren().remove(missle);
						break;
					}
					else {
						GridPane.setColumnIndex(missle, num3++);
					}
				}
			}
		}
		else if (event.getSource() == moveRight) {
			num1 = GridPane.getColumnIndex(mc);
			if ((num1 >= 0) && (num1 < 36)) {
				if (num1 == 35) {
					
				}
				else {
					GridPane.setColumnIndex(mc, num1+1);
				}
			}
		}
		else if (event.getSource() == moveLeft) {
			num1 = GridPane.getColumnIndex(mc);
			if ((num1 >= 0) && (num1 < 36)) {
				if (num1 == 0) {
					
				}
				else {
					GridPane.setColumnIndex(mc, num1-1);
				}
			}
		}
		else if (event.getSource() == moveUp) {
			num2 = GridPane.getRowIndex(mc);
			if ((num2 >= 0) && (num2 < 24)) {
				if (num2 == 0) {
					
				}
				else {
					GridPane.setRowIndex(mc, num2-1);
				}
			}
		}
		else if (event.getSource() == moveDown) {
			num2 = GridPane.getRowIndex(mc);
			if ((num2 >= 0) && (num2 < 24)) {
				if (num2 == 23) {
					
				}
				else {
					GridPane.setRowIndex(mc, num2+1);
				}
			}
		}
	}
	
	/*public void initialize(URL location, ResourceBundle resources) {
		a = new Rectangle(22, 22);
		color = Color.WHITE;
		this.a.setFill(color);
		boardGrid.add(a, 5, 0);
	}*/
}
