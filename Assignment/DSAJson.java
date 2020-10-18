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
	    DSAGraph graph = new DSAGraph();

	    int count = 0;
	    for (int i = 0; i < symbols.length(); i++)
	    {
		// TODO put an if statement to check the status if "TRADING"
		JSONObject curObj = (JSONObject) (symbols.get(i)); 
		// System.out.println(curObj.getString("symbol")); 
		System.out.print(curObj.getString("baseAsset") + " "); 
		System.out.print(curObj.getString("quoteAsset")); 
		System.out.println(""); 
		count++;
	    }
	}
	catch (Exception e)
	{
	    e.getMessage();
	}
    }

}
