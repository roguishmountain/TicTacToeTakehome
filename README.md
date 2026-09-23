## Board key
* x -> player 1
* o -> player 2
* \- -> unplayed location

## How to run tests:
Run `mvn clean test` in bash shell in root of project (same directory where `pom.xml` is located). You may need to install Maven.

### Assumptions:
* `checkWinner()` returns player that won if there's a winner and null if there's no winner.
* The board will never have two winners and will only contain x, o, \-.

