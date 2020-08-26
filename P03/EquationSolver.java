import java.util.*;

public class EquationSolver
{
    
    public double solve(String equation)
    {
	DSAQueue postfixQueue = parseInfixToPostfix(equation);
	double ans = evaluatePostfix(postfixQueue);
	return ans;
    }

    private DSAQueue parseInfixToPostfix(String equation)
    {
	String openBracket = "(";
	String closeBracket = ")";


	DSACircularQueue queueOfPostfix;
	DSAStack stackOfOperators;
	String[] equationArray;
	int size;
	String term;


	equationArray = equation.split(" ");
	size = equationArray.length;

	queueOfPostfix = new DSACircularQueue(size);
	stackOfOperators = new DSAStack(size);

	for (int i = 0; i < size; i++)
	{
	    term = equationArray[i];

	    if (term.equals(openBracket))
	    {
		stackOfOperators.push(term);
	    }
	    else if (term.equals(closeBracket))
	    {
		while (!stackOfOperators.top().equals(openBracket))
		{
		    queueOfPostfix.insert(stackOfOperators.pop());
		}
		stackOfOperators.pop();
	    }
	    if ("+-*/".contains(term))
	    {
		while (!stackOfOperators.isEmpty() && 
		    !stackOfOperators.top().equals(openBracket) &&
			(precedenceOf(stackOfOperators.top().toString().charAt(0))
			 >= precedenceOf(term.charAt(0))))
		{
		    queueOfPostfix.insert(stackOfOperators.pop());
		}
		stackOfOperators.push(term);
	    }
	    else
	    {
		queueOfPostfix.insert(Double.valueOf(term));
	    }
	}

	while(!stackOfOperators.isEmpty())
	{
	    queueOfPostfix.insert(stackOfOperators.pop());
	}
	return queueOfPostfix;
    }

    private double evaluatePostfix(DSAQueue postfixQueue)
    {
	DSAStack stackOfOperators;
	char op;
	double op1, op2;

	stackOfOperators = new DSAStack(postfixQueue.size());
	while(!postfixQueue.isEmpty())
	{
	    if (postfixQueue.peek() instanceof Double)
	    {
		stackOfOperators.push(postfixQueue.remove());
	    }
	    else
	    {
		op2 = (double) stackOfOperators.pop();
		op1 = (double) stackOfOperators.pop();
		op = postfixQueue.remove().toString().charAt(0);
		stackOfOperators.push(executeOperation(op, op1, op2));
	    }
	}
	return (double)stackOfOperators.pop();
    }

    // precedence
    // ( * / ) > ( + - )
    private int precedenceOf(char theOp)
    {
	int precedence;

	if(theOp == '+' || theOp == '-') 
	{
	    precedence = 1;
	}
	else if (theOp == '*' || theOp == '/')
	{
	    precedence = 2;
	}
	else
	{
	    throw new IllegalArgumentException("Unknown operator: ("
		    + theOp + "), in precedenceOf");
	}
	return precedence;
    }

    private double executeOperation(char op, double op1, double op2)
    {
	double ans;

	switch(op)
	{
	    case '+':
		ans = op1 + op2;
		break;
	    case '-':
		ans = op1 - op2;
		break;
	    case '*':
		ans = op1 * op2;
		break;
	    case '/':
		ans = op1 / op2;
		break;
	    default:
		throw new IllegalArgumentException("Unknown operator: ("
			+ op + "), in executeOperation");
	}
	return ans;
    }


}
