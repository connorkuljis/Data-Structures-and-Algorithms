import java.util.*;
import java.io.*;

public class FileIO
{
    static final String file1 = "asset_info.csv";

    public static void main(String[] args)
    {
	// read the graph from the filenames
	DSAGraph graph1 = readAsset(file1);
	graph1.displayAdjacencyList();
	// graph1.display();
	// end 1
    }

    public static void displaySearch(DSAQueue traversalQueue)
    {
	for (Object e : traversalQueue) // each object is a vertex with a label
	{
	    System.out.print(((DSAGraphVertex)(e)).getLabel() + " "); 
	}
	System.out.println(""); 

    }

    public static DSAGraph readAsset(String inFilename)
    {
	DSAGraph theGraph = new DSAGraph();

	FileInputStream fileStrm = null;
	InputStreamReader rdr;
	BufferedReader bufRdr;
	String line;

	try {
	    fileStrm = new FileInputStream(inFilename);
	    rdr = new InputStreamReader(fileStrm);
	    bufRdr = new BufferedReader(rdr);

	    line = bufRdr.readLine(); // lets ignore the first line
	    line = bufRdr.readLine(); // lets ignore the second line

	    line = bufRdr.readLine(); // read the 'first line'
	    while(line != null)
	    {
		processLine(line, theGraph);
		line = bufRdr.readLine(); // moves to the next line
	    }
	    fileStrm.close();
	}
	catch (IOException e)
	{
	    if (fileStrm != null)
	    {
		try
		{
		    fileStrm.close();
		}
		catch (IOException ex2) {}
	    }
	    System.out.println("Error in file processing: " + e.getMessage()); 
	}
	return theGraph;
    }

    private static double regexCurrency(String inStrValue)
    {
	double outVal = 0;
	try
	{
	    outVal = Double.parseDouble(inStrValue.replaceAll("[^\\d.]+", "")); // regex to get only 
	                                                                        // digits and decimal
	}
	catch (Exception e)
	{

	}
	return outVal;
    }

    private static double regexPercentage(String inStrValue)
    {
	double outVal = 0;
	try
	{
	    outVal = Double.parseDouble(inStrValue.replaceAll("%", "")); // regex to get only 
									 // digits, decimal and negative sign
	}
	catch (Exception e)
	{

	}
	return outVal;
    }

    // https://stackoverflow.com/questions/1757065/java-splitting-a-comma-separated-string-but-ignoring-commas-in-quotes
    public static void processLine(String row, DSAGraph theGraph)
    {
	try
	{
	    String[] strArr = row.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

	    String name = strArr[1]; 
	    String symbol = strArr[2];
	    double marketCap = regexCurrency(strArr[3]);
	    double price = regexCurrency(strArr[5]);
	    String circulatingSupply = strArr[6];
	    double volume24hr = regexCurrency(strArr[8]);
	    double change1hr = regexPercentage(strArr[9]);
	    double change24hr = regexPercentage(strArr[10]);
	    double change7d = regexPercentage(strArr[11]);

	    CryptoCurrency currency = new CryptoCurrency(name, symbol, marketCap, price, 
		    circulatingSupply, volume24hr, change1hr, change24hr, change7d);

	    theGraph.addVertex(symbol, currency);
	}
	catch (IllegalArgumentException e)
	{
	    System.out.println("Error trying to process line"); 

	}
    }

    // public static DSAGraph readAsset(String filename)
    {

    }

    // public static void writeCSV(DSAQueue queue, String target) throws Exception
    // {
    //     java.io.File file = new java.io.File(target);
    //     if (file.exists())
    //     {
    //         throw new Exception("File already exists");
    //     }
    //     else
    //     {
    //         java.io.PrintWriter output = new java.io.PrintWriter(file);

    //         for (Object e : queue)
    //         {
    //     	output.print(e + ",");
    //     	output.println("");
    //         }
    //         output.close();
    //     }
    // }
}
