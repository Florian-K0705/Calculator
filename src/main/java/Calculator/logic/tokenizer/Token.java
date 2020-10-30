package Calculator.logic.tokenizer;

public interface Token
{
	String getValue();
	
	void setValue(String value);
	
	boolean isNumber();
	
	boolean isOperator();
	
	boolean isOpenBracket();
	
	boolean isClosedBracket();
	
}
