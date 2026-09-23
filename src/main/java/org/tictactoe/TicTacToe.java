package org.tictactoe;

import java.util.*;

public class TicTacToe
{
    final private char[][] board;
    final private int n;
    final private int[][] directions = new int[][]{{1, 0}, {0, 1}, {1, 1}};

    /// @param board The game board
    public TicTacToe(char[][] board)
    {
        // Assume board is valid
        this.board = board;
        n = this.board.length;
    }

    /// Checks the board for a winner
    ///
    /// Checks by 4 corners, by row, by column, by diagonals, and by 2x2 square
    ///
    /// @return The winner of the game or null if no winner
    public Character checkWinner()
    {
        // Check the four corners have the same value and return the value
        if (isTaken(0, 0) && (board[0][0] == board[0][n - 1]) &&
                (board[0][n - 1] == board[n - 1][n - 1]) &&
                (board[n - 1][n - 1] == board[n - 1][0]))
        {
            return board[0][0];
        }

        // arr[0] = x, arr[1] = o
        Map<Integer, int[]> rows = new HashMap<>();
        Map<Integer, int[]> cols = new HashMap<>();
        // use 1 for LR diagonal and 2 for RL diagonal
        Map<Integer, int[]> diagonals = new HashMap<>();

        for (int row = 0; row < n; row++)
        {
            for (int col = 0; col < n; col++)
            {
                // If it's an x or o and not a -
                if (isTaken(row, col))
                {
                    if (!cols.containsKey(col))
                    {
                        cols.put(col, new int[2]);
                    }

                    if (!rows.containsKey(row))
                    {
                        rows.put(row, new int[2]);
                    }

                    int index = board[row][col] == 'x' ? 0 : 1;
                    // Check the row and column
                    (rows.get(row))[index]++;
                    (cols.get(col))[index]++;

                    // If we found n in a row/col, we don't need to check the rest of the board
                    if ((rows.get(row))[index] == n || (cols.get(col))[index] == n)
                    {
                        return board[row][col];
                    }

                    // Check the 2x2 box
                    // We don't need to check the last row and col because that is out of bounds/redundant
                    if (row < n - 1 && col < n - 1)
                    {
                        // Can also do this in way similar to checking the four corners such as
                        // if (board[row][col] == board[row + 1][col] && board[row + 1][col]...)
                        boolean isMatch = true;
                        char match = board[row][col];
                        for (int[] direction : directions)
                        {
                            if (match != board[row + direction[0]][col + direction[1]])
                            {
                                isMatch = false;
                                break;
                            }
                        }

                        // If there's a winner we don't need to check the rest of the board
                        if (isMatch)
                        {
                            return board[row][col];
                        }
                    }

                    // Check the diagonal
                    if (row == col)
                    {
                        if (!diagonals.containsKey(1))
                        {
                            diagonals.put(1, new int[2]);
                        }
                        (diagonals.get(1))[index]++;

                        // If we found n in a diagonal, we don't need to check the rest of the board
                        if ((diagonals.get(1))[index] == n)
                        {
                            return board[row][col];
                        }
                    }
                    // Check the other diagonal
                    if (row + col == n - 1)
                    {
                        if (!diagonals.containsKey(2))
                        {
                            diagonals.put(2, new int[2]);
                        }
                        (diagonals.get(2))[index]++;

                        // If we found n in a diagonal, we don't need to check the rest of the board
                        if ((diagonals.get(2))[index] == n)
                        {
                            return board[row][col];
                        }
                    }
                }
            }
        }

        // If there was no winner, return null
        return null;
    }

    /// @param row The row that is being checked
    /// @param col The col that is being checked
    /// @return If the queried spot has been played
    private boolean isTaken(int row, int col)
    {
        return this.board[row][col] != '-';
    }

    /// @return If there are any unplayed spots
    public boolean isMoveRemaining()
    {
        // Iterate over board and check for '-' which indicates unplayed spot
        for (int row = 0; row < n; row++)
        {
            for (int col = 0; col < n; col++)
            {
                if (this.board[row][col] == '-')
                {
                    return true;
                }
            }
        }
        // If no unplayed spots return false
        return false;
    }

    /// @return If there's either a winner or no moves left
    public boolean isGameOver()
    {
        // If there's a winner or if there's no moves left, game is over
        return checkWinner() != null || !isMoveRemaining();
    }
}
