
import java.util.Random;
/**
 * 2048 board
 *
 * @author Tushaar Kamat
 */
public class Board2048 {

    private int[][] board;

    /**
     * Constructor for objects of Board2048 class
     */
    public Board2048() {
        this.board = new int[4][4];
        Random rand = new Random();
        Point a = new Point(rand.nextInt(4), rand.nextInt(4));
        Point b = new Point(rand.nextInt(4), rand.nextInt(4));
        Point c = new Point(rand.nextInt(4), rand.nextInt(4));

        this.assignStartingValues(a, b, c);
    }

    public int[][] getBoard() {
        return this.board;
    }

    public void assignStartingValues(Point a, Point b, Point c) {
        board[a.getRow()][a.getCol()] = 2;
        board[b.getRow()][b.getCol()] = 2;
        board[c.getRow()][c.getCol()] = 2;
    }
}

