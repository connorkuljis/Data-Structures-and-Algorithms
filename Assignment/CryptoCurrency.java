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
    double circulatingSupply;
    double volume24hr;
    double change1hr;
    double change24hr;
    double change7d;

    public CryptoCurrency(String inName, String inSymbol, double inMarketCap,
	   double inPrice, double inCirculatingSupply, double inVolume24hr,
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

    public String toString()
    {
	return(name + ", " + symbol + ", " + marketCap + ", " + price + ", " +
	       circulatingSupply + ", " + volume24hr + ", " + change1hr + ", "
	       + change24hr + ", " + change7d);
    }

    public String getName() { return name; }
    public String getSymbol() { return symbol; }
    public Double getMarketCap() { return marketCap; }
    public Double getPrice() { return price; }
    public Double getCirculatingSupply() { return circulatingSupply; }
    public Double getVolume24hr() { return volume24hr; }
    public Double getChange1hr() { return change1hr; }
    public Double getChange24hr() { return change24hr; }
    public Double getChange7d() { return change7d; }


}
