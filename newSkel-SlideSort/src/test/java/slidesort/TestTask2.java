package slidesort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestTask2 {

    @Test
    public void testSimpleMove() {
        int[][] seedArray = {
                {0, 2, 1},
                {0, 0, 0}
        };

        List<Move> moveList = Arrays.asList(
                new Move(new Position(0, 1), false, 1),
                new Move(new Position(0, 2), false, 1)
        );

        Grid g = new Grid(seedArray);
        assertTrue(g.validMoves(moveList));

        g.applyMoves(moveList);

        int[][] seedArray2 = {
                {0, 0, 0},
                {0, 2, 1}
        };
        Grid g2 = new Grid(seedArray2);
        assertEquals(g2, g);
    }

    @Test
    public void testInvalidMove() {
        int[][] seedArray = {
                {0, 2, 1},
                {0, 0, 0}
        };

        List<Move> moveList = Arrays.asList(
                new Move(new Position(0, 1), true, 1),
                new Move(new Position(0, 2), false, 1)
        );

        Grid g = new Grid(seedArray);
        assertFalse(g.validMoves(moveList));
    }

    @Test
    public void testInvalidToValidMove() {
        int[][] seedArray = {
                {0, 2, 1},
                {0, 0, 0}
        };

        List<Move> moveList = Arrays.asList(
                new Move(new Position(0, 2), false, 1),
                new Move(new Position(0, 1), true, 1)
        );

        Grid g = new Grid(seedArray);
        assertTrue(g.validMoves(moveList));

        g.applyMoves(moveList);

        int[][] seedArray2 = {
                {0, 0, 2},
                {0, 0, 1}
        };
        Grid g2 = new Grid(seedArray2);
        assertEquals(g2, g);
    }

    @Test
    public void testMoreComplexMoves() {
        int[][] seedArray = {
                {15, 10, 24, 25, 18, 13, 14, 1, 26, 19, 12, 4, 21, 2, 8, 20, 23, 22, 16, 6, 3, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };


        List<Move> moveList = Arrays.asList(
                new Move(new Position(0, 0), false, 14),
                new Move(new Position(0, 1), false, 9),
                new Move(new Position(0, 2), false, 23),
                new Move(new Position(0, 3), false, 24),
                new Move(new Position(0, 4), false, 17),
                new Move(new Position(0, 5), false, 12),
                new Move(new Position(0, 6), false, 13),
                new Move(new Position(0, 7), true, 0),
                new Move(new Position(0, 8), false, 25),
                new Move(new Position(0, 9), false, 18),
                new Move(new Position(0, 10), false, 11),
                new Move(new Position(0, 11), false, 3),
                new Move(new Position(0, 12), false, 20),
                new Move(new Position(0, 13), false, 1),
                new Move(new Position(0, 14), false, 7),
                new Move(new Position(0, 15), false, 19),
                new Move(new Position(0, 16), false, 22),
                new Move(new Position(0, 17), false, 21),
                new Move(new Position(0, 18), false, 15),
                new Move(new Position(0, 19), false, 5),
                new Move(new Position(0, 20), false, 2)
        );

        Grid g = new Grid(seedArray);
        assertTrue(g.validMoves(moveList));
    }

    @Test
    public void empty() {
        int[][] seedArray = {
                {}
        };

        List<Move> moveList = Arrays.asList(
        );

        Grid g = new Grid(seedArray);
        assertTrue(g.validMoves(moveList));

        g.applyMoves(moveList);

        int[][] seedArray2 = {
                {}
        };
        Grid g2 = new Grid(seedArray2);
        assertEquals(g2, g);
    }

    @Test
    public void startOutOfBounds() {
        int[][] seedArray = {
                {0, 2, 1},
                {0, 0, 0}
        };

        List<Move> moveList = Arrays.asList(
                new Move(new Position(0, 3), false, 1)
        );

        Grid g = new Grid(seedArray);
        assertFalse(g.validMoves(moveList));
    }

    @Test
    public void EndOutOfBounds() {
        int[][] seedArray = {
                {0, 2, 1},
                {0, 0, 0}
        };

        List<Move> moveList = Arrays.asList(
                new Move(new Position(0, 1), false, 2)
        );

        Grid g = new Grid(seedArray);
        assertFalse(g.validMoves(moveList));
    }

    @Test
    public void startZero() {
        int[][] seedArray = {
                {0, 2, 1},
                {0, 0, 0}
        };

        List<Move> moveList = Arrays.asList(
                new Move(new Position(0, 0), true, 1)
        );

        Grid g = new Grid(seedArray);
        assertFalse(g.validMoves(moveList));
    }

    @Test
    public void leftBlocked() {
        int[][] seedArray = {
                {0, 2, 1},
                {0, 0, 0}
        };

        List<Move> moveList = Arrays.asList(
                new Move(new Position(0, 2), true, -1)
        );

        Grid g = new Grid(seedArray);
        assertFalse(g.validMoves(moveList));
    }

    @Test
    public void testCycleMove() {
        int[][] seedArray = {
                {0, 2, 1},
                {0, 0, 0}
        };

        List<Move> moveList = Arrays.asList(
                new Move(new Position(0, 1), true, -1),
                new Move(new Position(0, 2), true, -1),
                new Move(new Position(0, 0), false, 1),
                new Move(new Position(0, 1), true, -1),
                new Move(new Position(1, 0), true, 2),
                new Move(new Position(0, 0), false, 1),
                new Move(new Position(1, 2), false, -1),
                new Move(new Position(1, 0), true, 2),
                new Move(new Position(0, 2), true, -1),
                new Move(new Position(1, 2), false, -1)
        );

        Grid g = new Grid(seedArray);
        assertTrue(g.validMoves(moveList));

        g.applyMoves(moveList);

        int[][] seedArray2 = {
                {0, 2, 1},
                {0, 0, 0}
        };
        Grid g2 = new Grid(seedArray2);
        assertEquals(g2, g);
    }

    @Test
    public void testMazeCycleMove() {
        int[][] seedArray = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 2, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 5, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 6, 0},
                {0, 0, 0, 0, 4, 8, 0, 0, 0, 0},
                {0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                {10, 0, 0, 0, 0, 0, 0, 0, 0, 7},
        };

        List<Move> moveList = Arrays.asList(
                new Move(new Position(9, 0), false, -9),
                new Move(new Position(0, 0), true, 9),
                new Move(new Position(0, 9), false, 2),
                new Move(new Position(2, 9), true, -7),
                new Move(new Position(2, 2), false, 5),
                new Move(new Position(7, 2), true, 1),
                new Move(new Position(7, 3), false, -1),
                new Move(new Position(6, 3), true, 4),
                new Move(new Position(6, 7), false, 3),
                new Move(new Position(9, 7), true, 1),
                new Move(new Position(9, 8), false, -2),
                new Move(new Position(7, 8), true, -2),
                new Move(new Position(7, 6), false, 2),
                new Move(new Position(9, 6), true, -6)
        );
        Grid g = new Grid(seedArray);
        assertTrue(g.validMoves(moveList));

        g.applyMoves(moveList);

        int[][] seedArray2 = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 2, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 5, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 6, 0},
                {0, 0, 0, 0, 4, 8, 0, 0, 0, 0},
                {0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                {10, 0, 0, 0, 0, 0, 0, 0, 0, 7},
        };
        Grid g2 = new Grid(seedArray2);
        assertEquals(g2, g);
    }

    @Test
    public void GeneralMove() {
        int[][] seedArray = {
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 2, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 4, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 5, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 6, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 7, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 8, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 9, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 10},
        };

        List<Move> moveList = Arrays.asList(
                new Move(new Position(0, 0), true, 1),
                new Move(new Position(1, 1), false, 2),
                new Move(new Position(2, 2), true, 3),
                new Move(new Position(3, 3), false, 4),
                new Move(new Position(4, 4), true, 5),
                new Move(new Position(5, 5), true, -1),
                new Move(new Position(6, 6), false, -2),
                new Move(new Position(7, 7), true, -3),
                new Move(new Position(8, 8), false, -4),
                new Move(new Position(9, 9), true, -5)
        );
        Grid g = new Grid(seedArray);
        assertTrue(g.validMoves(moveList));

        g.applyMoves(moveList);

        int[][] seedArray2 = {
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                {0, 2, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 7, 0, 9, 5},
                {0, 0, 0, 0, 6, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 4, 8, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 10, 0, 0, 0, 0, 0},
        };
        Grid g2 = new Grid(seedArray2);
        assertEquals(g2, g);
    }
}
