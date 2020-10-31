package Calculator.ui.mainView;

import java.net.URL;
import java.util.ResourceBundle;

import Calculator.logic.ReversePolishNotationCalculator;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class KeyPadController implements Initializable
{
	
	StringProperty termStringProperty = new SimpleStringProperty();
	StringProperty resultStringProperty = new SimpleStringProperty();
	private StringBuilder builder = new StringBuilder();
	
	@FXML
	Button number0;
	@FXML
	Button number1;
	@FXML
	Button number2;
	@FXML
	Button number3;
	@FXML
	Button number4;
	@FXML
	Button number5;
	@FXML
	Button number6;
	@FXML
	Button number7;
	@FXML
	Button number8;
	@FXML
	Button number9;
	@FXML
	Button add;
	@FXML
	Button sub;
	@FXML
	Button mul;
	@FXML
	Button div;
	@FXML
	Button openBracket;
	@FXML
	Button closedBracket;
	@FXML
	Button equal;
	@FXML
	Button ce;
	@FXML
	Button dot;

	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		number0.setOnAction(value -> {builder.append("0"); termStringProperty.setValue(builder.toString());});
		number1.setOnAction(value -> {builder.append("1"); termStringProperty.setValue(builder.toString());});
		number2.setOnAction(value -> {builder.append("2"); termStringProperty.setValue(builder.toString());});
		number3.setOnAction(value -> {builder.append("3"); termStringProperty.setValue(builder.toString());});
		number4.setOnAction(value -> {builder.append("4"); termStringProperty.setValue(builder.toString());});
		number5.setOnAction(value -> {builder.append("5"); termStringProperty.setValue(builder.toString());});
		number6.setOnAction(value -> {builder.append("6"); termStringProperty.setValue(builder.toString());});
		number7.setOnAction(value -> {builder.append("7"); termStringProperty.setValue(builder.toString());});
		number8.setOnAction(value -> {builder.append("8"); termStringProperty.setValue(builder.toString());});
		number9.setOnAction(value -> {builder.append("9"); termStringProperty.setValue(builder.toString());});
		
		add.setOnAction(value -> {builder.append("+"); termStringProperty.setValue(builder.toString());});
		sub.setOnAction(value -> {builder.append("-"); termStringProperty.setValue(builder.toString());});
		mul.setOnAction(value -> {builder.append("*"); termStringProperty.setValue(builder.toString());});
		div.setOnAction(value -> {builder.append("/"); termStringProperty.setValue(builder.toString());});
		
		openBracket.setOnAction(value -> {builder.append("("); termStringProperty.setValue(builder.toString());});
		closedBracket.setOnAction(value -> {builder.append(")"); termStringProperty.setValue(builder.toString());});
		
		ce.setOnAction(value -> {builder.delete(0, builder.length()); termStringProperty.setValue("0");});
		equal.setOnAction(value -> {resultStringProperty.setValue(new ReversePolishNotationCalculator(builder.toString()).getResult());});
		dot.setOnAction(value -> {builder.append("."); termStringProperty.setValue(builder.toString());});
	}

	
}
