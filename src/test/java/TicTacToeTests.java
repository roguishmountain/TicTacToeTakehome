import org.tictactoe.TicTacToe;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTests {

    char[][] fourCorners = {
            {'x', 'o', '-', 'x'},
            {'-', 'o', '-', '-'},
            {'-', '-', 'o', 'x'},
            {'x', '-', 'o', 'x'},
    };

    char[][] horizontal = {
            {'x', 'x', 'x', 'x'},
            {'-', 'o', '-', '-'},
            {'-', '-', 'o', '-'},
            {'-', 'o', '-', 'o'},
    };

    char[][] horizontal2 = {
            {'x', 'x', 'x', 'o'},
            {'x', '-', 'o', '-'},
            {'o', 'o', 'o', 'o'},
            {'-', '-', 'x', 'x'},
    };

    char[][] diagonalLeftRight = {
            {'x', 'o', 'o', 'x'},
            {'o', 'x', 'o', '-'},
            {'-', 'o', 'x', '-'},
            {'-', '-', '-', 'x'},
    };

    char[][] diagonalRightLeft = {
            {'-', '-', 'x', 'o'},
            {'-', 'x', 'o', '-'},
            {'x', 'o', '-', '-'},
            {'o', '-', '-', '-'},
    };

    char[][] stalemate = {
            {'x', 'o', 'x', 'o'},
            {'o', 'x', 'o', 'x'},
            {'x', 'o', 'x', 'o'},
            {'x', 'o', 'x', 'o'},
    };

    char[][] vertical = {
            {'-', 'o', '-', 'x'},
            {'-', '-', 'o', 'x'},
            {'-', '-', 'o', 'x'},
            {'-', '-', 'o', 'x'},
    };

    char[][] vertical2 = {
            {'-', 'o', 'x', '-'},
            {'-', 'o', '-', 'x'},
            {'-', 'o', '-', 'x'},
            {'-', 'o', 'x', '-'},
    };

    char[][] box = {
            {'x', 'o', 'o', 'x'},
            {'-', 'o', 'o', '-'},
            {'-', '-', '-', '-'},
            {'x', 'x', '-', '-'},
    };

    char[][] box2 = {
            {'-', '-', 'x', '-'},
            {'-', '-', '-', 'x'},
            {'x', '-', 'o', 'o'},
            {'-', '-', 'o', 'o'},
    };

    char[][] inProgress = {
            {'x', '-', '-', '-'},
            {'x', '-', 'o', '-'},
            {'x', '-', 'o', '-'},
            {'-', '-', 'o', '-'},
    };

    @Test
    void checkFourCorners() {
        TicTacToe ttt = new TicTacToe(fourCorners);
        assertEquals('x', ttt.checkWinner());
        assertTrue(ttt.isMoveRemaining());
        assertTrue(ttt.isGameOver());
    }

    @Test
    void checkHorizontal() {
        TicTacToe ttt = new TicTacToe(horizontal);
        assertEquals('x', ttt.checkWinner());
        assertTrue(ttt.isMoveRemaining());
        assertTrue(ttt.isGameOver());
    }

    @Test
    void checkHorizontal2() {
        TicTacToe ttt = new TicTacToe(horizontal2);
        assertEquals('o', ttt.checkWinner());
        assertTrue(ttt.isMoveRemaining());
        assertTrue(ttt.isGameOver());
    }

    @Test
    void checkDiagonalLeftRight() {
        TicTacToe ttt = new TicTacToe(diagonalLeftRight);
        assertEquals('x', ttt.checkWinner());
        assertTrue(ttt.isMoveRemaining());
        assertTrue(ttt.isGameOver());
    }

    @Test
    void checkDiagonalRightLeft() {
        TicTacToe ttt = new TicTacToe(diagonalRightLeft);
        assertEquals('o', ttt.checkWinner());
        assertTrue(ttt.isMoveRemaining());
        assertTrue(ttt.isGameOver());
    }

    @Test
    void checkStalemate() {
        TicTacToe ttt = new TicTacToe(stalemate);
        assertEquals(null, ttt.checkWinner());
        assertFalse(ttt.isMoveRemaining());
        assertTrue(ttt.isGameOver());
    }

    @Test
    void checkVertical() {
        TicTacToe ttt = new TicTacToe(vertical);
        assertEquals('x', ttt.checkWinner());
        assertTrue(ttt.isMoveRemaining());
        assertTrue(ttt.isGameOver());
    }

    @Test
    void checkVertical2() {
        TicTacToe ttt = new TicTacToe(vertical2);
        assertEquals('o', ttt.checkWinner());
        assertTrue(ttt.isMoveRemaining());
        assertTrue(ttt.isGameOver());
    }

    @Test
    void checkBox() {
        TicTacToe ttt = new TicTacToe(box);
        assertEquals('o', ttt.checkWinner());
        assertTrue(ttt.isMoveRemaining());
        assertTrue(ttt.isGameOver());
    }

    @Test
    void checkBox2() {
        TicTacToe ttt = new TicTacToe(box2);
        assertEquals('o', ttt.checkWinner());
        assertTrue(ttt.isMoveRemaining());
        assertTrue(ttt.isGameOver());
    }

    @Test
    void checkInProgress() {
        TicTacToe ttt = new TicTacToe(inProgress);
        assertEquals(null, ttt.checkWinner());
        assertTrue(ttt.isMoveRemaining());
        assertFalse(ttt.isGameOver());
    }
}