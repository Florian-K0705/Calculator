package Calculator.logic.shuntingYard;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Calculator.logic.tokenizer.*;

public class ShuntingYardConverter 
{
	private List<Token> tokenQueue = new ArrayList<>();
	
	public ShuntingYardConverter(List<Token> tokenList) throws Exception
	{
		Stack<Token> stack = new Stack<>();
		
		for (Token t : tokenList)
		{
			if (t.isNumber())
			{
				tokenQueue.add(t);
			}
			
			if (t.isFunction())
			{
				stack.add(t);
			}
			
			if (t.isOperator())
			{
				boolean loopCondition = false;
				Operator op_t;
				Operator op_stack;
				
				if (!stack.empty() && stack.lastElement().isOperator())
				{
					op_t = (Operator) t;
					op_stack = (Operator) stack.lastElement();
					
					if (op_t.isLeftAssociative() && (op_stack.getPrecedence() >= op_t.getPrecedence()))
					{
						loopCondition = true;
					}
				}

				
				while (loopCondition)
				{
					
					tokenQueue.add(stack.pop());
					
					if (!stack.empty() && stack.lastElement().isOperator())
					{
						op_t = (Operator) t;
						op_stack = (Operator) stack.lastElement();
						
						if (op_t.isLeftAssociative() && (op_stack.getPrecedence() > op_t.getPrecedence()))
						{
							loopCondition = true;
						}
						else
							loopCondition = false;
							
					}
					else
						loopCondition = false;
				}
				
				stack.push(t);
			}
			
			if (t.isOpenBracket())
			{
				stack.push(t);
			}
			
			if (t.isClosedBracket())
			{
				
				while (!stack.lastElement().isOpenBracket() && !stack.isEmpty())
				{
					tokenQueue.add(stack.pop());
				}
				
				if (stack.isEmpty())
					throw new Exception("Missing open Bracket");
				
				stack.pop();
				
				if (!stack.isEmpty() && stack.firstElement().isFunction())
					tokenQueue.add(stack.pop());
				
			}
		}
		
		while (!stack.isEmpty())
		{
			if (stack.lastElement().isOpenBracket())
				throw new Exception();
			
			tokenQueue.add(stack.pop());
		}
	}
	
	public List<Token> getTokenQueue()
	{
		return this.tokenQueue;
	}
	
}
