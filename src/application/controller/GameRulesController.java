/**
 * Final Project
 * Team RetroStack
 */
package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * @author aidanthomas
 *
 */
public class GameRulesController implements EventHandler<ActionEvent>, Initializable{
	
	@FXML
	private Button GameBoard;
	
	@FXML
	private Label label;
	
	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		//checks to see if button was clicked
		if (event.getSource() == GameBoard) { //checks to see if the user clicks the home button
			try {
				Parent root = FXMLLoader.load(getClass().getResource("../view/GameBoard.fxml"));
				Main.stage.setScene(new Scene(root, 800, 800));
				Main.stage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		//sets the label and describes the game
		label.setText("You are the hero space craft tasked with saving your\nhome planet from the evil space crafts.\n\nYou will be given a set number of space lasers\nto defend your home world.\n\nShould your space laser count fall below the number\nof enemies present on the battlefield your home world\nwill be lost.\n");
	}

}
