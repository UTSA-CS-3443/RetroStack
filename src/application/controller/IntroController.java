/**
 * 
 */
package application.controller;

import application.Main;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * @author aidanthomas
 *
 */
public class IntroController implements EventHandler<ActionEvent>{
	
	@FXML
	private Button Start;
	
	@FXML
	private Label t1;
	
	@FXML
	private Label t2;
	
	@FXML
	private Label t3;
	
	@FXML
	private Label t4;
	
	@FXML
	private Label t5;
	
	@FXML
	private Label t6;
	
	@FXML
	private Label t7;
	
	@FXML
	private Label t8;
	
	@FXML
	private Label t9;
	
	@FXML
	private Label t10;
	
	public void handle(ActionEvent event) {
		if (event.getSource() == Start) { //checks to see if the user clicks the home button
			try {
				Parent root = FXMLLoader.load(getClass().getResource("../view/GameBoard.fxml"));
				Main.stage.setScene(new Scene(root, 800, 800));
				Main.stage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
