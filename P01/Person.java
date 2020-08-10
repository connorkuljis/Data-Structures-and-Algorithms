/*****************************************************************************
 * FILE: Person.java
 * AUTHOR: Connor Kuljis 19459138
 * UNIT: Data Structures and Algorithms 
 *****************************************************************************/

import java.util.*;

public class Person
{
    // class fields
    private String name;
    private int ID;

    // default constructor
    public Person()
    {
        name = "";
        ID = 0;
    }

    // alternate constructor
    public Person(int inID, String inName)
    {
        setID(inID);
        setName(inName);
    }

    // copy constructor
    public Person(Person inPerson)
    {
        name = inPerson.getName();
        ID = inPerson.getID();
    }

    // mutators
    public void setName(String inName)
    {
        if (validString(inName))
        {
            throw new IllegalArgumentException("Not a valid name, it cannot be empty");
        }
        else
        {
            name = inName;
        }
    }

    public void setID(int inID)
    {
	ID = inID;
    }

    // accessors
    public String getName()
    {
        return name;
    }

    public int getID()
    {
        return ID;
    }

    // toString
    public String toString()
    {
        return ("Name: " + name + ", ID: " + ID);
    }

    // equals

    // clone
    public Person clone()
    {
        return new Person(this);
    }

    // String toFileString() - returns the object reconstructed into its CSV equivalent
    public String toFileString()
    {
        return (name + "," + ID);
    }

    // validString
    public boolean validString(String inName)
    {
        return ((inName == null) || (inName.equals("")));
    }
}

