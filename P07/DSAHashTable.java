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

    /* HASH TABLE CLASS */
    private DSAHashEntry[] hashArray;
    private int count;
    private final float MAX_LOAD_FACTOR = 0.685f;

    public DSAHashTable(int inSize)
    {
	int actualSize = nextPrime(inSize);
	hashArray = new DSAHashEntry[actualSize];

	for (int i = 0; i < hashArray.length; i++)
	{
	    hashArray[i] = new DSAHashEntry();
	}
	count = 0;
    }

    /* ***********************************************************************
     * NAME: hash
     * IMPORTS: inKey (String)
     * EXPORTS: hashIdx (Integer)
     *
     * **********************************************************************/
    private int hash(String inKey)
    {
	int hashIdx = 0;
	for (int ii = 0; ii < inKey.length(); ii ++)
	{
	    // https://docs.oracle.com/javase/10/docs/api/java/lang/String.html#hashCode()
	    hashIdx = (31 * hashIdx) + inKey.charAt(ii);
	}
	return hashIdx % hashArray.length;
    }

    /* NOTE: Java: If you use a private inner class for DSAHashEntry, put(DSAHashEntry) will 
     * need to be private, otherwise it will be public */
    public void put(String inKey, Object inValue)
    {
	// ASSUMPTION: the array is not full
	DSAHashEntry item = new DSAHashEntry(inKey, inValue);
	int hashIdx = hash(inKey);
	int stepSize = doubleHash(hashIdx);

	while (hashArray[hashIdx].state != 0 ) // loop until found an empty spot
	{
	    // hashIdx = linearProbe(hashIdx); // will wrap around
	    hashIdx += stepSize;
	    hashIdx %= hashArray.length;
	}

	// insert the item
	hashArray[hashIdx] = item;
	count++;
    }

    public Object getValue(String inKey)
    {
	int hashIdx = 0;
	Object outObject = null;
	try
	{
	    hashIdx = find(inKey);
	    outObject = hashArray[hashIdx].value;
	}
	catch (Exception e)
	{
	    System.out.println(e.getMessage());
	}

	return outObject;

    }

    public void remove(String inKey) 
    {
	int hashIdx = 0;
	try
	{
	    hashIdx = find(inKey);
	    hashArray[hashIdx].state = -1;
	    count--;
	}
	catch (Exception e)
	{
	    System.out.println(e.getMessage());
	}
    }

    private int doubleHash(int hashIdx)
    {
	return 5 - (hashIdx % 5);
    }

    private int linearProbe(int hashIdx)
    {
	return (hashIdx + 1) % hashArray.length; // probe;
    }
    
    private int find(String inKey)
    {
	int hashIdx = hash(inKey), origIdx = hashIdx;
	int stepSize = doubleHash(hashIdx);

	boolean found = false, giveUp = false;

	while (!found && !giveUp)
	{
	    if (hashArray[hashIdx].state == 0)
	    {
		giveUp = true;
	    }
	    else if (hashArray[hashIdx].key == inKey)
	    {
		found = true;
	    }
	    else
	    {
		// hashIdx = linearProbe(hashIdx);
		hashIdx += stepSize;
		hashIdx %= hashArray.length;
		if (hashIdx == origIdx)
		{
		    giveUp = true;
		}
	    }
	}

	if (!found)
	{
	    throw new IllegalArgumentException("Cannot find key, " + inKey + " in Hash Table");
	}

	return hashIdx;
    }

    /* https://stackoverflow.com/questions/10901752/what-is-the-significance-of-load-factor-in-hashmap#:~:text=Default%20initial%20capacity%20of%20the,as%2016%20*%200.75%20%3D%2012%20. */
    /* https://docs.oracle.com/javase/6/docs/api/java/util/HashMap.html */
    public double getLoadFactor()
    {
	return (double) count / (double) hashArray.length;
    }

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

    public void display()
    {
	System.out.println("[ <key> | <value> ]"); 
	for (int i = 0; i < hashArray.length - 1; i++)
	{
	    if (hashArray[i].state == 1)
	    {
		System.out.println("[ " + hashArray[i].key + " | " + hashArray[i].value + " ]"); 
	    }
	}
    }
}
