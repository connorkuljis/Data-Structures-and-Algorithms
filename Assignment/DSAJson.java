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
import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.JSONArray;

public class DSAJson
{
    public static void main(String[] args)
    {
	try
	{
	    JSONTokener jsonToken = new JSONTokener(new FileReader("exchangeInfo.json"));
	    JSONObject jsonObject = new JSONObject(jsonToken);
	    
	    // System.out.println(jsonObject.getString("timezone"));
	    JSONArray symbols = jsonObject.getJSONArray("symbols");

	    // Graph init
	    DSAGraph graph = FileIO.readAsset("asset_info.csv");

	    int count = 0;
	    for (int i = 0; i < symbols.length(); i++)
	    {
		// TODO put an if statement to check the status if "TRADING"
		JSONObject curObj = (JSONObject) (symbols.get(i)); 
		// System.out.println(curObj.getString("symbol")); 
		String label = curObj.getString("symbol"); 
		String from = curObj.getString("baseAsset"); 
		String to = curObj.getString("quoteAsset"); 
		graph.addEdge(from, to, label, null);
		graph.displayEdges();
		count++;
	    }
	}
	catch (Exception e)
	{
	    e.getMessage();
	}
    }

}
