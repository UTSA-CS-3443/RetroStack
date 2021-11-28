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

public class GameRulesController implements EventHandler<ActionEvent>, Initializable{
	
	@FXML
	private Button GameBoard;
	
	@FXML
	private Label label;
	
	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
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
		label.setText("You are the hero sprite tasked with saving your\nhome planet from the evil sprites.\nYou will be given a set number of space lasers\nto defend your home world.\nShould your space laser count fall\nbelow the number of enemies present on the battlefield\nyour home world will be lost.\n");
	}

}
