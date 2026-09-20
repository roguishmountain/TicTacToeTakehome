## Board key
* x -> player 1
* o -> player 2
* \- -> unplayed location

## How to run tests:
Run `mvn clean test` in root of project (same directory where `pom.xml` is located).

### Assumptions:
* `checkWinner()` returns player that won if there's a winner and a null char if there's no winner.
* The board will never have two winners and will only contain x, o, \-.
* The 2x2 win condition is a box in a fixed location (similar to Sudoku boxes) and not a 2x2 box located anywhere on the board.
  * For example the box {1,1}, {1,2}, {2,1}, {2,2} is not a winning condition.

