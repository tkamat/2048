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
        this.assignStartingNumbers(getRandomPoint(), getRandomPoint(), getRandomPoint());
    }

    public int[][] getBoard() {
        return this.board;
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
     * @param c
     *            third point
     */
    public void assignStartingNumbers(Point a, Point b, Point c) {
        board[a.getRow()][a.getCol()] = 2;
        board[b.getRow()][b.getCol()] = 2;
        board[c.getRow()][c.getCol()] = 2;
    }

    /**
     * Adds a new number to board
     *
     * @param a
     *            Point where mum is added
     * @param num
     *            value of number to be added
     */
    public void addNewNumber(Point a, int num) {
        board[a.getRow()][a.getCol()] = num;
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
}
