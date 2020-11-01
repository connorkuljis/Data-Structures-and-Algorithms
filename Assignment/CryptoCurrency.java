/* ***************************************************************************
 * NAME: CryptoCurrency
 * AUTHOR: Connor Kuljis, 19459138
 * UNIT: Data Structures and Algorithms (COMP1002)
 * PURPOSE: Class file for storing information about cryptocurrencies
 * COMMENT: 
 * DATE: 2020-10-25
 * **************************************************************************/
import java.util.*;

public class CryptoCurrency
{
    // class fields
    String name;
    String symbol;
    double marketCap;
    double price;
    String circulatingSupply;
    double volume24hr;
    double change1hr;
    double change24hr;
    double change7d;

    // CONTRUCTOR
    public CryptoCurrency(String inName, String inSymbol, double inMarketCap,
	   double inPrice, String inCirculatingSupply, double inVolume24hr,
	   double inChange1hr, double inChange24hr, double inChange7d)
    {
	name = inName;
	symbol = inSymbol;
	marketCap = inMarketCap;
	price = inPrice;
	circulatingSupply = inCirculatingSupply;
	volume24hr = inVolume24hr;
	change1hr = inChange1hr;
	change24hr = inChange24hr;
	change7d = inChange7d;
    }

    /* ***********************************************************************
     * NAME: toString
     * IMPORTS: none
     * EXPORTS: String
     * **********************************************************************/
    public String toString()
    {
	return("\tname\t\t\t: " + name + "\n\tsymbol\t\t\t: " + symbol + "\n\tmarket cap\t\t: " + marketCap +
		"\n\tprice\t\t\t: " + price + "\n\tcirculating supply\t: " + circulatingSupply + 
		"\n\tvolume24hr\t\t: " + volume24hr + "\n\tchange1hr\t\t: " + change1hr + "%" + "\n\tchange24hr\t\t: " 
	       + change24hr + "%" + "\n\tchange7d\t\t: " + change7d + "%");
    }

    // ACCESSORS
    public String getName() { return name; }
    public String getSymbol() { return symbol; }
    public Double getMarketCap() { return marketCap; }
    public Double getPrice() { return price; }
    public String getCirculatingSupply() { return circulatingSupply; }
    public Double getVolume24hr() { return volume24hr; }
    public Double getChange1hr() { return change1hr; }
    public Double getChange24hr() { return change24hr; }
    public Double getChange7d() { return change7d; }


}
