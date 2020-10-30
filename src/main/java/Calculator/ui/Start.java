package Calculator.ui;

import Calculator.ui.mainView.MainDisplay;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Start extends Application
{
	public static void main(String[] args) 
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		VBox root = new MainDisplay();
		
		Scene s = new Scene(root);
		primaryStage.setScene(s);
		primaryStage.show();
	}
}
