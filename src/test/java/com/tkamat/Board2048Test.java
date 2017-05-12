package com.tkamat;

import org.junit.Test;
import static org.junit.Assert.*;

import com.tkamat.game.Board2048;
import com.tkamat.game.Point;

public class Board2048Test {

    @Test
    public void testBoardHasArray() {
        Board2048 test = new Board2048();
        int[][] board = test.getBoard();
        assertEquals(board.length, 4);
        assertEquals(board[0].length, 4);
    }

    @Test
    public void testStartingNumbers() {
        Board2048 test = new Board2048();
        Point a = new Point(1, 2);
        Point b = new Point(0, 3);
        test.assignStartingNumbers(a, b);
        int[][] board = test.getBoard();
        assertEquals(board[1][2], 2);
        assertEquals(board[0][3], 2);
    }

    @Test
    public void testAddingNewNumbers() {
        Board2048 test = new Board2048();
        test.clearBoard();
        Point addPoint = new Point(3, 3);
        test.addNewNumber(addPoint, 2);
        assertEquals(test.getBoard()[3][3], 2);
    }

    @Test
    public void testClearBoard() {
        Board2048 test = new Board2048();
        test.clearBoard();
        for (int i = 0; i < test.getBoard().length; i++) {
            for (int j = 0; j < test.getBoard()[0].length; j++) {
                assertEquals(test.getBoard()[i][j], 0);
            }
        }
    }

    @Test
    public void testMovePointWithEmtpyDest() {
        Board2048 test = new Board2048();
        test.clearBoard();
        Point source = new Point(2, 1);
        Point dest = new Point(2, 0);
        test.addNewNumber(source, 2);
        test.movePoint(source, dest);
        assertEquals(test.getValueAtPoint(dest), 2);
        assertEquals(test.getValueAtPoint(source), 0);
    }

    @Test
    public void testMovePointCombineNumber() {
        Board2048 test = new Board2048();
        test.clearBoard();
        Point source = new Point(2, 1);
        Point dest = new Point(2, 0);
        test.addNewNumber(source, 2);
        test.addNewNumber(dest, 2);
        test.movePoint(source, dest);
        assertEquals(test.getValueAtPoint(dest), 4);
        assertEquals(test.getValueAtPoint(source), 0);
    }

    @Test
    public void testMovePointNotCombineNumber() {
        Board2048 test = new Board2048();
        test.clearBoard();
        Point source = new Point(2, 1);
        Point dest = new Point(2, 0);
        test.addNewNumber(source, 2);
        test.addNewNumber(dest, 4);
        test.movePoint(source, dest);
        assertEquals(test.getValueAtPoint(dest), 4);
        assertEquals(test.getValueAtPoint(source), 2);
    }

    @Test
    public void testMoveLeftSingle() {
        Board2048 test = new Board2048();
        test.clearBoard();
        Point p = new Point(1, 2);
        test.addNewNumber(p, 2);
        test.moveLeft();
        assertEquals(test.getValueAtPoint(new Point(1, 0)), 2);
    }

    @Test
    public void testMoveLeftDoNothing() {
        Board2048 test = new Board2048();
        test.clearBoard();
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 1);
        test.addNewNumber(p1, 4);
        test.addNewNumber(p2, 2);
        test.moveLeft();
        assertEquals(test.getValueAtPoint(p1), 4);
        assertEquals(test.getValueAtPoint(p2), 2);
    }

    @Test
    public void testMoveLeftFullRow() {
        Board2048 test = new Board2048();
        test.clearBoard();
        int[][] board = { { 2, 2, 2, 2 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
        test.setBoard(board);
        test.moveLeft();
        assertEquals(test.getValueAtPoint(new Point(0, 0)), 4);
        assertEquals(test.getValueAtPoint(new Point(0, 1)), 4);
    }

    @Test
    public void testMoveRightSingle() {
        Board2048 test = new Board2048();
        test.clearBoard();
        Point p = new Point(1, 1);
        test.addNewNumber(p, 2);
        test.moveRight();
        assertEquals(test.getValueAtPoint(new Point(1, 3)), 2);
    }

    @Test
    public void testMoveRightDoNothing() {
        Board2048 test = new Board2048();
        test.clearBoard();
        Point p1 = new Point(0, 3);
        Point p2 = new Point(0, 2);
        test.addNewNumber(p1, 4);
        test.addNewNumber(p2, 2);
        test.moveRight();
        assertEquals(test.getValueAtPoint(p1), 4);
        assertEquals(test.getValueAtPoint(p2), 2);
    }

    @Test
    public void testMoveRightFullRow() {
        Board2048 test = new Board2048();
        test.clearBoard();
        int[][] board = { { 2, 2, 2, 2 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
        test.setBoard(board);
        test.moveRight();
        assertEquals(test.getValueAtPoint(new Point(0, 3)), 4);
        assertEquals(test.getValueAtPoint(new Point(0, 2)), 4);
    }

    @Test
    public void testMoveUpSingle() {
        Board2048 test = new Board2048();
        test.clearBoard();
        Point p = new Point(1, 1);
        test.addNewNumber(p, 2);
        test.moveUp();
        assertEquals(test.getValueAtPoint(new Point(0, 1)), 2);
    }

    @Test
    public void testMoveUpDoNothing() {
        Board2048 test = new Board2048();
        test.clearBoard();
        Point p1 = new Point(0, 2);
        Point p2 = new Point(1, 2);
        test.addNewNumber(p1, 4);
        test.addNewNumber(p2, 2);
        test.moveUp();
        assertEquals(test.getValueAtPoint(p1), 4);
        assertEquals(test.getValueAtPoint(p2), 2);
    }

    @Test
    public void testMoveUpFullRow() {
        Board2048 test = new Board2048();
        test.clearBoard();
        int[][] board = { { 2, 0, 0, 0 }, { 2, 0, 0, 0 }, { 2, 0, 0, 0 }, { 2, 0, 0, 0 } };
        test.setBoard(board);
        test.moveUp();
        assertEquals(test.getValueAtPoint(new Point(0, 0)), 4);
        assertEquals(test.getValueAtPoint(new Point(1, 0)), 4);
    }

    @Test
    public void testMoveDownSingle() {
        Board2048 test = new Board2048();
        test.clearBoard();
        Point p = new Point(1, 1);
        test.addNewNumber(p, 2);
        test.moveDown();
        assertEquals(test.getValueAtPoint(new Point(3, 1)), 2);
    }

    @Test
    public void testMoveDownDoNothing() {
        Board2048 test = new Board2048();
        test.clearBoard();
        Point p1 = new Point(3, 2);
        Point p2 = new Point(2, 2);
        test.addNewNumber(p1, 4);
        test.addNewNumber(p2, 2);
        test.moveDown();
        assertEquals(test.getValueAtPoint(p1), 4);
        assertEquals(test.getValueAtPoint(p2), 2);
    }

    @Test
    public void testMoveDownFullRow() {
        Board2048 test = new Board2048();
        test.clearBoard();
        int[][] board = { { 2, 0, 0, 0 }, { 2, 0, 0, 0 }, { 2, 0, 0, 0 }, { 2, 0, 0, 0 } };
        test.setBoard(board);
        test.moveDown();
        assertEquals(test.getValueAtPoint(new Point(3, 0)), 4);
        assertEquals(test.getValueAtPoint(new Point(2, 0)), 4);
    }

    @Test
    public void testScoring() {
        Board2048 test = new Board2048();
        test.clearBoard();
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 1);
        test.addNewNumber(p1, 2);
        test.addNewNumber(p2, 2);
        test.moveLeft();
        assertEquals(test.getScore(), 4);
    }

    @Test
    public void testMovePossible() {
        Board2048 test = new Board2048();
        test.clearBoard();
        int[][] board = { {2, 4, 8, 16},
                          {16, 8, 4, 2},
                          {2, 4, 8, 16},
                          {16, 8, 4, 2} };
        test.setBoard(board);
        test.checkMovePossible();
        assertEquals(test.isMovePossible(), false);
    }
}
