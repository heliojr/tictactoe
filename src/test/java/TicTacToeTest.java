import org.junit.Assert;
import org.junit.Test;
import roche.TicTacToe;

/**
 * Created by helio on 20/7/17.
 */
public class TicTacToeTest {

    @Test
    public void EmptyBoard()
    {
        char[][] board = new char[][]{{' ',' ',' '}, {' ',' ',' '}, {' ',' ',' '}};
        TicTacToe tic = new TicTacToe('X' , 'O' , board);
        tic.getComputerMove();
        Assert.assertArrayEquals(new char[][]{{'O',' ',' '}, {' ',' ',' '}, {' ',' ',' '}},
                tic.getBoard());
    }

    @Test
    public void FullBoard()
    {
        char[][] board = new char[][]{{'X','X','X'}, {'X','X','X'}, {'X','X','X'}};
        TicTacToe tic = new TicTacToe('X' , 'O' , board);
        tic.getComputerMove();
        Assert.assertArrayEquals(board, tic.getBoard());
    }

    @Test
    public void OneMissingSpot()
    {
        char[][] board = new char[][]{{'X','X','X'}, {'X','X','X'}, {'X',' ','X'}};
        TicTacToe tic = new TicTacToe('X' , 'O' , board);
        tic.getComputerMove();
        Assert.assertArrayEquals(new char[][]{{'X','X','X'}, {'X','X','X'}, {'X','O','X'}},
                tic.getBoard());
    }

    @Test
    public void ComputerWinnerRowMove()
    {
        char[][] board = new char[][]{{'X','X',' '}, {' ','O',' '}, {'O','O',' '}};
        TicTacToe tic = new TicTacToe('X' , 'O' , board);
        tic.getComputerMove();
        Assert.assertArrayEquals(new char[][]{{'X','X','O'}, {' ','O',' '}, {'O','O',' '}},
                tic.getBoard());
    }

    @Test
    public void ComputerWinnerColumnMove()
    {
        char[][] board = new char[][]{{'O',' ',' '}, {'O','X',' '}, {' ',' ',' '}};
        TicTacToe tic = new TicTacToe('X' , 'O' , board);
        tic.getComputerMove();
        Assert.assertArrayEquals(new char[][]{{'O',' ',' '}, {'O','X',' '}, {'O',' ',' '}},
                tic.getBoard());
    }

    @Test
    public void PlayerWinnerRowMove()
    {
        char[][] board = new char[][]{{'X','X',' '}, {'O',' ',' '}, {'O',' ',' '}};
        TicTacToe tic = new TicTacToe('X' , 'O' , board);
        tic.getComputerMove();
        Assert.assertArrayEquals(new char[][]{{'X','X','O'}, {'O',' ',' '}, {'O',' ',' '}},
                tic.getBoard());
    }

    @Test
    public void PlayerWinnerColumnMove()
    {
        char[][] board = new char[][]{{'X','O','O'}, {'X',' ',' '}, {' ',' ',' '}};
        TicTacToe tic = new TicTacToe('X' , 'O' , board);
        tic.getComputerMove();
        Assert.assertArrayEquals(new char[][]{{'X','O','O'}, {'X',' ',' '}, {'O',' ',' '}},
                tic.getBoard());
    }

    @Test
    public void Diagonal1WinnerMove()
    {
        char[][] board = new char[][]{{'X','O',' '}, {' ','X',' '}, {' ',' ',' '}};
        TicTacToe tic = new TicTacToe('X' , 'O' , board);
        tic.getComputerMove();
        Assert.assertArrayEquals(new char[][]{{'X','O',' '}, {' ','X',' '}, {' ',' ','O'}},
                tic.getBoard());
    }

    @Test
    public void Diagonal2WinnerMove()
    {
        char[][] board = new char[][]{{' ','O',' '}, {' ','X',' '}, {' ',' ','X'}};
        TicTacToe tic = new TicTacToe('X' , 'O' , board);
        tic.getComputerMove();
        Assert.assertArrayEquals(new char[][]{{'O','O',' '}, {' ','X',' '}, {' ',' ','X'}},
                tic.getBoard());
    }

}
