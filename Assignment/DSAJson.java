/* ***************************************************************************
 * NAME: DSAJson.java
 * AUTHOR: Connor Kuljis, 19459138
 * UNIT: Data Structures and Algorithms (COMP1002)
 * PURPOSE: 
 * COMMENT: 
 * DATE: 2020-10-18
 * **************************************************************************/

import java.util.*;
import java.io.*;
import org.json.*;

public class DSAJson
{
    public static DSAGraph readTrade(DSAGraph graph, String tradeFileName)
    {
	try
	{
	    JSONTokener jsonToken = new JSONTokener(new FileReader("newEx.json"));
	    JSONObject jsonObject = new JSONObject(jsonToken);
	    
	    // System.out.println(jsonObject.getString("timezone"));
	    JSONArray symbols = jsonObject.getJSONArray("symbols");

	    int count = 0;
	    for (int i = 0; i < symbols.length(); i++)
	    {
		JSONObject curObj = (JSONObject) (symbols.get(i)); 
		
		if (curObj.getString("status").equals("TRADING"))
		{
		    // System.out.println(curObj.getString("symbol")); 
		    String label = curObj.getString("symbol"); 
		    String from = curObj.getString("baseAsset"); 
		    String to = curObj.getString("quoteAsset"); 
		    try
		    {
			// exception is thrown if the base asset does
			// not exist
			graph.addEdge(from, to, label, null); 
		    }
		    catch (Exception e)
		    {
			// do nothing to skip the trade
			//
		    }
		}
	    }
	}
	catch (Exception e)
	{
	    e.getMessage();
	}
	return graph;
    }

    public static void read24hr(DSAGraph theGraph)
    {
	try
	{
	    JSONTokener jsonToken = new JSONTokener(new FileReader("24hr.json"));
	    JSONArray tradeArray = new JSONArray(jsonToken);

	    for (int i = 0; i < tradeArray.length(); i++)
	    {
		JSONObject curObj = (JSONObject) (tradeArray.get(i)); 
		
		String name = curObj.getString("symbol"); 
		double price = curObj.getDouble("lastPrice");
		double priceChange = curObj.getDouble("priceChange");
		double priceChangePercent = curObj.getDouble("priceChangePercent");
		double volume = curObj.getDouble("volume");
		double count = curObj.getDouble("count");


		CryptoTrade newTrade = new CryptoTrade(name, price, priceChange,
			priceChangePercent, volume, count);

		try
		{
		    theGraph.addWeight(name, newTrade);
		}
		catch (Exception e)
		{
		    System.out.println(e.getMessage()); 
		}
	    }
	}
	catch (Exception e)
	{
	    e.getMessage();
	}
    }
}
