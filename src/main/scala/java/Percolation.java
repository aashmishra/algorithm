import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int totalLength;
    private boolean [] isitOpen;
    private WeightedQuickUnionUF percolation;
    private int topLevelIndex;
    private int bottomLevelIndex;
    private int openSitesCount;
    private WeightedQuickUnionUF fullness;

    private int index(int row, int col){
            validate(row,col);
            return (row-1)*totalLength+(col);
    }

    private void validate(int row, int col)
    {
        if (row>totalLength || row < 1 )
        {
            throw new IndexOutOfBoundsException("row index i out of bounds");
        }
        if (col>totalLength || col<1)
        {
            throw new IndexOutOfBoundsException("column index j out of bounds");
        }
    }
    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n){
        if(n<1){
            throw new IllegalArgumentException();
        }
        totalLength = n;
        int arraySize = n*n+2;
        isitOpen = new boolean[arraySize];
        topLevelIndex = 0;
        bottomLevelIndex = n*n+1;
        isitOpen[topLevelIndex] = true;
        isitOpen[bottomLevelIndex] = true;
        percolation = new WeightedQuickUnionUF(arraySize);
        fullness = new WeightedQuickUnionUF(arraySize);
        for(int i=1; i<=n;i++){

            int topSiteIndex = index(1,i);
            percolation.union(topLevelIndex,topSiteIndex);
            fullness.union(topLevelIndex,topSiteIndex);
            percolation.union(bottomLevelIndex,index(n,i));

        }
        openSitesCount=0;


    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col){
        int currentIndex = index(row,col);
        if(!isitOpen[currentIndex]){
            isitOpen[currentIndex]=true;
            openSitesCount+=1;
        if(col>1 && isOpen(row,col-1)){
            int indexToLeft = index(row,col-1);
            percolation.union(currentIndex,indexToLeft);
            fullness.union(currentIndex,indexToLeft);
        }
        if(col<totalLength && isOpen(row,col+1)){
            int indexToRight = index(row,col+1);
            percolation.union(currentIndex,indexToRight);
            fullness.union(currentIndex,indexToRight);
        }
        if(row<totalLength && isOpen(row+1,col)){
            int indexToBottom = index(row+1,col);
            percolation.union(currentIndex,indexToBottom);
            fullness.union(currentIndex,indexToBottom);
        }
        if(row>1 && isOpen(row-1,col)){
            int indexToTop = index(row-1,col);
            percolation.union(currentIndex,indexToTop);
            fullness.union(currentIndex,indexToTop);
        }
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col){
        return isitOpen[index(row,col)];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col){
        int currentIndex  = index(row,col);
        return (fullness.connected(topLevelIndex,currentIndex) && isitOpen[currentIndex]);
    }

    // returns the number of open sites
    public int numberOfOpenSites(){
        return openSitesCount;
    }

    // does the system percolate?
    public boolean percolates(){
        if (totalLength>1) {
        return percolation.connected(topLevelIndex,bottomLevelIndex);}
        else{
            return isitOpen[index(1,1)];
        }
    }

    // test client (optional)
    public static void main(String[] args){
    }
}
