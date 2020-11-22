package Calculator.logic.tokenizer;

public class NumberToken implements Token
{
	private String value = "";
	
	@Override
	public String getValue()
	{
		return value;
	}

	@Override
	public void setValue(String value) 
	{
		this.value = value;
	}

	@Override
	public boolean isNumber() {
		return true;
	}

	@Override
	public boolean isOperator() {
		return false;
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
