package Calculator.ui.mainView;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Separator;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class MainDisplay extends VBox
{
	public MainDisplay()
	{
		GridPane keyPad;
		VBox termDisplay;
		FXMLLoader keyPadLoader;
		FXMLLoader termDisplayLoader;
		KeyPadController keyPadController;
		TermDisplayController termDisplayController;
		
		try {
			keyPadLoader = new FXMLLoader(getClass().getResource("KeyPad.fxml"));
			termDisplayLoader = new FXMLLoader(getClass().getResource("TermDisplay.fxml"));
			
			keyPad = keyPadLoader.load();
			termDisplay = termDisplayLoader.load();
			
			keyPadController = keyPadLoader.getController();
			termDisplayController = termDisplayLoader.getController();
			
			termDisplayController.termLabel.textProperty().bindBidirectional(keyPadController.termStringProperty);
			termDisplayController.resultLabel.textProperty().bindBidirectional(keyPadController.resultStringProperty);
			
		} catch (IOException e) {
			keyPad = new GridPane();
			termDisplay = new VBox();
			e.printStackTrace();
			termDisplayController = null;
			keyPadController = null;
		}
		
		Separator sp = new Separator();
		
		this.getChildren().addAll(termDisplay, sp, keyPad);
	}
}
