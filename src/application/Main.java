package application;

import java.io.File;

import org.apache.commons.codec.digest.DigestUtils;

import components.ButtonFactory;
import components.HBoxComponent;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
public class Main extends Application {
	private File file = null;
	
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
			
			HBox fileChooser = new HBox(10);
			
			fileChooser.setPadding(new Insets(10));
			Button pickFile = new Button("Pick File");
			pickFile.setStyle("-fx-set-spacing: 3pt;");
			
			
			FileChooser chooser = new FileChooser();
			
			TextField fileText = new TextField();
			fileText.setEditable(false);
			//HBox hashBox = new HBox();
			HBoxComponent hashBox1 = new HBoxComponent(new Label("Sha1:"),new TextField());
			
			
//			Label hashLabel = new Label("Sha1: ");
//			TextField hash = new TextField();
//			hash.setEditable(false);
			HBox md5Box = new HBox();
			md5Box.setPadding(new Insets(10));
			TextField md5htxt = new TextField();
			Label md5lbl = new Label("MD5: ");
			md5htxt.setEditable(false);
			md5Box.getChildren().addAll(md5lbl,md5htxt);
			
			pickFile.setOnAction(k -> {
				file=chooser.showOpenDialog(primaryStage);
				System.out.println(file);
				if(file != null) {
					fileText.setText(file.toString());
					fileText.setMinWidth(file.toString().length()*7);					
					hashBox1.getTextField().setText(DigestUtils.sha1Hex(file.toString()));
					hashBox1.getTextField().setMinWidth(hashBox1.getTextField().getText().length()*7);
					md5htxt.setText(DigestUtils.md5Hex(file.toString()));
					md5htxt.setMinWidth(md5htxt.getText().length()*7);
				}
				
			});
			
			
			
			//hashBox1.getChildren().addAll(hashLabel,hash);
			fileChooser.getChildren().addAll(pickFile,fileText);
			root.getChildren().addAll(label,fileChooser,hashBox1,md5Box);
			Scene scene = new Scene(root,800,600);
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
