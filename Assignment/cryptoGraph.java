/* ***************************************************************************
 * NAME:
 * AUTHOR: Connor Kuljis, 19459138
 * UNIT: Data Structures and Algorithms (COMP1002)
 * PURPOSE:
 * COMMENT:
 * DATE: 2020-
 * **************************************************************************/
import java.util.*;

public class cryptoGraph
{
    public static void main(String[] args)
    {
	// if (args.length == 3)
	if (args.length > 1) // this is for testing purposes
	{
	    System.out.println(mode + ": " + assetFileName + ", " + tradeFileName); 
	    // valid arg length
	    String mode = args[0];
	    String assetFileName = args[1];
	    String tradeFileName = args[2];
	    System.out.println(mode + ": " + assetFileName + ", " + tradeFileName); 

	    // read the asset (nodes in the graph)
	    DSAGraph g = FileIO.readAsset(assetFileName);

	    // read the trade (edges in the graph)
	    // ASSERTION: if the nodes do not exist in the graph, the edges are not added
	    g = DSAJson.readTrade(g, tradeFileName);

	    System.out.println(findAsset(g, "BTC")); 
	    

	}
	else
	{
	    printUsage();
	}
    }

    private static void menu()
    {
	Scanner sc = new Scanner(System.in);
	int choice;
	do
	{
	    prompt();
	    System.out.print("Select an option:"); 

	    choice = sc.nextInt(); 

	    switch(choice)
	    {
		case 1:
		    System.out.println("You selected, 1. Load Data"); 
		    loadDataMenu();
		    break;
		case 2:
		    System.out.println("You selected, 2. Find and display an asset"); 
		    System.out.println("");
		    System.out.println(findAsset(g, "BTC")); 
		    break;

	    }



	}while(!close);
    }

    private static CryptoCurrency findAsset(DSAGraph graph, String assetName)
    {
	DSAGraphVertex vertex = null;
	CryptoCurrency asset = null;
	try
	{
	    vertex = graph.getVertex(assetName);
	    asset = (CryptoCurrency) vertex.getValue();
	    System.out.println(asset.getName()); 
	}
	catch (Exception e)
	{
	    System.out.println("Cannot find '" + assetName + "'"); 
	}
	return asset;
    }

    private static void usage()
    {
	System.out.println("Usage-");
    }

    private static void prompt()
    {
	System.out.println("1. Load Data"); 
	System.out.println("2. Find and display an asset"); 
	System.out.println("3. Find and display trade details"); 
	System.out.println("4. Find and display potential trade paths"); 
	System.out.println("5. Set asset filter"); 
	System.out.println("6. Asset overview"); 
	System.out.println("7. Trade overview"); 
	System.out.println("8. Save Data"); 
	System.out.println("9. Exit"); 
    }

}
