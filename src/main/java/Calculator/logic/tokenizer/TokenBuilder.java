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
				
				if (i+2 < s.length())
				{
					if (s.substring(i, i+2).equals("ln"))
					{
						tmpToken = new Function();
						tmpToken.setValue("ln");
						tokenList.add(tmpToken);
					}
					else if (s.substring(i, i+2).equals("lg"))
					{
						tmpToken = new Function();
						tmpToken.setValue("lg");
						tokenList.add(tmpToken);
					}
				}
				else if (i+3 < s.length())
				{
					if (s.substring(i, i+3).equals("sin"))
					{
						tmpToken = new Function();
						tmpToken.setValue("sin");
						tokenList.add(tmpToken);
					}
					else if (s.substring(i, i+3).equals("cos"))
					{
						tmpToken = new Function();
						tmpToken.setValue("cos");
						tokenList.add(tmpToken);
					}
					else if (s.substring(i, i+3).equals("tan"))
					{
						tmpToken = new Function();
						tmpToken.setValue("tan");
						tokenList.add(tmpToken);
					}
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
				
				if (tmp == 'e')
				{
					tmpToken = new NumberToken();
					tmpToken.setValue(String.valueOf(Math.E));
					tokenList.add(tmpToken);
				}
				
				if (tmp == '\u03C0')
				{
					tmpToken = new NumberToken();
					tmpToken.setValue(String.valueOf(Math.PI));
					tokenList.add(tmpToken);
				}
				
				if ((tmp == '+') || (tmp == '-') || (tmp == '*') || (tmp == '/'))
				{
					tmpToken = new Operator();
					tmpToken.setValue(String.valueOf(tmp));
					tokenList.add(tmpToken);
				}
				
				if (tmp == '\u221A')
				{
					tmpToken = new Function();
					tmpToken.setValue(String.valueOf(tmp));
					tokenList.add(tmpToken);
				}
				
				if (tmp == '^')
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
