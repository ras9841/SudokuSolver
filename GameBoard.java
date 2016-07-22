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
                
                this.board[num] = new Cell(val, num+1);
                num++;
            }
        }
        in.close();
    }

    public void printState()
    {
        int num = 1;
        for (Cell c : this.board)
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

    public boolean isFull(Cell[] board)
    {
        for (Cell c : board)
        {
            if (c.isEmpty()) return false;
        }
        return true;
    }

    public boolean isValid(Cell c, Cell[] b)
    {
        return checkRow(c,b) && checkCol(c,b) && checkGrid(c,b);
    }

    public boolean checkRow(Cell c, Cell[] b)
    {
        return true;
    }
    
    public boolean checkCol(Cell c, Cell[] b)
    {
        return true;
    }
    
    public boolean checkGrid(Cell c, Cell[] b)
    {
        return true;
    }
    
    public boolean solve()
    {
        if (isFull(board)) return true;
        
        for (Cell c : board)
        {
            if (c.isEmpty())
            {
                for (int i = 1; i<10; i++)
                {
                    c.setValue(i);
                    if (isValid(c, board))
                    {
                        if (solve()) return true;
                    }
                    c.setValue(0);
                }
            }
        }

        return false;
    }


}
