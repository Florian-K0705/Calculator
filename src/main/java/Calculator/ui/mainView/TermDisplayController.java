package Calculator.ui.mainView;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class TermDisplayController implements Initializable
{
	
	@FXML
	Label termLabel;
	@FXML
	Label resultLabel;

	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		termLabel.textProperty().setValue("0");
	}

}
