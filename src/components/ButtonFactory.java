package components;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;

public class ButtonFactory {

	private Button button = new Button();
	
	public ButtonFactory() {
		
	}
	
	public ButtonFactory setCaption(String s) {
		this.button.setText(s);
		return this;
	}
		
	public ButtonFactory setPadding(Insets i) {
		this.button.setPadding(i);
		return this;
	}
	
	public ButtonFactory setClickListenter(EventHandler<ActionEvent> e) {
		this.button.setOnAction(e);
		return this;
	}
	
	public Button build() {
		return this.button;
	}
}

