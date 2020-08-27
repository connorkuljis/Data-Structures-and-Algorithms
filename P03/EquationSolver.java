import java.util.*;

public class EquationSolver
{
    
    public double solve(String equation)
    {
	DSAQueue postfixQueue;
	double ans;

        postfixQueue = parseInfixToPostfix(equation); // convert our equation to postfix (as a Queue)
	ans = evaluatePostfix(postfixQueue); // given our postfix queue, solve it and return answer (real number)

	return ans;
    }

    private DSAQueue parseInfixToPostfix(String equation)
    {
	DSACircularQueue postfixQueue;
	DSAStack opStack;
	String ce;
	char ch;

	StringTokenizer eq = new StringTokenizer(equation, " ");

	postfixQueue = new DSACircularQueue(eq.countTokens());
	opStack = new DSAStack(eq.countTokens());

	while(eq.hasMoreTokens())
	{
	    ce = eq.nextToken();
	    ch = ce.charAt(0);
	    switch (ch)
	    {
		case '+': case '-': case '*': case '/':
		    while (!opStack.isEmpty() && (Character)opStack.top() != '(' &&
			    precedenceOf((Character)opStack.top()) >= precedenceOf(ch))
		    {
			postfixQueue.insert(opStack.pop());
		    }
		    opStack.push(ch);
		    break;

		case '(':
		    opStack.push(ch);
		    break;
		
		case ')':
		    while ((Character)opStack.top() != '(')
		    {
			postfixQueue.insert(opStack.pop());
		    }
		    opStack.pop();
		    break;

		default:
		    postfixQueue.insert(Double.valueOf(ce));
		    break;
	    }
	}

	while(!opStack.isEmpty()) // remaining operators on the stack are added to the queue
	{
	    postfixQueue.insert(opStack.pop());
	}
	return postfixQueue;
    }

    private double evaluatePostfix(DSAQueue postfixQueue)
    {
	DSAStack operandStack; // note that we are storing double values on the stack this time
	char op;
	double op1, op2;

	operandStack = new DSAStack(postfixQueue.size());
	while(!postfixQueue.isEmpty())
	{
	    if (postfixQueue.peek() instanceof Double)
	    {
		operandStack.push(postfixQueue.remove());
	    }
	    else if (postfixQueue.peek() instanceof Character)
	    {
		op2 = (double) operandStack.pop();
		op1 = (double) operandStack.pop();
		op = (Character) (postfixQueue.remove());
		operandStack.push(executeOperation(op, op1, op2));
	    }
	    else
	    {
		throw new IllegalArgumentException("Error evaulating postfix. ");
	    }
	}
	return (double)operandStack.pop();
    }

    // precedence
    // ( * / ) > ( + - )
    private int precedenceOf(char theOp)
    {
	int precedence = 0;

	switch(theOp)
	{
	    case '+': case '-':
		precedence = 1;
		break;

	    case '*': case '/':
		precedence = 2;
		break;
	    default:
		throw new IllegalArgumentException("Unknown operator: (" + theOp + "), in precedenceOf");
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
