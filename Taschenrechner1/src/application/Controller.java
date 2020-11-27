package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.MouseButton;


public class Controller {
	
	// Attribute
	
    @FXML
    private Label resultLabel; 
    
    private boolean isTyping = false;
    private boolean isDouble = false;
    private boolean ifplus = false;
	private boolean state = false;	
	
	
    private int intResult = 0;
    private double doubleResult = 0;
    private int number1 = 0;
    private double dNumber1 = 0;
    private int number2 = 0;
    private double dNumber2 = 0;
    private char operation; 
    
    Model model;
    private final Clipboard clipboard = Clipboard.getSystemClipboard();
    private final ClipboardContent content = new ClipboardContent();
    
    private final String message = "Zum kopieren der Zahlen, rechte Maustaste klicken\nZum löschen einer Zahl, linke Maustaste klicken";
      
    public void initialize(){

	    resultLabel.setTooltip(TooltipWindow.getTooltip(message));
	  
	    resultLabel.setOnMouseClicked((e) ->{
	    	int count = resultLabel.getText().length();
	    	
	    	if(e.getButton().equals(MouseButton.SECONDARY)) {
	   			content.putString(resultLabel.getText());
	   			clipboard.setContent(content);
	   		} 
	   		
	   		if(e.getButton().equals(MouseButton.PRIMARY)) {
	   			count--;
	   			StringBuilder currentValue = new StringBuilder(resultLabel.getText());
	   			
	   			if(resultLabel.getText().length() > 1) {
	   			currentValue.deleteCharAt(count);
	   			resultLabel.setText(String.valueOf(currentValue));
	   			}
	   		}
	   	});	    
    }

    @FXML
    void operationTapped(ActionEvent event) {
    	isTyping = false;
    	
    	
    	if(!resultLabel.getText().isEmpty()) { 	
		    	
		    	if(isDouble) {
		    		dNumber1 = Double.valueOf(resultLabel.getText());
		    		resultLabel.setText("");
		    		
		    	}else {		    		
		    		try {
		    		number1 = Integer.valueOf(resultLabel.getText());
		    		resultLabel.setText("");
		    		}catch(NumberFormatException e) {
		    			resultLabel.setText(resultLabel.getText().substring(0,10));
		    		}
		  
		    	}	
		    	
		    	String operationString = ((Button)event.getSource()).getText();
		    	operation = operationString.charAt(0);
		    	}
	     }
     
   
    @FXML
    void commaTapped(ActionEvent event) {
    	isDouble = true;
    	
    	if(!resultLabel.getText().isEmpty()) {
	    	double number = Double.valueOf(resultLabel.getText());
	    	String numberS = String.valueOf(number);
	    		    	
	    	if(!(""+resultLabel.getText().charAt(0)).equals("0")) {
	    	
	    		if(numberS.endsWith("0")) {
	    			numberS = numberS.replace('0', ' ');
	    			numberS = numberS.trim();
	    			numberS = numberS.replace(' ', '0');
	    			resultLabel.setText(numberS);
	    		}
	    	}else {
	    			numberS = numberS.replace('0', ' ');
	    			numberS = numberS.trim(); 
	    			numberS = numberS.replace(' ', '0');
	    			resultLabel.setText(0 + numberS);
	    		}
    	}    	
    }

    @FXML
    void equalsTapped(ActionEvent event) {
    	isTyping = false;
    	model = new Model();

    	if(!resultLabel.getText().isEmpty()) {
	    	if(isDouble) {
	    		if(dNumber1 == 0) {
	    		dNumber1 = number1;
	    		dNumber2 = Double.valueOf(resultLabel.getText());
				doubleResult = model.doubleEqual(dNumber1, dNumber2, operation);
			
				resultLabel.setText(clearResult(intResult, doubleResult));

	    		}else {
	    			dNumber2 = Double.valueOf(resultLabel.getText());
	    			doubleResult = model.doubleEqual(dNumber1, dNumber2, operation);
	    			
	    			resultLabel.setText(clearResult(intResult, doubleResult));
	    			
	    		}
	    	}else {
	    		number2 = Integer.valueOf(resultLabel.getText());
	    		intResult = model.intEqual(number1, number2, operation);
	    		resultLabel.setText(String.valueOf(intResult));
	    	}
    	} 	
    }

    @FXML
    void ifPlusTapped(ActionEvent event) {
    	ifplus = true;
    
	    String currentValue = resultLabel.getText();
		   
	    	if(!resultLabel.getText().isEmpty()) {
		    	if(ifplus && !state) {
		    		currentValue = "-" + currentValue;
		    		state = true;
		    	}else if(ifplus && state) {
		    		currentValue = currentValue.substring(1);
		    		ifplus = false;
		    		state = false;
		    	}
		    	resultLabel.setText(String.valueOf(currentValue));
	    	}
    }

    @FXML
    void restartTapped(ActionEvent event) {
    		resultLabel.setText("");
    		isDouble = false;
    }
    
    @FXML
    void numberTapped(ActionEvent event) {	
    	
    	String value = ((Button)event.getSource()).getText();
    	if(isTyping) {
    		resultLabel.setText(resultLabel.getText() + value);
    	}else {
    		resultLabel.setText(value);
    		isTyping = true;
    	}	
    }
    
    public String clearResult(int intResult, double doubleResult) {
    	String currentValue = "";
    	
    	currentValue = String.valueOf(doubleResult);
    	try {
	
    		if(currentValue.endsWith("0")) {

    	    	intResult = (int)doubleResult;
    	    	resultLabel.setText(String.valueOf(intResult));
    	    	
    	    }else {
    	    	resultLabel.setText(String.valueOf(doubleResult));
    	    } 
    	} catch (Exception e) {
			e.printStackTrace();
		
		}return resultLabel.getText();
    	
    }
}
