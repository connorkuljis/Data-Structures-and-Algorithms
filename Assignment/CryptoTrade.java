/* ***************************************************************************
 * NAME: CryptoCurrency
 * AUTHOR: Connor Kuljis, 19459138
 * UNIT: Data Structures and Algorithms (COMP1002)
 * PURPOSE: Class file for storing information about cryptocurrencies
 * COMMENT: 
 * DATE: 2020-10-25
 * **************************************************************************/
import java.util.*;

public class CryptoTrade
{
    // class fields
    String name;
    double price;
    double priceChange;
    double priceChangePercent;
    double volume;
    double count;



    public CryptoTrade(String inName, double inPrice, double inPriceChange,
	    double inPriceChangePercent, double inVolume, double inCount)
    {
	name = inName;
	price = inPrice;
	priceChange = inPriceChange;
	priceChangePercent = inPriceChangePercent;
	volume = inVolume;
	count = inCount;
    }

    public String toString()
    {
	return ("\tname\t\t\t: " + name + "\n\tprice\t\t\t: "  + price + 
		"\n\tprice change\t\t: " + priceChange + "\n\tprice change %\t\t: " + 
		priceChangePercent
		+ "%" + "\n\tvolume\t\t\t: " + volume + "\n\tcount\t\t\t: " + count);
    }

    public String getName() { return name; }
    public Double  getPrice() { return price; }
    public Double getPriceChange() { return priceChange; }
    public Double getPriceChangePercent() { return priceChangePercent; }
    public Double getVolume() { return volume; }
    public Double getCount() { return count; }


}
