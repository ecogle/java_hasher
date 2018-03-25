package components;

import java.util.LinkedList;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class HBoxComponent extends HBox {
	
	private TextField textField = new TextField();
	private Label label = new Label();
	
	private LinkedList<TextField> textFields = new LinkedList<>();
	private LinkedList<Label> labelFields = new LinkedList<>();

	public HBoxComponent(Node... nodes) {
		super(10);
		
		for (Node node : nodes) {
			if(node instanceof Label) {
				this.label = (Label) node;
			}
			else {
				this.textField = (TextField) node;
			}
		}
		
		getChildren().addAll(nodes);
		setSpacing(10);
		setPadding(new Insets(5));
	}
	
	public TextField getTextField() {
		return this.textField;
	}
	
	public Label getLabel() {
		return this.label;
	}
	
	
}
