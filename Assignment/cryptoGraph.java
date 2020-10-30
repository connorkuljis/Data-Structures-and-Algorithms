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
	    // valid arg length
	    String mode = args[0];
	    String assetFileName = args[1];
	    String tradeFileName = args[2];
	    System.out.println(mode + ": " + assetFileName + ", " + tradeFileName); 

	    DSAGraph g = FileIO.readAsset(assetFileName);
	    g.displayVerticies();


	}
	else
	{
	    printUsage();
	}
    }

    private static void printUsage()
    {
	System.out.println("Usage-");
    }

}
