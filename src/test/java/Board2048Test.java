import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Random;


public class Board2048Test {

    private Board2048 test = new Board2048();

    @Test
    public void testBoardHasArray() {
        int[][] board = test.getBoard();
        assertEquals(board.length, 4);
        assertEquals(board[0].length, 4);
    }

    @Test
    public void testStartingValuesAssigned() {
        Point a = new Point(1, 2);
        Point b = new Point(0, 3);
        Point c = new Point(3, 2);
        test.assignStartingValues(a, b, c);
        int[][] board = test.getBoard();
        assertEquals(board[1][2], 2);
        assertEquals(board[0][3], 2);
        assertEquals(board[3][2], 2);
    }

    @Test
    public void testAddingNewValues() {

    }

}

