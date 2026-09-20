package org.tictactoe;

import java.util.*;

public class TicTacToe
{
    final private char[][] board;

    /// @param board The game board
    public TicTacToe(char[][] board)
    {
        // Assume board is valid
        this.board = board;
    }

    /// Checks the board for a winner
    ///
    /// Checks 4 corners, by row, by column, by diagonals, and by 2x2 square
    /// The 2x2 square is assumed to be of a fixed spot similar to Sudoku style boxes
    ///
    /// @return The winner of the game or null if no winner
    public char checkWinner()
    {
        // Check the four corners have the same value and return the value
        // Use n so this can be expanded to nxn board
        int n = board.length;
        if (board[0][0] != '-' && (board[0][0] == board[0][n - 1]) &&
                (board[0][n - 1] == board[n - 1][n - 1]) &&
                (board[n - 1][n - 1] == board[n - 1][0]))
        {
            return board[0][0];
        }

        // arr[0] = x, arr[1] = 0
        Map<Integer, int[]> rows = new HashMap<>();
        Map<Integer, int[]> cols = new HashMap<>();
        // use 1 for LR diagonal and 2 for RL diagonal
        Map<Integer, int[]> diagonals = new HashMap<>();
        // Assume 2x2 is sudoku style for now
        Map<Integer, int[]> boxes = new HashMap<>();

        for (int row = 0; row < n; row++)
        {
            if (!rows.containsKey(row))
            {
                rows.put(row, new int[2]);
            }
            for (int col = 0; col < n; col++)
            {
                if (!cols.containsKey(col))
                {
                    cols.put(col, new int[2]);
                }
                // If it's an x or o and not a -
                if (isTaken(row, col))
                {
                    int index = board[row][col] == 'x' ? 0 : 1;
                    (rows.get(row))[index]++;
                    (cols.get(col))[index]++;

                    // Is there a way to make the box index more generic?
                    int boxIndex = (row / 2) * 2 + col / 2;
                    if (!boxes.containsKey(boxIndex))
                    {
                        boxes.put(boxIndex, new int[2]);
                    }
                    (boxes.get(boxIndex))[index]++;

                    if (row == col)
                    {
                        if (!diagonals.containsKey(1))
                        {
                            diagonals.put(1, new int[2]);
                        }
                        (diagonals.get(1))[index]++;
                    }
                    else if (row + col == board.length - 1)
                    {
                        if (!diagonals.containsKey(2))
                        {
                            diagonals.put(2, new int[2]);
                        }
                        (diagonals.get(2))[index]++;
                    }
                }
            }
        }

        for (int[] row : rows.values())
        {
            if (row[0] == 4)
            {
                return 'x';
            }
            else if (row[1] == 4)
            {
                return 'o';
            }
        }

        for (int[] col : cols.values())
        {
            if (col[0] == 4)
            {
                return 'x';
            }
            else if (col[1] == 4)
            {
                return 'o';
            }
        }

        for (int[] diagonal : diagonals.values())
        {
            if (diagonal[0] == 4)
            {
                return 'x';
            }
            else if (diagonal[1] == 4)
            {
                return 'o';
            }
        }

        for (int[] box : boxes.values())
        {
            if (box[0] == 4)
            {
                return 'x';
            }
            else if (box[1] == 4)
            {
                return 'o';
            }
        }

        // If there was no winner, return null
        return '\0';
    }

    /// @param row
    /// @param col
    /// @return If the queried spot has been played
    private boolean isTaken(int row, int col)
    {
        return this.board[row][col] != '-';
    }

    /// @return If there are any unplayed spots
    public boolean isMoveRemaining()
    {
        // Iterate over board and check for '-' which indicates unplayed spot
        for (int row = 0; row < this.board.length; row++)
        {
            for (int col = 0; col < this.board[0].length; col++)
            {
                if (this.board[row][col] == '-')
                {
                    return true;
                }
            }
        }
        // If didn't find an unplayed spots return false
        return false;
    }

    /// @return If there's either a winner or no moves left
    public boolean isGameOver()
    {
        // If there's a winner or if there's no moves left, game is over
        return checkWinner() != '\0' || !isMoveRemaining();
    }
}
