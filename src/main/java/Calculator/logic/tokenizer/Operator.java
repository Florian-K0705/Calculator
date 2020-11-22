package Calculator.logic.tokenizer;

public class Operator implements Token
{

	private String value = "";
	
	public boolean isLeftAssociative()
	{
		if (value.equals("^"))
			return false;
		
		if (value.equals("+") || value.equals("-") || value.equals("*") || value.equals("/"));
			return true;
	}
	
	public int getPrecedence()
	{
		if (value.equals("+") || value.equals("-"))
		{
			return 0;
		}
		else if (value.equals("*") || value.equals("/"))
		{
			return 1;
		}
		else
			return 2;
	}
	
	@Override
	public String getValue() {
		return value;
	}

	@Override
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public boolean isNumber() {
		return false;
	}

	@Override
	public boolean isOperator() {
		return true;
	}

	@Override
	public boolean isOpenBracket() {
		return false;
	}

	@Override
	public boolean isClosedBracket() {
		return false;
	}

	@Override
	public boolean isFunction() {
		return false;
	}

}
