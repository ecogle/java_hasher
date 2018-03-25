package application;
	




import javax.security.auth.kerberos.KerberosKey;

import javafx.application.Application;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Label title = new Label("Java Hasher");
			title.setPadding(new Insets(10));
			title.setStyle("-fx-text-fill: yellow;"+ "-fx-font-size: 16pt;");
			VBox root = new VBox();
			HBox label = new HBox();
			label.setStyle("-fx-background-color: #336699;");
			label.getChildren().add(title);
					
			label.setAlignment(Pos.BASELINE_CENTER);
			
			BorderPane gPane = new BorderPane();
			Button pickFile = new Button("Pick File");
			
			
			gPane.setStyle("-fx-background-color: lightblue;");
			FileChooser chooser = new FileChooser();
			
			pickFile.setOnAction(k -> {
				chooser.showOpenDialog(primaryStage);
			});
			
			gPane.setLeft(pickFile);
			
			
			root.getChildren().addAll(label,gPane);
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
