/*
 * File: Cell.java
 * Language: Java 8
 */

/**
 * The Cell class represents one block on the Sudoku board.
 *
 * @author Allen Sanford (ras9841@rit.edu)
 * @version 1.0
 * @since 07/21/16
 */
public class Cell
{
    private int num;            // Board number [0,80]
    private int value;          // sudoku value [1,9]
    private boolean is_empty;   // 0 -> empty cell

    public Cell(int new_val, int new_num)
    /**
     * Constructs an instance of the cell class.
     *
     * @param new_val value associated with the Sudoku game.
     * @param new_num cell number associated with the board location.
     */
    {
        this.num = new_num;
        this.value = new_val;
        this.is_empty = (new_val == 0) ? true : false;
    }

    public int getNum()
    /**
     * Getter method for the num attribute.
     *
     * @return the cell's index position on the board
     */
    {
        return this.num;
    }
    
    public int getValue()
    /**
     * Getter method for the value attribute.
     *
     * @return the cell's current Sudoku value. 
     */
    {
        return this.value;
    }

    public boolean isEmpty()
    /**
     * Checks to see if the cell contains the empty element (zero).
     * 
     * @return is this cell empty?
     */
    {
        return this.is_empty;
    }

    public void setValue(int new_val)
    /**
     * Setter method for the value field. Based on the new value, the cell
     * is said to be empty (zero) or non-empty (1-9).
     * 
     * @param new_val value to be stored in the cell.
     */
    {
        this.is_empty = (new_val == 0) ? true : false;
        this.value = new_val;
    }
}
