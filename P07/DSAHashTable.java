/* ***************************************************************************
 * NAME: DSAHashTable
 * AUTHOR: Connor Kuljis, 19459138
 * UNIT: Data Structures and Algorithms (COMP1002)
 * PURPOSE:
 * COMMENT:
 * DATE: 2020-10-08
 * **************************************************************************/

import java.util.*;
import java.lang.Math;

public class DSAHashTable
{
    /* INNER CLASS */
    public class DSAHashEntry
    {
	private String key;
	private Object value;
	private int state;

	public DSAHashEntry()
	{
	    key = "";
	    value = null;
	    state = 0;
	}

	public DSAHashEntry(String inKey, Object inValue)
	{
	    key = inKey;
	    value = inValue;
	    state = 1;
	}
    }

    /* MAIN CLASS */
    private DSAHashEntry[] hashArray;
    private int count;

    public DSAHashTable(int maxSize)
    {
	hashArray = new DSAHashEntry[maxSize];
	count = 0;
    }

    /* NOTE: Java: If you use a private inner class for DSAHashEntry, put(DSAHashEntry) will 
     * need to be private, otherwise it will be public */
    private void put (String inKey, Object inValue)
    {
	// ASSUMPTION: the array is not full
	DSAHashEntry item = new DSAHashEntry(inKey, inValue);
	int hashVal = hash(inKey);

	while (hashArray[hashVal] != null) // collision
	{
	    ++hashVal; // this is a linear probe
	    // hashVal % hashArray.length;
	}

	// insert the item
	hashArray[hashVal] = item;
	
    }

    private int hash(String inKey)
    {
	int hashIdx = 0;
	for (int ii = 0; ii < inKey.length(); ii ++)
	{
	    // https://docs.oracle.com/javase/10/docs/api/java/lang/String.html#hashCode()
	    hashIdx += (31 * hashIdx) + inKey.charAt(ii);
	}
	return hashIdx % hashArray.length;
    }

    // private int stepHash()

    private int nextPrime(int startVal) 
    {
	int primeVal = 0;

	if (startVal % 2 == 0)
	{
	    primeVal = startVal - 1;
	}
	else
	{
	    primeVal = startVal;
	}

	boolean isPrime = false;
	int ii = 0, rootVal = 0;

	do
	{
	    primeVal += 2;
	    ii = 3;
	    isPrime = true;
	    rootVal = (int) Math.sqrt((double) primeVal);
	    do
	    {
		if (primeVal % ii == 0)
		{
		    isPrime = false;
		}
		else
		{
		    ii += 2;
		}
	    } while (ii <= rootVal && isPrime);
	} while (!isPrime);
	return primeVal;
    }
}
