package amongalen.minesweeperproject;

import java.util.regex.Pattern;

/**
 *
 * @author Adam Parys
 */
public class MyMineSweeper implements MineSweeper {

    boolean[][] mineField;

    /**
     * Initialises the field
     *
     * A mine - field of N x M squares is represented by N lines of exactly M
     * characters each. The characte r '*' represents a mine * and the character
     * '.' represents no - mine. Lines are separated by ' \ n'
     *
     * Example mine - field string (as input to setMineField()):
     * "*...\n..*.\n...." (a 3 x 4 mine - field of 12 squares, 2 of which are
     * mines)
     *
     * @param mineField string containing the mines
     * @throws IllegalArgumentException if mineField is not properly formatted
     */
    @Override
    public void setMineField(String mineField) throws IllegalArgumentException {
        if (!mineField.matches("[*.\n]+")) {
            throw new IllegalArgumentException("Input string must contain only symbols '*' (star), '.' (dot) or '\\n'");
        }
        String[] rows = mineField.split("\n");
        for (int i = 1; i < rows.length; i++) {
            if (rows[i].length() != rows[0].length()) {
                throw new IllegalArgumentException("Each row much contain the same amount of squares");
            }
        }
        this.mineField = new boolean[rows.length][rows[0].length()];
        for (int i = 0; i < rows.length; i++) {
            String row = rows[i];
            for (int j = 0; j < row.length(); j++) {
                if (row.charAt(j) == '*') {
                    this.mineField[i][j] = true;
                } else {
                    this.mineField[i][j] = false;
                }
            }
        }
    }

    /**
     * Produces a hint - field of identical dimensions as the mineFiled() where
     * each square is a * for a mine or the number of adjacent mine - squares if
     * the square does not contain a mine.
     * <p/>
     * Example hint - field (for the above input): "*211 \ n12*1 \ n0111"
     *
     *
     * @return a string representation of the hint - field
     *
     * @throws IllegalStateException if the mine - field has not been
     * initialised (i.e. setMineField() has not been called)
     */
    @Override
    public String getHintField() throws IllegalStateException {
        if (mineField == null) {
            throw new IllegalStateException("Minefield not initialised");
        }
        String hintString = "";
        for (int i = 0; i < mineField.length; i++) {
            for (int j = 0; j < mineField[0].length; j++) {
                if (mineField[i][j] == true) {
                    hintString += "*";
                } else {
                    int count = 0;
                    for (int k = -1; k <= 1; k++) {
                        for (int m = -1; m <= 1; m++) {
                            if ((i + k >= 0) && (i + k < mineField.length) && (j + m >= 0) && (j + m < mineField.length) && mineField[i + k][j + m]) {
                                count++;
                            }
                        }
                    }
                    hintString += count;
                }
            }
            hintString += "\n";
        }
        return hintString;
    }
}
