package Calculator.logic.tokenizer;

import java.util.ArrayList;
import java.util.List;

public class TokenBuilder
{
	private List<Token> tokenList = new ArrayList<>();
	
	public TokenBuilder(String s)
	{
		StringBuilder builder = new StringBuilder();
		Token tmpToken;
		char tmp;
		
		for (int i=0; i<s.length(); i++)
		{
			tmp = s.charAt(i);
			
			if (Character.isDigit(tmp) || tmp=='.')
			{
				builder.append(tmp);
			}
			else
			{
				if (builder.length() > 0)
				{
					tmpToken = new NumberToken();
					tmpToken.setValue(builder.toString());
					tokenList.add(tmpToken);
					
					builder.delete(0, builder.length());
				}
				
				if (tmp == '(')
				{
					tmpToken = new Bracket();
					tmpToken.setValue("(");
					tokenList.add(tmpToken);
				}
				
				if (tmp == ')')
				{
					tmpToken = new Bracket();
					tmpToken.setValue(")");
					tokenList.add(tmpToken);
				}
				
				if ((tmp == '+') || (tmp == '-') || (tmp == '*') || (tmp == '/'))
				{
					tmpToken = new Operator();
					tmpToken.setValue(String.valueOf(tmp));
					tokenList.add(tmpToken);
				}
			}
		}
		
		if (builder.length() > 0)
		{
			tmpToken = new NumberToken();
			tmpToken.setValue(builder.toString());
			tokenList.add(tmpToken);
			
			builder.delete(0, builder.length());
		}
	}
	
	public List<Token> getTokenList()
	{
		return tokenList;
	}
}
