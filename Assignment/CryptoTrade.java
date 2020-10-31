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
	return (name + " " + price + " " + priceChange + " " + priceChangePercent
		+ "%" + " " + volume + " " + count);
    }

    public String getName() { return name; }
    public Double  getPrice() { return price; }
    public Double getPriceChange() { return priceChange; }
    public Double getPriceChangePercent() { return priceChangePercent; }
    public Double getVolume() { return volume; }
    public Double getCount() { return count; }


}
