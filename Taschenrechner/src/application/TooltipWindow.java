package application;

import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;

public class TooltipWindow {

	
	public static Tooltip getTooltip (String message) {
		Tooltip tooltip = new Tooltip();
		
		tooltip.setText(message);
	    ImageView imageView = new ImageView(new Image("images/Attention.png"));
	    imageView.setFitHeight(20);
	    imageView.setFitWidth(20);
	    tooltip.setGraphicTextGap(5);
	    tooltip.setGraphic(imageView);
	    tooltip.setFont(Font.font(10));
	    
	    return tooltip;
	}
}
