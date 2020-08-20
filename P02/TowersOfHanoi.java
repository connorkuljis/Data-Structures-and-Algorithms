/* ***************************************************************************
 *
 * TowersOfHanoi.java - solves the towers of Hanoi puzzle using recursion
 * **************************************************************************/

public class TowersOfHanoi
{
    public static void main(String[] args)
    {
	System.out.println("### TOWERS OF HANOI ###"); 

	int nDisks = 3; // number of disks on the tower
	towers(nDisks, 1, 2, 3, ""); 
    }

    public static void towers(int topN, int src, int aux, int dest, 
	    String count)
    {
	System.out.println(count + "Enter (" + topN + ") disks: Source=" + src  
		+ ", Aux=" + aux + ", Dest=" + dest); 

	if (topN == 1) // if there is only one disk we can move it
	{
	    moveDisk(topN, src, dest, count);
	}
	else
	{
	    count += "    "; // showing level of indentation
	    // we have some swapping going on, move the sub tree to the aux
	    towers(topN - 1, src, dest, aux, count);

	    moveDisk(topN, src, dest, count); // once the sub tree is moved

	    count += "    "; // showing level of indentation
	    towers(topN - 1, aux, src, dest, count); /* move that sub tree 
				from the aux to the dest using src as
						 auxillary */
	}
    }

    public static void moveDisk(int topN, int src, int dest, String count)
    {
	System.out.println(count + "Moving top disk(" + topN + ") from peg: " 
		+ src + ", to peg: " + dest); 
    }
    
}
