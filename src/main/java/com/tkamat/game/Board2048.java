package com.tkamat.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 2048 board
 *
 * @author Tushaar Kamat
 */
public class Board2048 {

    private int[][] board;
    private static final int BOARD_SIZE = 4;

    /**
     * Constructor for objects of Board2048 class
     */
    public Board2048() {
        this.board = new int[BOARD_SIZE][BOARD_SIZE];
        this.assignStartingNumbers(getRandomPoint(), getRandomPoint());
    }

    public int[][] getBoard() {
        return this.board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public int getValueAtPoint(Point p) {
        return board[p.getRow()][p.getCol()];
    }

    /**
     * Returns a randomly selected point on the board
     *
     * @return random point on the board
     */
    public static Point getRandomPoint() {
        Random rand = new Random();
        return new Point(rand.nextInt(BOARD_SIZE), rand.nextInt(BOARD_SIZE));
    }

    public void clearBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = 0;
            }
        }
    }

    /**
     *
     *
     * @param a
     *            first point
     * @param b
     *            second point
     */
    public void assignStartingNumbers(Point a, Point b) {
        board[a.getRow()][a.getCol()] = 2;
        board[b.getRow()][b.getCol()] = 2;
    }

    /**
     * Adds a new number to board
     *
     * @param p
     *            Point where mum is added
     * @param num
     *            value of number to be added
     */
    public void addNewNumber(Point p, int num) {
        board[p.getRow()][p.getCol()] = num;
    }

    /**
     * Adds a number to the edge of the 2048 board
     *
     * @param num
     *            value of number to add
     */
    public void addNumberFromEdge(int num) {
        List<Point> possiblePoints = new ArrayList<Point>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1) {
                    if (board[i][j] == 0)
                        possiblePoints.add(new Point(i, j));
                }
            }

            Random rand = new Random();
            addNewNumber(possiblePoints.get(rand.nextInt(possiblePoints.size())), num);
        }
    }

    public void movePoint(Point source, Point dest) {
        if (this.getValueAtPoint(dest) == 0) {
            board[dest.getRow()][dest.getCol()] = board[source.getRow()][source.getCol()];
            board[source.getRow()][source.getCol()] = 0;
        }
        else if (this.getValueAtPoint(source) == this.getValueAtPoint(dest)) {
            board[dest.getRow()][dest.getCol()] = board[source.getRow()][source.getCol()] * 2;
            board[source.getRow()][source.getCol()] = 0;
        }
    }

    public void moveLeft() {
        Point currentPoint;
        int origNum;
        for (int col = 1; col < board[0].length; col++) {
            for (int row = 0; row < board.length; row++) {
                if (board[row][col] > 0) {
                    currentPoint = new Point(row, col);
                    origNum = board[row][col];
                    while (currentPoint.getCol() > 0 && this.getValueAtPoint(currentPoint) == origNum) {
                        this.movePoint(currentPoint, new Point(currentPoint.getRow(), currentPoint.getCol() - 1));
                        currentPoint = new Point(currentPoint.getRow(), currentPoint.getCol() - 1);
                    }
                }
            }
        }
    }

    public void moveRight() {
        Point currentPoint;
        int origNum;
        for (int col = 2; col >= 0; col--) {
            for (int row = 0; row < board.length; row++) {
                if (board[row][col] > 0) {
                    currentPoint = new Point(row, col);
                    origNum = board[row][col];
                    while (currentPoint.getCol() < 3 && this.getValueAtPoint(currentPoint) == origNum) {
                        this.movePoint(currentPoint, new Point(currentPoint.getRow(), currentPoint.getCol() + 1));
                        currentPoint = new Point(currentPoint.getRow(), currentPoint.getCol() + 1);
                    }
                }
            }
        }
    }

    public void moveUp() {
        Point currentPoint;
        int origNum;
        for (int row = 1; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] > 0) {
                    currentPoint = new Point(row, col);
                    origNum = board[row][col];
                    while (currentPoint.getRow() > 0 && this.getValueAtPoint(currentPoint) == origNum) {
                        this.movePoint(currentPoint, new Point(currentPoint.getRow() - 1, currentPoint.getCol()));
                        currentPoint = new Point(currentPoint.getRow() - 1, currentPoint.getCol());
                    }
                }
            }
        }
    }

    public void moveDown() {
        Point currentPoint;
        int origNum;
        for (int row = 2; row >= 0; row--) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] > 0) {
                    currentPoint = new Point(row, col);
                    origNum = board[row][col];
                    while (currentPoint.getRow() < 3 && this.getValueAtPoint(currentPoint) == origNum) {
                        this.movePoint(currentPoint, new Point(currentPoint.getRow() + 1, currentPoint.getCol()));
                        currentPoint = new Point(currentPoint.getRow() + 1, currentPoint.getCol());
                    }
                }
            }
        }
    }

}
