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
    private int value;          // sudoku value [1,9]
    private boolean is_empty;   // 0 -> empty cell

    public Cell(int new_val)
    {
        this.value = new_val;
        this.is_empty = new_val == 0 ? true : false;
    }

    public int getValue()
    {
        return this.value;
    }

    public boolean isEmpty()
    {
        return this.is_empty;
    }

    public void setVal(int new_val)
    {
        this.is_empty = new_val == 0 ? true : false;
        this.value = new_val;
    }
}
