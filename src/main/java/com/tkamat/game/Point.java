package com.tkamat.game;

/**
 * Represents an ordered pair
 *
 * @author Tushaar Kamat
 */
public class Point {

    int row;
    int col;

    /**
     * @param row
     *            x coordinate
     * @param col
     *            y coordinate
     */
    public Point(int row, int col) {
        this.row = row;
        this.col = col;
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
