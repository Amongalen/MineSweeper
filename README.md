# MineSweeper
An implementation of a MineSweeper interface.

##### void setMineField(String mineField)
``` 
Initialises the field
A mine - field of N x M squares is represented by N lines of exactly M
characters each. The character '*' represents a mine * and the character
'.' represents no-mine. Lines are separated by ' \ n'
 
Example mine - field string (as input to setMineField()): "*...\n..*.\n...." 
(a 3 x 4 mine - field of 12 squares, 2 of which are mines)

@param mineField string containing the mines
@throws IllegalArgumentException if mineField is not properly formatted
```

##### String getHintField() throws IllegalStateException;
```
Produces a hint - field of identical dimensions as the mineFiled() where
each square is a * for a mine or the number of adjacent mine-squares if
the square does not contain a mine.

Example hint - field (for the above input): "*211 \ n12*1 \ n0111"

@return a string representation of the hint-field

@throws IllegalStateException if the mine-field has not been
initialised (i.e. setMineField() has not been called)

```
