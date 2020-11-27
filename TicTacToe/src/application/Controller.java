package application;


import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;


public class Controller {

	  @FXML
	    private Button button1;

	    @FXML
	    private Button button2;

	    @FXML
	    private Button button3;

	    @FXML
	    private Button button4;

	    @FXML
	    private Button button5;

	    @FXML
	    private Button button6;

	    @FXML
	    private Button button7;

	    @FXML
	    private Button button8;

	    @FXML
	    private Button button9;

	    @FXML
	    private Label punkt1;

	    @FXML
	    private Label punkt2;
	    
	    @FXML
	    private Label winnerText;
	    
	    @FXML
	    private Button buttonRestart;

	    @FXML
	    private Button buttonExit;


	    @FXML
	    void exitTapped(ActionEvent event) {
	    	Platform.exit();
	    }

	    @FXML
	    void restartTapped(ActionEvent event) {
	    state = false;
	    PopupWindow.display(punkteSpieler1, punkteSpieler2, buttonList);
	    punkteSpieler1 = 0;
	    punkteSpieler2 = 0;
	    punkt1.setText(String.valueOf(punkteSpieler1));
	    punkt2.setText(String.valueOf(punkteSpieler1));

	    }

	 
	    int i = 0;
	    
	    int punkteSpieler1 = 0;
	    
	    int punkteSpieler2 = 0;
	    
	    ObservableList<Button> buttonList = FXCollections.observableArrayList();
	    ObservableList<Button> buttonList2 = FXCollections.observableArrayList();
	    boolean player1 = true;
	    
	    boolean state = false;
	    
	    int count = 0;
	    
	    public void initialize() {
	    	buttonList.add(0, button1);buttonList.add(1, button2);
	    	buttonList.add(2, button3);buttonList.add(3, button4);
	    	buttonList.add(4, button5);buttonList.add(5, button6);
	    	buttonList.add(6, button7);buttonList.add(7, button8);
	    	buttonList.add(8, button9);buttonList2.add(0, buttonRestart);
	    	buttonList2.add(1,buttonExit);
	    }

	    @FXML
	    void buttonTapped(ActionEvent event){	
	    	if(!state){
	   if(((Button)event.getSource()).getText().isEmpty() && ((Button)event.getSource()).getText().isBlank()){		    
		   		
		   		if(player1) {
				    	if(!((Button)event.getSource()).getText().equals("X"))
				    	{
				    		((Button)event.getSource()).setText("X");
				    		count++;
				    		player1 = false;
		    
		    	}
		    }else
		    	{
		    		if(!((Button)event.getSource()).getText().equals("O")) 
		    		{
		    			((Button)event.getSource()).setText("O");
		    			count++;
		    			player1 = true;
		    		}
		    	}
	  }
	    }else {
	    	endGame();
	    }
		    checkWinner();
		}
	    
	    public String checkWinner() 
	    {
	    	String winner = "";
	    
	    		for(i = 0; i < buttonList.size(); i++)
	    		{

		    		switch(i) 
		    		{
			    		// Horizontal
			    		case 0: winner = ((Button)buttonList.get(0)).getText() + ((Button)buttonList.get(1)).getText() + ((Button)buttonList.get(2)).getText();
			    		isWinner(winner); break;
			    		case 1: winner = ((Button)buttonList.get(3)).getText() + ((Button)buttonList.get(4)).getText() + ((Button)buttonList.get(5)).getText();
			    		isWinner(winner); break;
			    		case 2: winner = ((Button)buttonList.get(6)).getText() + ((Button)buttonList.get(7)).getText() + ((Button)buttonList.get(8)).getText();
			    		isWinner(winner); break;
			    		// Vertikal	
			    		case 3: winner = ((Button)buttonList.get(0)).getText() + ((Button)buttonList.get(3)).getText() + ((Button)buttonList.get(6)).getText();
			    		isWinner(winner); break;
			    		case 4: winner = ((Button)buttonList.get(1)).getText() + ((Button)buttonList.get(4)).getText() + ((Button)buttonList.get(7)).getText();
			    		isWinner(winner); break;
			    		case 5: winner = ((Button)buttonList.get(2)).getText() + ((Button)buttonList.get(5)).getText() + ((Button)buttonList.get(8)).getText();
			    		isWinner(winner); break;
			    		// Quer
			    		case 6: winner = ((Button)buttonList.get(0)).getText() + ((Button)buttonList.get(4)).getText() + ((Button)buttonList.get(8)).getText();
			    		isWinner(winner); break;
			    		case 7: winner = ((Button)buttonList.get(2)).getText() + ((Button)buttonList.get(4)).getText() + ((Button)buttonList.get(6)).getText();
			    		isWinner(winner); break;
			    		default : break;
		    		}	
			}
				return ""; 	  
	    		}
				
	    
	    public void endGame() {
	    	for (Button button : buttonList) {
	    	button.setText("");} 	  
	    	winnerText.setText("");
	    	state = false;

   }
	    public void isWinner(String winner){

	    	if(winner.equals("XXX")){
	    		state = true;
	    		punkteSpieler1 +=1;
	    		punkt1.setText(String.valueOf(punkteSpieler1));	    			    		
	    		winnerText.setText("Spieler 1 gewonnen");
	    		winnerText.setStyle("-fx-text-fill: green;");
	    		winnerText.setLayoutX(290);
	    		winnerText.setLayoutY(37);
	    		count = 0;
	    		


	    	}if(winner.equals("OOO")){ 
	    		state = true;
	    		punkteSpieler2 +=1;
	    		punkt2.setText(String.valueOf(punkteSpieler2));
	    		winnerText.setText("Spieler 2 gewonnen");
	    		winnerText.setStyle("-fx-text-fill: green;");
	    		winnerText.setLayoutX(290);
	    		winnerText.setLayoutY(37);
	    		count = 0;
	    		
	    	}if(count == buttonList.size()) {
				state = true;
			    winnerText.setText("Unentschieden");
			    winnerText.setStyle("-fx-text-fill: red;");
			    winnerText.setLayoutX(300);
			    winnerText.setLayoutY(37);
			    count = 0;
					
				}
	    		
	    
	    		
	    	
	   }
	    
	    

}