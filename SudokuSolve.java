/*
 * File:    ReplaceChars.java
 * Language: Java 8
 */

/**
 * The SudokuSolve class solves a sudoku puzzle given an initial board
 * configuration. The initial board and solution board are displayed 
 * to standard output.
 *
 * Usage: java SudokuSolve filename
 *
 * Note: the initial configuration specified by filename should be 
 * comma-separated, where each line represents a row on the board.
 *
 * @author Allen Sanford (ras9841@rit.edu)
 * @version 1.0
 * @since 07/20/16
 */
public class SudokuSolve
{
    public static void main(String[] args)
    /**
     * Reads in initial board configuration, runs the solver, and 
     * displays the results to standard output.
     *
     * @param args commandline arguments (filename)
     */
    {
        if (args.length != 1)  printUsage();
        

    }

    public static void printUsage()
    /**
     * Prints our usage message for the program.
     */
    {
        System.out.println("Usage: java SudokuSolve filename");
        System.exit(0);
    }
}
