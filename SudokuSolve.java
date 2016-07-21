/*
 * File: SudokuSolve.java
 * Language: Java 8
 */

/* Imports */
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;


/**
 * The SudokuSolve class solves a sudoku puzzle given an initial board
 * configuration. The initial board and solution board are displayed 
 * to standard output.
 *
 * Usage: java SudokuSolve filename
 *
 * Note: the initial configuration specified by filename should be 
 * comma-separated, where each line represents a row on the board 
 * and empty cells are given an initial value of zero.
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
        
        // Read input file
        Path input_file = Paths.get(args[0]);
        System.out.println("Using the file "+input_file + " for input.");
        boolean good_file = Files.isRegularFile(input_file) &
                            Files.isReadable(input_file);
        if (!good_file) printError("invalid input file " + input_file);

        // Build the board
        GameBoard board = new GameBoard(input_file);
    }

    public static void printUsage()
    /**
     * Prints our usage message for the program.
     */
    {
        System.out.println("Usage: java SudokuSolve path_to_file");
        System.exit(0);
    }

    public static void printError(String err)
    {
        System.err.println("Error: "+err);
        System.exit(0);
    }
}
