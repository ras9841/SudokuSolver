/*
 * File: GameBoard.java
 * Languaige: Java 8
 */

import java.nio.file.Path;
import java.io.BufferedReader;
import java.io.FileReader;
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
    public GameBoard(Path init)
    {
        try (BufferedReader in = new BufferedReader(
                                    new FileReader(init.toString())))
        {
            String line;
            String[] a_line;
            while ((line = in.readLine()) != null)
            {
                a_line = line.split(",\\s+");
                System.out.println(Arrays.toString(a_line));
            }
        } 
        catch (Exception e)
        {
            e.printStackTrace();
        }
   }
}
