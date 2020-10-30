package Calculator.logic.tokenizer;

public class Bracket implements Token
{
	
	private String value = "";

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
		return false;
	}

	@Override
	public boolean isOpenBracket() {
		return value.equals("(");
	}

	@Override
	public boolean isClosedBracket() {
		return !isOpenBracket();
	}
	
}
