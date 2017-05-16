package com.tkamat.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 2048 board
 *
 * @author Tushaar Kamat
 */
public class Board2048 {

    public static final int BOARD_SIZE = 4;

    private int[][] board;
    private int score;
    private boolean movePossible;
    private boolean boardChanged;

    /**
     * Constructor for objects of Board2048 class
     */
    public Board2048() {
        this.board = new int[BOARD_SIZE][BOARD_SIZE];
        this.assignStartingNumbers(getRandomPoint(), getRandomPoint());
        this.score = 0;
        this.movePossible = true;
    }

    public int[][] getBoard() {
        return this.board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    /**
     * @return movePossible
     */
    public boolean isMovePossible() {
        return movePossible;
    }

    /**
     * @param movePossible
     *            the movePossible to set
     */
    public void setMovePossible(boolean movePossible) {
        this.movePossible = movePossible;
    }

    /**
     * @return the reallyChanged
     */
    public boolean isBoardChanged() {
        return boardChanged;
    }

    /**
     * @param reallyChanged
     *            the reallyChanged to set
     */
    public void setBoardChanged(boolean reallyChanged) {
        this.boardChanged = reallyChanged;
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score
     *            the score to set
     */
    public void setScore(int score) {
        this.score = score;
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
    public void addPossibleNumber() {
        List<Point> possiblePoints = new ArrayList<Point>();
        Random randNum = new Random();
        int num;
        int index = randNum.nextInt(11);
        if (index < 7) {
            num = 2;
        }
        else if (index < 9) {
            num = 4;
        }
        else {
            num = 8;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0)
                    possiblePoints.add(new Point(i, j));
            }

            if (possiblePoints.size() > 0) {
                Random rand = new Random();
                addNewNumber(possiblePoints.get(rand.nextInt(possiblePoints.size())), num);
            }
        }
    }

    public void movePoint(Point source, Point dest) {
        if (this.getValueAtPoint(dest) == 0) {
            board[dest.getRow()][dest.getCol()] = board[source.getRow()][source.getCol()];
            board[source.getRow()][source.getCol()] = 0;
            boardChanged = true;
        }
        else if (this.getValueAtPoint(source) == this.getValueAtPoint(dest)) {
            board[dest.getRow()][dest.getCol()] = board[source.getRow()][source.getCol()] * 2;
            board[source.getRow()][source.getCol()] = 0;
            score += this.getValueAtPoint(dest);
            boardChanged = true;
        }
    }

    public void moveLeft() {
        boardChanged = false;
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
        if (boardChanged) {
            addPossibleNumber();
        }
    }

    public void moveRight() {
        boardChanged = false;
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
        if (boardChanged) {
            addPossibleNumber();
        }
    }

    public void moveUp() {
        boardChanged = false;
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
        if (boardChanged) {
            addPossibleNumber();
        }
    }

    public void moveDown() {
        boardChanged = false;
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
        if (boardChanged) {
            addPossibleNumber();
        }
    }

    public void checkMovePossible() {
        int[][] oldBoard = new int[BOARD_SIZE][BOARD_SIZE];
        int sameCount = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                oldBoard[i][j] = board[i][j];
            }
        }
        moveLeft();
        moveRight();
        moveUp();
        moveDown();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == oldBoard[i][j])
                    sameCount++;
            }
        }
        if (sameCount == BOARD_SIZE * BOARD_SIZE)
            movePossible = false;
    }

}
