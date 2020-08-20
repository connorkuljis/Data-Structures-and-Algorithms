/* ***************************************************************************
 * TowersOfHanoi.java - solves the towers of Hanoi puzzle
 * **************************************************************************/

public class TowersOfHanoi
{
    public static void main(String[] args)
    {
	int nDisks = 3;
	towers(nDisks, 1, 2, 3, 0);
    }

    public static void towers(int topN, int src, int aux, int dest, int count)
    {
	System.out.println("Enter (" + topN + ") disks: Source=" + src + 
		", Aux=" + aux + ", Dest=" + dest + " " + count); 
	if (topN == 1) // if there is only one disk we can move it
	{
	    moveDisk(topN, src, dest);
	}
	else
	{
	    towers(topN - 1, src, dest, aux, count); // move the sub tree to the aux
	    count++;

	    moveDisk(topN, src, dest);

	    towers(topN - 1, aux, src, dest, count); /* move that sub tree from the 
						 aux to the dest using src as
						 auxillary */
	    count++;
	}
    }

    public static void moveDisk(int topN, int src, int dest)
    {
	System.out.println("Moving top disk(" + topN + ") from peg: " + src + 
		", to peg: " + dest); 
    }
    
}
