package application;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PopupWindow {

	public static void display(int player1, int player2, ObservableList<Button> buttonList) {
		
		Stage stage = new Stage();
		
		Label label = new Label();
		label.setStyle("-fx-font-style: normal;"
				+ "-fx-font-size: 20;");
		Button button = new Button("Schließen");
		button.setStyle("-fx-font-size: 15;");

		if(player1 > player2) {
			label.setText("Spieler 1 hat gewonnen");
		}else if(player1 < player2) {
			label.setText("Spieler 2 hat gewonnen");

		}else if (player1 == player2){
			label.setText("Unentschieden");
		}
		
				button.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
				for (Button button : buttonList) {
					button.setText("");
				}
				stage.close();
				
			} 	
		});
		VBox root = new VBox(20);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(label, button);
		
		Scene scene = new Scene(root,300,150);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.showAndWait();
	}
}
