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
	if (args.length == 3)
	{
	    String mode = args[0];
	    String assetFileName = args[1];
	    String tradeFileName = args[2];

	    DSAGraph theGraph = new DSAGraph();
	    theGraph = FileIO.readAsset(assetFileName);
	    theGraph = DSAJson.readTrade(theGraph, tradeFileName);
	    DSAJson.read24hr(theGraph);

	    if (mode.equals("-i"))
	    {
		System.out.println("Entered INTERACTIVE mode... "); 
		menu(theGraph);
	    }
	    else if (mode.equals("-r"))
	    {
		System.out.println("Entered REPORT mode... "); 

		System.out.println("Assets: " + theGraph.getVertexCount());
		System.out.println("Trades: " + theGraph.getEdgeCount());
		tradeStats(theGraph);
		// view(theGraph);
		// theGraph.helper("XRP", "USDT");
	    }
	    else
	    {
		usage();
	    }
	}
	else
	{
	    usage();
	}
    }

    public static void view(DSAGraph theGraph)
    {
	theGraph.displayAdjacencyList();
	theGraph.depthFirstSearch().display();
	theGraph.breadthFirstSearch().display();
    }

    private static void menu(DSAGraph theGraph)
    {
	Scanner sc = new Scanner(System.in);
	int choice;
	boolean close = false;

	do
	{
	    System.out.println("\tAssets: " + theGraph.getVertexCount()); 
	    System.out.println("\tTrades: " + theGraph.getEdgeCount()); 
	    prompt();
	    System.out.print("Select an option >>> "); 
	    choice = sc.nextInt(); 

	    switch(choice)
	    {
		case 1:
		    message("You selected, 1. Load Data"); 
		    loadDataSubMenu();
		    break;
		case 2:
		    message("You selected, 2. Find and display an asset"); 
		    findAssetMenu(theGraph);
		    break;
		case 3:
		    message("You selected, 3. Find and display trade details");
		    findTradeMenu(theGraph);
		    break;
		case 4:
		    message("4. Find and display potential trade paths"); 
		    break;
		case 5:
		    message("You selected, 5. Set asset filter"); 
		    theGraph.removeVertex("BTC");
		    break;
		case 6:
		    message("You selected, 6. Asset overview"); 
		    assetStats(theGraph);
		    break;
		case 7:
		    message("You selected, 7. Trade overview"); 
		    tradeStats(theGraph);
		    break;
		case 8:
		    message("You selected, 8. Save Data"); 
		    break;
		case 9:
		    message("You selected, 9. Exit"); 
		    System.out.println("Exiting program..."); 
		    close = true;
		    break;
		default:
		    System.out.println("Invalid option"); 
		    break;
	    }
	}while(!close);
    }

    private static void findAssetMenu(DSAGraph theGraph)
    {
	Scanner sc = new Scanner(System.in);
	boolean again = false;
	do
	{
	    System.out.println("Please enter the asset symbol eg: 'BTC'"); 
	    System.out.print(">>> ");
	    String target = sc.next().toUpperCase();

	    findAsset(theGraph, target);
	    System.out.print("Find another asset? (y/n) >>> "); 
	    if (sc.next().toLowerCase().equals("y"))
	    {
		again = true;
	    }
	}while(again);
    }

    private static void findTradeMenu(DSAGraph theGraph)
    {
	Scanner sc = new Scanner(System.in);
	boolean again = false;
	do
	{
	    System.out.println("Please enter the trade symbol eg: 'BTCETH'"); 
	    System.out.print(">>> ");
	    String target = sc.next().toUpperCase();

	    findTrade(theGraph, target);

	    System.out.print("Find another asset? (y/n) >>> "); 
	    if (sc.next().toLowerCase().equals("y"))
	    {
		again = true;
	    }
	}while(again);
    }

    private static void message(String content)
    {
	String mgtBG = "\u001b[45;1m";
	String reset = "\u001b[0m";

	System.out.println(mgtBG + content + reset); 
    }

    private static void findAsset(DSAGraph graph, String assetName)
    {
	DSAGraphVertex vertex = null;
	CryptoCurrency asset = null;
	try
	{
	    vertex = graph.getVertex(assetName);
	    asset = (CryptoCurrency) vertex.getValue();
	    System.out.println(asset); 
	}
	catch (Exception e)
	{
	    System.out.println("Cannot find '" + assetName + "'"); 
	}
    }

    private static void findTrade(DSAGraph graph, String tradeName)
    {
	DSAGraphEdge edge = null;
	CryptoTrade trade = null;
	try
	{
	    edge = graph.getEdge(tradeName);
	    trade = (CryptoTrade) edge.getValue();
	    System.out.println(trade); 
	}
	catch (Exception e)
	{
	    System.out.println("Cannot find '" + tradeName + "'"); 
	}
    }

    private static void assetStats(DSAGraph theGraph)
    {
	DSALinkedList verticies = theGraph.getVerticies();
	DSAHeap topHeap = new DSAHeap(10);

	for (Object e : verticies)
	{
	    DSAGraphVertex vertex = (DSAGraphVertex) e;
	    CryptoCurrency currency = (CryptoCurrency) vertex.getValue();
	    double priority = currency.getPrice();
	    topHeap.add(priority, currency);
	}

	for (int i = 0; i < 10; i++)
	{
	    int val = i + 1;
	    System.out.println("TOP ASSET NUMBER " + val + " BY PRICE"); 
	    System.out.println(topHeap.remove().getValue()); 
	}

    }

    private static void tradeStats(DSAGraph theGraph)
    {
	DSALinkedList edges = theGraph.getEdges();
	DSAHeap topHeap = new DSAHeap(10);

	for (Object e : edges)
	{
	    DSAGraphEdge edge = (DSAGraphEdge) e;
	    CryptoTrade trade = (CryptoTrade) edge.getValue();
	    double priority = trade.getVolume();
	    topHeap.add(priority, trade);
	}

	for (int i = 0; i < 10; i++)
	{
	    int val = i + 1;
	    System.out.println("TOP TRADE NUMBER " + val + " BY VOLUME"); 
	    System.out.println(topHeap.remove().getValue()); 
	}

    }
    private static void loadDataSubMenu()
    {

    }


    private static void usage()
    {
	System.out.println("Usage-");
	System.out.println(""); 

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
