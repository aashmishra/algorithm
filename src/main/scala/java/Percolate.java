import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolate
{

    /// totalLength is the length of the square grid. 
    // There are totalLength^2 non-virtual sites in the grid
    private int totalLength;
    ///  two sites can percolate to one another if they are both open and connected:
    ///  isOpen monitors open/closed state of each site.
    private boolean[] isOpen;
    ///  percolation represents connectivity between sites. connected, open sites percolate to one another.
    private WeightedQuickUnionUF percolation;
    // quick union structure for tracking fullness without backwash.
    // similar to percolation above, but without bottom virtual site
    private WeightedQuickUnionUF fullness;
    /// index of virtual site that is connected to entire top row, initializes to 0.
    private int virtualTopIndex;
    /// index of virtual site that is connected to entire bottom row, initializes to (N^2)+1
    private int virtualBottomIndex;

    /// converts between two dimensional coordinate system and site array index. 
    /// throws exceptions on invalid bounds. valid indices are 1 : N^2
    /// i is the row; j is the column
    private int siteIndex(int i, int j)
    {
        checkBounds(i,j);
        int x = j;
        int y = i;
        return (y-1)*totalLength+(x);
    }

    /*
     * By convention, the indices i and j are integers between 1 and N, where (1, 1) is the upper-left site:
     * Throw a java.lang.IndexOutOfBoundsException if either i or j is outside this range.
     */
    private void checkBounds(int i, int j)
    {
        if (i>totalLength || i < 1 )
        {
            throw new IndexOutOfBoundsException("row index i out of bounds");
        }
        if (j>totalLength || j<1)
        {
            throw new IndexOutOfBoundsException("column index j out of bounds");
        }
    }

    // create N-by-N grid, with all sites blocked
    public Percolate(int N)
    {
        if ( N < 1 ) {
            throw new IllegalArgumentException();
        }
        totalLength = N;
        int arraySize = N*N+2;
        isOpen = new boolean[arraySize];

        virtualTopIndex = 0;
        virtualBottomIndex = (N*N)+1;

        isOpen[virtualTopIndex] = true; /// open virtual top site
        isOpen[virtualBottomIndex] = true; /// open virtual bottom site

        percolation = new WeightedQuickUnionUF(arraySize);
        fullness = new WeightedQuickUnionUF(arraySize);
        for (int j = 1; j<=N; j++)
        {
            /// connect all top row sites to virtual top site
            int i = 1;
            int topSiteIndex = siteIndex(i,j);
            percolation.union(virtualTopIndex, topSiteIndex);
            fullness.union(virtualTopIndex, topSiteIndex);

            /// connect all bottom row sites to virtual bottom site
            i = N;
            int bottomSiteIndex = siteIndex(i,j);
            percolation.union(virtualBottomIndex, bottomSiteIndex);

        }
    };

    // open site (row i, column j) if it is not already
    public void open(int i, int j)
    {
        int siteIndex = siteIndex(i,j);
        if (!isOpen[siteIndex])
        {
            /// to open a site, change boolean value, and union with any adjacent open sites
            isOpen[siteIndex] = true;

            // before connecting to a neighbor, first check that site is not on an edge, and is open
            if (j>1 && isOpen(i,j-1))
            {
                int indexToLeft = siteIndex(i,j-1);
                percolation.union(siteIndex, indexToLeft);
                fullness.union(siteIndex, indexToLeft);
            }

            if (j<totalLength && isOpen(i,j+1))
            {
                int indexToRight = siteIndex(i,j+1);
                percolation.union(siteIndex, indexToRight);
                fullness.union(siteIndex,indexToRight);
            }

            if (i>1 && isOpen(i-1,j)) // site is not top edge
            {
                int indexToTop = siteIndex(i-1,j);
                percolation.union(siteIndex, indexToTop);
                fullness.union(siteIndex,indexToTop);
            }

            if (i<totalLength && isOpen(i+1,j)) /// site is not on bottom edge
            {
                int indexToBottom = siteIndex(i+1,j);
                percolation.union(siteIndex, indexToBottom);
                fullness.union(siteIndex,indexToBottom);
            }
        }
    };

    // is site (row i, column j) open?
    //// openness represented by boolean value in isOpen array
    public boolean isOpen(int i, int j)
    {
        int siteIndex = siteIndex(i,j);
        return isOpen[siteIndex];
    }

    // is site (row i, column j) full?
    /// fullness represented by union with virtual top node
    public boolean isFull(int i, int j)
    {
        int siteIndex = siteIndex(i,j);
        //return (percolation.connected(virtualTopIndex,siteIndex) && isOpen[siteIndex]);
        return (fullness.connected(virtualTopIndex,siteIndex) && isOpen[siteIndex]);
    }

    // does the system percolate?
    public boolean percolates() {
        if (totalLength>1) {
            return percolation.connected(virtualTopIndex,virtualBottomIndex);
        }
        else {
            return isOpen[siteIndex(1,1)];
        }

    }

    public static void  main(String[] args)
    {
        Percolation percolation = new Percolation(1);
        StdOut.println(percolation.percolates());
        percolation.open(1,1);
        StdOut.println(percolation.percolates());
        Percolation percolation2 = new Percolation(2);
        StdOut.println(percolation2.percolates());
        percolation2.open(1,1);
        StdOut.println(percolation2.percolates());
        percolation2.open(2,1);
        StdOut.println(percolation2.percolates());
    }
}