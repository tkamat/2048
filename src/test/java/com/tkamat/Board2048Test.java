package com.tkamat;

import org.junit.Test;
import static org.junit.Assert.*;

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
        Point c = new Point(3, 2);
        test.assignStartingNumbers(a, b, c);
        int[][] board = test.getBoard();
        assertEquals(board[1][2], 2);
        assertEquals(board[0][3], 2);
        assertEquals(board[3][2], 2);
    }

    @Test
    public void testAddingNewNumbers() {
        Board2048 test = new Board2048();
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
    public void testAddNumberFromEdge() {
        Board2048 test = new Board2048();
        test.clearBoard();
        test.addNumberFromEdge(2);
        for (int i = 0; i < test.getBoard().length; i++) {
            for (int j = 0; j < test.getBoard()[0].length; j++) {
                if (test.getBoard()[i][j] == 2) {
                    assertEquals(
                            (i == 0 || j == 0 || i == test.getBoard().length - 1 || j == test.getBoard().length - 1),
                            true);
                }
            }
        }
    }

    @Test
    public void testMovePoint() {
        Board2048 test = new Board2048();
    }

    @Test
    public void testMoveLeft() {
        Board2048 test = new Board2048();
    }
}
