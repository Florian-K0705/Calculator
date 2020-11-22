package Calculator.logic;

import java.util.List;
import java.util.Stack;

import Calculator.logic.shuntingYard.ShuntingYardConverter;
import Calculator.logic.tokenizer.NumberToken;
import Calculator.logic.tokenizer.Token;
import Calculator.logic.tokenizer.TokenBuilder;

public class ReversePolishNotationCalculator 
{
	private double result = 0;
	
	public ReversePolishNotationCalculator(String s) throws Exception
	{
		TokenBuilder tokenBuilder = new TokenBuilder(s);
		ShuntingYardConverter converter = 
				new ShuntingYardConverter(tokenBuilder.getTokenList());
		
		List<Token> postFixTokens = converter.getTokenQueue();
		
		for (Token t : converter.getTokenQueue())
		{
			System.out.println(t.getValue());
		}
		
		Stack<Token> stack = new Stack<>();
		
		double tmp1;
		double tmp2;
		NumberToken nt;
		
		for (Token t : postFixTokens)
		{
			if (t.isNumber())
			{
				stack.push(t);
			}
			
			if (t.isFunction())
			{
				nt = new NumberToken();
				
				tmp1 =  Double.parseDouble(stack.pop().getValue());
				
				if (t.getValue().equals("\u221A"))
					nt.setValue(String.valueOf(Math.sqrt(tmp1)));
				
				
				stack.push(nt);
			}
			
			if (t.isOperator())
			{
				tmp1 = Double.parseDouble(stack.pop().getValue());
				tmp2 = Double.parseDouble(stack.pop().getValue());
				
				nt = new NumberToken();
				
				if (t.getValue().equals("+"))
				{
					nt.setValue(String.valueOf( (double)(tmp2 + tmp1) ));
					stack.push(nt);
				}
				
				if (t.getValue().equals("-"))
				{
					nt.setValue(String.valueOf( (double)(tmp2 - tmp1) ));
					stack.push(nt);
				}
				
				if (t.getValue().equals("*"))
				{
					nt.setValue(String.valueOf( (double)(tmp2 * tmp1) ));
					stack.push(nt);
				}
				
				if (t.getValue().equals("/"))
				{
					nt.setValue(String.valueOf( (double)(tmp2 / tmp1) ));
					stack.push(nt);
				}
			}
		}
		
		
		result = Double.parseDouble(stack.pop().getValue());
		
		
	}
	
	public String getResult()
	{
		return String.valueOf(result);
	}
}
