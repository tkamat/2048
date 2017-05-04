import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Random;


public class Board2048Test {
    @Test
    public void testBoardHasArray() {
        Board2048 test = new Board2048();
        int[][] board = test.getBoard();
        assertEquals(board.length, 4);
        assertEquals(board[0].length, 4);
    }

    @Test
    public void testStartingValuesAssigned() {
        Board2048 test = new Board2048();
        Point a = new Point(1, 2);
        Point b = new Point(0, 3);
        Point c = new Point(3, 2);
        test.assignStartingValues(a, b, c);
        int[][] board = test.getBoard();
        assertEquals(board[1][2], 2);
        assertEquals(board[0][3], 2);
        assertEquals(board[3][2], 2);
    }

}

