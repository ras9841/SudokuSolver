/*
 * File: GameBoard.java
 * Languaige: Java 8
 */

import java.nio.file.Path;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.Integer;
import java.lang.Exception;
import java.util.Arrays;

/**
 * The GameBoard class contains the solving algorithms and
 * initialization of the Sudoku game.
 *
 * @author Allen Sanford (ras9841@rit.edu)
 * @version 1.0
 * @since 07/21/16
 */
public class GameBoard
{
    private Cell[] board = new Cell[81];

    public GameBoard(Path init) throws Exception 
    /**
     * Constructs an instance of the GameBoard class given an input file.
     *
     * @param init system path to initial game state.
     */
    {
        BufferedReader in = new BufferedReader(
                                new FileReader(init.toString()));
        String line;
        String[] a_line;
        int num = 0;
        while ((line = in.readLine()) != null)
        {
            a_line = line.split(",");
            
            if (a_line.length != 9) throw new Exception("invalid input."); 
            
            for (String s : a_line)
            {
                int val = Integer.parseInt(s);
                if (val < 0 || val > 9) throw new Exception("invalid number.");
                
                this.board[num] = new Cell(val, num);
                num++;
            }
        }
        in.close();
        if (num != 81) throw new Exception("not enough cells specified.");
    }

    public void printState()
    /**
     * Prints the game board to standard output. Note that the top-left corner
     * when printed corresponds to first index in the board.
     */
    {
        int num = 1;
        for (Cell c : board)
        {
            String val = c.isEmpty() ? " " : Integer.toString(c.getValue()) ;

            if (num % 9 == 0) System.out.print(val+"\n");
            else if ( num % 3 == 0 ) System.out.print(val+" | ");
            else System.out.print(val+" ");

            if (num % 27 == 0) 
            {
                for (int i = 0; i<21; i++) System.out.print("-");
                System.out.print("\n");
            }

            num++;
        }
    }

    public boolean isValid(Cell c)
    /**
     * Does the given cell break any Sudoku rules?
     *
     * @param c the cell in question
     * @return true if valid, false if not
     */
    {
        return checkRow(c) && checkCol(c) && checkGrid(c);
    }

    public boolean noCopies(Cell[] vec)
    /**
     * Helper function for the isValid() checks that determines if there are
     * multiple instances of a number in a vector.
     *
     * @param vec array of cells to check
     * @return true if no copies, false if copies exist
     */
    {
        int[] marker = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (Cell cell : vec)
        {
            if (!cell.isEmpty())
            {
                marker[cell.getValue()-1]++;
            }
        }
        for (int i : marker)
        {
            if (i>1) return false;
        }
        return true;

    }

    public boolean checkRow(Cell c)
    /**
     * Is the row associated with the given cell valid?
     *
     * @param c the cell in question
     * @return true if valid, false if not
     */
    {
        int row_num = c.getNum()/9;
        Cell[] row = Arrays.copyOfRange(board, row_num*9, (row_num+1)*9);
        return noCopies(row);
    }
    
    public boolean checkCol(Cell c)
    /**
     * Is the column associated with the given cell valid?
     *
     * @param c the cell in question
     * @return true if valid, false if not
     */
    {
        int col_num = c.getNum()%9;
        Cell[] col = new Cell[9];
        for (int r = 0; r<9; r++)
        {
            col[r] = board[9*r+col_num];
        }
        return noCopies(col);
    }
    
    public boolean checkGrid(Cell c)
    /**
     * Is the 3x3 grid associated with the given cell valid?
     *
     * @param c the cell in question
     * @return true if valid, false if not
     */
    {
        int grid_row = (c.getNum()/9)/3;
        int grid_col = (c.getNum()%9)/3;

        // Index of the top-left grid corner
        int nw_corner = 27*grid_row+grid_col*3;
        
        int n  = 0, off;
        Cell[] grid = new Cell[9];
        for (int i=0; i<3; i++) //rows
        {
            for (int j=0; j<3; j++) //cols
            {
                off = 9*i+j;
                grid[n] = board[nw_corner+off];
                n++;
            }
        }
        return noCopies(grid);
    }
    
    public Cell nextEmpty()
    /**
     * Finds the next empty cell on the board.
     *
     * @return empty cell, null if all spots on board are full
     */
    {
        for (Cell c : board)
        {
            if (c.isEmpty())
            {
                return c;
            }
        }
        return null;
    }

    public boolean solve(boolean debug)
    /**
     * Main solution method for the Sudoku puzzle using backtracking.
     *
     * @param debug if true, the board state will be printed each iteration.
     * @return is the board solved?
     */
    {
        Cell c = nextEmpty();
        if (c == null) return true;

        if (c.isEmpty())
        {
            for (int i = 1; i<10; i++)
            {
                c.setValue(i);
                if (isValid(c))
                {
                    if (debug)
                    {
                        System.out.print("\n");
                        printState();
                        System.out.print("\n");
                    }
                    if (solve(debug)) return true;
                }
                c.setValue(0); // backtrack
            }
        }
        
        return false;
    }


}
