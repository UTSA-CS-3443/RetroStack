/**
 * 
 */
package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.model.GameStats;
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
public class LeaderBoardController implements EventHandler<ActionEvent>, Initializable {
	
	@FXML
	private Button returnHome;
	
	@FXML
	private Button returnGameBoard;
	
	@FXML
	private Label lvlLabel;
	
	@FXML
	private Label scoreLabel;
	
	@FXML
	private Label edLabel;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		lvlLabel.setText(String.valueOf(GameStats.getLvl()));
		scoreLabel.setText(String.valueOf(GameStats.getPts()));
		edLabel.setText(String.valueOf(GameStats.getEnm()));
	}

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		if (event.getSource() == returnHome) {
			try {
				Parent root = FXMLLoader.load(getClass().getResource("../view/Intro.fxml"));
				Main.stage.setScene(new Scene(root, 800, 800));
				Main.stage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if (event.getSource() == returnGameBoard) {
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
