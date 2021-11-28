/**
 * 
 */
package application.controller;

import application.Main;
import application.model.GamePiece;
import javafx.scene.shape.*;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import java.util.Random;
import java.lang.Thread;

/**
 * @author aidanthomas
 *
 */
public class GameBoardController extends Thread {
	Color color;
	int enCount = 0;
	int mCount = 0;
	int totmCount = 0;
	int count = 0;
	int sc = 0;
	int lvl = 1;
	int dCount = 0;
	GamePiece gp = new GamePiece();
	
	@FXML
	private Button startGame;
	
	@FXML
	private Rectangle grid;
	
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
	private Button attack;
	
	@FXML
	GridPane boardGrid;
	
	@FXML
	private MediaView mp3;
	
	@FXML
	private Label score;
	
	@FXML
	private Label missleCount;
	
	@FXML
	private Label level;
	
	public void handle1(ActionEvent event) {
		Random rand = new Random();
		int num1;
		int num2;
		if (event.getSource() == leaderBoard) { //checks to see if the user clicks the home button
			/*try {
				Parent root = FXMLLoader.load(getClass().getResource("../view/leaderBoard.fxml"));
				Main.stage.setScene(new Scene(root, 800, 800));
				Main.stage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}*/
		}
		else if ((event.getSource() == startGame) && (count < 1)) {
			gp.GP();
			System.out.println(boardGrid.getColumnCount() + "," + boardGrid.getRowCount());
			num1 = rand.nextInt(17);
			num2 = rand.nextInt(27);
			boardGrid.add(gp.getMc(), num1, num2);
			System.out.println(boardGrid.getColumnCount() + "," + boardGrid.getRowCount());
			int i = 0;
			int num = 8;
			enCount = num;
			gp.EGP();
			while (i < num) {
				num1 = rand.nextInt(36-18) + 18;
				num2 = rand.nextInt(27);
				boardGrid.add(gp.getRc().get(i), num1, num2);
				i++;
			}
			System.out.println(boardGrid.getColumnCount() + "," + boardGrid.getRowCount());
			count++;
			totmCount = 16;
			missleCount.setText(String.valueOf(totmCount));
			level.setText(String.valueOf(lvl));
			score.setText(String.valueOf(sc));
		}
		else if ((event.getSource() == fire) && (count == 1) && (mCount == 0)) {
			num1 = GridPane.getColumnIndex(gp.getMc());
			num2 = GridPane.getRowIndex(gp.getMc());
			gp.spaceMissle();
			boardGrid.add(gp.getMissle(), num1+1, num2);
			mCount = 1;
		}
		else if ((event.getSource() == attack) && (count == 1) && (mCount == 1)) {
			num1 = GridPane.getColumnIndex(gp.getMissle());
			num2 = GridPane.getRowIndex(gp.getMissle());
			enCount = gp.getRc().size();
			if (num1 == 35) {
				int i = 0;
				while (i < gp.getRc().size()) {
					int num3 = GridPane.getColumnIndex(gp.getRc().get(i));
					int num4 = GridPane.getRowIndex(gp.getRc().get(i));
					if ((num1 == num3) && (num2 == num4)) {
						boardGrid.getChildren().remove(gp.getMissle());
						boardGrid.getChildren().remove(gp.getRc().get(i));
						gp.getRc().remove(i);
						mCount = 0;
						enCount = gp.getRc().size();
						sc += 25;
						score.setText(String.valueOf(sc));
						totmCount -= 1;
						missleCount.setText(String.valueOf(totmCount));
						dCount += 1;
						System.out.println(enCount);
						if ((enCount == 0) && (totmCount > 0)) {
							lvl += 1;
							level.setText(String.valueOf(lvl));
							if (lvl == 2) {
								totmCount = 14;
							}
							else if (lvl == 3) {
								totmCount = 12;
							}
							else if (lvl == 4) {
								totmCount = 10;
							}
							else if (lvl > 4) {
								totmCount = 8;
							}
							missleCount.setText(String.valueOf(totmCount));
							i = 0;
							int num = 8;
							enCount = num;
							gp.EGP();
							while (i < num) {
								num1 = rand.nextInt(36-18) + 18;
								num2 = rand.nextInt(27);
								boardGrid.add(gp.getRc().get(i), num1, num2);
								i++;
							}
						}
						break;
					}
					else {
						i++;
						continue;
					}
				}
				if (mCount == 1) {
					boardGrid.getChildren().remove(gp.getMissle());
					mCount = 0;
					totmCount-=1;
					missleCount.setText(String.valueOf(totmCount));
				}
			}
			else if ((enCount > 0) && (totmCount < enCount)) {
				try {
					Parent root = FXMLLoader.load(getClass().getResource("../view/leaderBoard.fxml"));
					Main.stage.setScene(new Scene(root, 800, 800));
					Main.stage.show();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			else {
				int i = 0;
				while (i < gp.getRc().size()) {
					int num3 = GridPane.getColumnIndex(gp.getRc().get(i));
					int num4 = GridPane.getRowIndex(gp.getRc().get(i));
					enCount = gp.getRc().size();
					if ((num1 == num3) && (num2 == num4)) {
						boardGrid.getChildren().remove(gp.getMissle());
						boardGrid.getChildren().remove(gp.getRc().get(i));
						gp.getRc().remove(i);
						mCount = 0;
						dCount += 1;
						enCount = gp.getRc().size();
						sc += 25;
						score.setText(String.valueOf(sc));
						totmCount -= 1;
						missleCount.setText(String.valueOf(totmCount));
						System.out.println(enCount);
						if (enCount == 0 && totmCount > 0) {
							lvl += 1;
							level.setText(String.valueOf(lvl));
							if (lvl == 2) {
								totmCount = 14;
							}
							else if (lvl == 3) {
								totmCount = 12;
							}
							else if (lvl == 4) {
								totmCount = 10;
							}
							else if (lvl > 4) {
								totmCount = 8;
							}
							missleCount.setText(String.valueOf(totmCount));
							i = 0;
							int num = 8;
							enCount = num;
							gp.EGP();
							while (i < num) {
								num1 = rand.nextInt(36-18) + 18;
								num2 = rand.nextInt(27);
								boardGrid.add(gp.getRc().get(i), num1, num2);
								i++;
							}
						}
						else if ((enCount > 0) && (totmCount < enCount)) {
							try {
								Parent root = FXMLLoader.load(getClass().getResource("../view/leaderBoard.fxml"));
								Main.stage.setScene(new Scene(root, 800, 800));
								Main.stage.show();
							} catch(Exception e) {
								e.printStackTrace();
							}
						}
						break;
					}
					else {
						GridPane.setColumnIndex(gp.getMissle(), num1+1);
					}
					i++;
				}
			}
		}
		else if ((event.getSource() == moveRight) && (count == 1)) {
			num1 = GridPane.getColumnIndex(gp.getMc());
			if (num1 < 35) {
				GridPane.setColumnIndex(gp.getMc(), num1+1);
			}
		}
		else if ((event.getSource() == moveLeft) && (count == 1)) {
			num1 = GridPane.getColumnIndex(gp.getMc());
			if (num1 > 0) {
				GridPane.setColumnIndex(gp.getMc(), num1-1);
			}
		}
		else if ((event.getSource() == moveUp) && (count == 1)) {
			num2 = GridPane.getRowIndex(gp.getMc());
			if (num2 > 0) {
				GridPane.setRowIndex(gp.getMc(), num2-1);
			}
		}
		else if ((event.getSource() == moveDown) && (count == 1)) {
			num2 = GridPane.getRowIndex(gp.getMc());
			if (num2 < 26) {
				GridPane.setRowIndex(gp.getMc(), num2+1);
			}
		}
	}
}
