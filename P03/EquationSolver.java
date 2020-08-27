import java.util.*;

public class EquationSolver
{
    
    public double solve(String equation)
    {
	DSAQueue postfixQueue = parseInfixToPostfix(equation);
	while (!postfixQueue.isEmpty())
	{
	    System.out.println(postfixQueue.remove()); 
	}
	// double ans = evaluatePostfix(postfixQueue);
	return 0;
    }

    private DSAQueue parseInfixToPostfix(String equation)
    {
	DSACircularQueue postfixQueue;
	DSAStack opStack;
	String[] equationArray;
	int nElements;
	char curChar;

	equationArray = equation.split(" ");
	nElements = equationArray.length;

	postfixQueue = new DSACircularQueue(nElements);
	opStack = new DSAStack(nElements);

	for (int i = 0; i < nElements; i++)
	{
	    curChar = equationArray[i].charAt(0);

	    if (Character.isJavaIdentifierPart(curChar)) // is an operand
	    {
		postfixQueue.insert(curChar);
	    }
	    else if (curChar == '(')
	    {
		opStack.push(curChar);
	    }
	    else if (curChar == ')')
	    {
		while (!opStack.isEmpty() && (Character)opStack.top() != '(')
		{
		    postfixQueue.insert(opStack.pop()); // will keep popping until open bracket
		}
		opStack.pop(); // this is the opening parenthesis
	    }
	    else
	    {
		while (!opStack.isEmpty() && (Character)opStack.top() != '(' && precedenceOf(curChar) <= precedenceOf((Character)opStack.top()))
		{
		    postfixQueue.insert(opStack.pop());
		}
		opStack.push(curChar);
	    }
	}

	// popping remaining elements on the stack, and insert into the end of the queue
	while(!opStack.isEmpty())
	{
	    postfixQueue.insert(opStack.pop());
	}
	return postfixQueue;
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
