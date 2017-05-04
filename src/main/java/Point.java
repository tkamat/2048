/**
 * Represents an ordered pair
 *
 * @author Tushaar Kamat
 */
public class Point {

    int row;
    int col;

    /**
     * @param x
     *            x coordinate
     * @param y
     *            y coordinate
     */
    public Point(int x, int y) {
        this.row = x;
        this.col = y;
    }

    /**
     * @return the x
     */
    public int getRow() {
        return row;
    }

    /**
     * @param x the x to set
     */
    public void setRow(int x) {
        this.row = x;
    }

    /**
     * @return the y
     */
    public int getCol() {
        return col;
    }

    /**
     * @param y the y to set
     */
    public void setCol(int y) {
        this.col = y;
    }

}
