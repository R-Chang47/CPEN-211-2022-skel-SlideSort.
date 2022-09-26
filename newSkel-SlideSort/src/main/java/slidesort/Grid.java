package slidesort;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
public class Grid {
    private int[][] _grid;

    /**
     * Create a new grid
     *
     * @param seedArray is not null
     *                  and seedArray.length > 0
     *                  and seedArray[0].length > 0
     */
    public Grid(int[][] seedArray) {
        int rows = seedArray.length;
        int cols = seedArray[0].length;
        _grid = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                _grid[i][j] = seedArray[i][j];
            }
        }
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Grid) {
            Grid g2 = (Grid) other;
            if (this._grid.length != g2._grid.length) {
                return false;
            }
            if (this._grid[0].length != g2._grid[0].length) {
                return false;
            }
            int rows = _grid.length;
            int cols = _grid[0].length;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (this._grid[i][j] != g2._grid[i][j]) {
                        return false;
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * Check if this grid is a valid grid.
     * A grid is valid if, for c = min(rows, cols),
     * the grid contains zero of more the values in [1, c]
     * exactly once and all other entries are 0s.
     *
     * @return true if this is a valid grid and false otherwise
     */
    public boolean isValid() {
        int c = Math.min(_grid.length, _grid[0].length);
        HashSet<Integer> numSet = new HashSet<>();

        for (int i = 0; i < _grid.length; i++) {
            for (int j = 0; j < _grid[0].length; j++) {
                if (_grid[i][j] < 0 || _grid[i][j] > c) {
                    return false;
                }
                if (_grid[i][j] != 0) {
                    if (!numSet.add(_grid[i][j])) {
                        return false;
                    } else {
                        numSet.add(_grid[i][j]);
                    }
                }
            }
        }
        return true;
    }

    /**
     * Check if this grid is sorted.
     * A grid is sorted iff it is valid and,
     * for all pairs of entries (x, y)
     * such that x > 0 and y > 0,
     * if x < y then the position(x) < position(y).
     * If x is at location (i, j) in the grid
     * then position(x) = i * (number of cols) + j.
     *
     * @return true if the grid is sorted and false otherwise.
     */
    public boolean isSorted() {
        int lastNum = 0;
        if (!this.isValid()) {
            return false;
        }
        for (int i = 0; i < _grid.length; i++) {
            for (int j = 0; j < _grid[0].length; j++) {
                if (_grid[i][j] != 0) {
                    if (_grid[i][j] < lastNum) {
                        return false;
                    } else {
                        lastNum = _grid[i][j];
                    }
                }
            }
        }
        return true;
    }

    /**
     * Check if a list of moves is feasible.
     * A move is feasible if it starts with a non-zero entry,
     * does not move that number off the grid,
     * and it does not involve jumping over another non-zero number.
     *
     * @param moveList is not null.
     * @return true if the list of moves are all feasible
     * and false otherwise.
     * By definition an empty list is always feasible.
     */
    public boolean validMoves(List<Move> moveList) {
        int rows = _grid.length;
        int cols = _grid[0].length;
        int[][] newGrid = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                newGrid[i][j] = _grid[i][j];
            }
        }

        if (moveList.size() == 0) {
            return true;
        }

        try {
            for (Move move : moveList) {
                int startPosI = move.startingPosition.i;
                int startPosJ = move.startingPosition.j;
                int displacement = move.displacement;

                if (startPosI < 0 || startPosI >= rows || startPosJ < 0 || startPosJ >= cols) {
                    throw new IllegalArgumentException("Start Out of Bounds");
                }
                if (newGrid[startPosI][startPosJ] == 0) {
                    throw new IllegalArgumentException("Starts at 0");
                }
                if (move.rowMove) {
                    if (startPosJ + displacement < 0 || startPosJ + displacement >= cols) {
                        throw new IllegalArgumentException("Moved Out of Bounds (Lateral)");
                    }
                    if (displacement >= 0) {
                        for (int x = startPosJ + 1; x <= startPosJ + displacement; x++) {
                            if (newGrid[startPosI][x] != 0) {
                                throw new IllegalArgumentException("Path Blocked (Right)");
                            }
                        }
                    } else {
                        for (int x = startPosJ - 1; x >= startPosJ + displacement; x--) {
                            if (newGrid[startPosI][x] != 0) {
                                throw new IllegalArgumentException("Path Blocked (Left)");
                            }
                        }
                    }
                    newGrid[startPosI][startPosJ + displacement] = newGrid[startPosI][startPosJ];
                } else {
                    if (startPosI + displacement < 0 || startPosI + displacement >= rows) {
                        throw new IllegalArgumentException("Moved Out of Bounds (Vertical)");
                    }
                    if (displacement >= 0) {
                        for (int y = startPosI + 1; y <= startPosI + displacement; y++) {
                            if (newGrid[y][startPosJ] != 0) {
                                throw new IllegalArgumentException("Path Blocked (Down)");
                            }
                        }
                    } else {
                        for (int y = startPosI - 1; y >= startPosI + displacement; y--) {
                            if (newGrid[y][startPosJ] != 0) {
                                throw new IllegalArgumentException("Path Blocked (Up)");
                            }
                        }
                    }
                    newGrid[startPosI + displacement][startPosJ] = newGrid[startPosI][startPosJ];
                }
                if (displacement != 0) {
                    newGrid[startPosI][startPosJ] = 0;
                }
            }
            return true;
        }
        catch (IllegalArgumentException e) {
            System.out.println(e);
            return false;
        }
    }

    /**
     * Apply the moves in moveList to this grid
     *
     * @param moveList is a valid list of moves
     */
    public void applyMoves(List<Move> moveList) {
        boolean valid = this.validMoves(moveList);

        if (valid) {
            for (Move move : moveList) {
                int startPosI = move.startingPosition.i;
                int startPosJ = move.startingPosition.j;
                int displacement = move.displacement;

                if (move.rowMove) {
                    _grid[startPosI][startPosJ + displacement] = _grid[startPosI][startPosJ];
                } else {
                    _grid[startPosI + displacement][startPosJ] = _grid[startPosI][startPosJ];
                }
                if (displacement != 0) {
                    _grid[startPosI][startPosJ] = 0;
                }
            }
        }
        else {
            System.out.println("Invalid Moves: No Moves Applied");
        }
    }

    /**
     * Return a list of moves that, when applied, would convert this grid
     * to be sorted
     *
     * @return a list of moves that would sort this grid
     */
    public List<Move> getSortingMoves() {
        int rows = _grid.length;
        int cols = _grid[0].length;
        int[][] savedGrid = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                savedGrid[i][j] = _grid[i][j];
            }
        }

        List<Move> moveList = new ArrayList<>();

        //Shift all values against the left wall
        for (int i = 0; i < rows; i++) {
            int numInRow = 0;
            for (int j = 0; j < cols; j++) {
                if (_grid[i][j] != 0) {
                    List<Move> leftShift = List.of(
                            new Move(new Position(i, j), true, numInRow - j));
                    this.applyMoves(leftShift);
                    moveList.add(leftShift.get(0));
                    numInRow++;
                }
            }
        }
        //Shift all values against the ceiling
        for (int j = 0; j < cols; j++) {
            int numInCol = 0;
            for (int i = 0; i < rows; i++) {
                if (_grid[i][j] != 0) {
                    List<Move> upShift = List.of(
                            new Move(new Position(i, j), false, numInCol - i));
                    this.applyMoves(upShift);
                    moveList.add(upShift.get(0));
                    numInCol++;
                }
            }
        }
        //Set all values in an empty column
        for (int j = cols - 1; j > 0; j--) {
            int sum = 0;
            for (int i = 0; i < rows; i++) {
                sum += _grid[i][j];
            }
            if (sum == 0) {
                numberSearch:
                for (int y = j - 1; y >= 0; y--) {
                    for (int x = 0; x < rows; x++) {
                        if (_grid[x][y] != 0) {
                            List<Move> rightSet = List.of(
                                    new Move(new Position(x, y), true, j - y));
                            this.applyMoves(rightSet);
                            moveList.add(rightSet.get(0));
                            break numberSearch;
                        }
                    }
                }
            }
        }
        //Set all values in an empty row
        for (int i = rows - 1; i > 0; i--) {
            int sum = 0;
            for (int j = 0; j < cols; j++) {
                sum += _grid[i][j];
            }
            if (sum == 0) {
                numberSearch:
                for (int x = i - 1; x >= 0; x--) {
                    for (int y = 0; y < cols; y++) {
                        if (_grid[x][y] != 0) {
                            List<Move> downSet = List.of(
                                    new Move(new Position(x, y), false, i - x));
                            this.applyMoves(downSet);
                            moveList.add(downSet.get(0));
                            break numberSearch;
                        }
                    }
                }
            }
        }
        //Place values in respective rows
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (_grid[i][j] != 0) {
                    List<Move> sortMove = List.of(
                            new Move(new Position(i, j), false, _grid[i][j] - i - 1));
                    this.applyMoves(sortMove);
                    moveList.add(sortMove.get(0));
                }
            }
        }
        //Replace old grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                _grid[i][j] = savedGrid[i][j];
            }
        }
        return moveList;
    }
}