import java.util.Stack;

public class StacksRFun
{
    public static void main(String[] args)
    {
	Stack<String> games = new Stack<String>();

	System.out.println(games); 

	System.out.println("Adding games on the stack."); 
	games.add("World of Warcraft");
	games.add("League of Legends");
	games.add("Game of Love");

	System.out.println(games); 

	/* printing pop() also perfroms the pop() method */
	System.out.println(games.pop());

	System.out.println("top: " + games.peek()); 

	System.out.println(games.search("League of Legends")); 

	System.out.println(games); 
	games.push("World of Warcraft");
	System.out.println(games); 

	



    }
}
