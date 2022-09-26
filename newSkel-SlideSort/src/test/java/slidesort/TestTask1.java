package slidesort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestTask1 {

    @Test
    public void all0Grid() {
        int[][] seedArray = {
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
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        Grid g = new Grid(seedArray);

        assertTrue(g.isValid());
        assertTrue(g.isSorted());
    }

    @Test
    public void all1Grid() {
        int[][] seedArray = {
                {1, 1},
                {1, 1}
        };

        Grid g = new Grid(seedArray);
        assertFalse(g.isValid());
    }

    @Test
    public void oneToFiveGrid1() {
        int[][] seedArray = {
                {0, 1, 0, 0, 0},
                {2, 3, 0, 0, 0},
                {4, 5, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };

        Grid g = new Grid(seedArray);
        assertTrue(g.isValid());
        assertTrue(g.isSorted());
    }

    @Test
    public void oneToFiveGrid2() {
        int[][] seedArray = {
                {0, 2, 0, 0, 0},
                {1, 3, 0, 0, 0},
                {4, 5, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };

        Grid g = new Grid(seedArray);
        assertTrue(g.isValid());
        assertFalse(g.isSorted());
    }

    @Test
    public void emptyGrid() {
        int[][] seedArray = {
                {}
        };

        Grid g = new Grid(seedArray);
        assertTrue(g.isValid());
        assertTrue(g.isSorted());
    }

    @Test
    public void zeroGrid() {
        int[][] seedArray = {
                {0}
        };

        Grid g = new Grid(seedArray);
        assertTrue(g.isValid());
        assertTrue(g.isSorted());
    }

    @Test
    public void unityGrid() {
        int[][] seedArray = {
                {1}
        };

        Grid g = new Grid(seedArray);
        assertTrue(g.isValid());
        assertTrue(g.isSorted());
    }

    @Test
    public void twoGrid() {
        int[][] seedArray = {
                {2}
        };

        Grid g = new Grid(seedArray);
        assertFalse(g.isValid());
        assertFalse(g.isSorted());
    }

    @Test
    public void fourMissingValid() {
        int[][] seedArray = {
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 2, 0},
                {4, 0, 0, 0},

        };

        Grid g = new Grid(seedArray);
        assertTrue(g.isValid());
        assertTrue(g.isSorted());
    }

    public void fourDuplicate() {
        int[][] seedArray = {
                {1, 0, 0, 0},
                {0, 0, 0, 2},
                {0, 0, 2, 0},
                {4, 0, 0, 0},

        };

        Grid g = new Grid(seedArray);
        assertFalse(g.isValid());
        assertFalse(g.isSorted());
    }

    @Test
    public void fourRectInvalid() {
        int[][] seedArray = {
                {4, 3, 2, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},

        };

        Grid g = new Grid(seedArray);
        assertFalse(g.isValid());
        assertFalse(g.isSorted());
    }

    @Test
    public void fourValid() {
        int[][] seedArray = {
                {4, 3, 2, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},

        };

        Grid g = new Grid(seedArray);
        assertTrue(g.isValid());
        assertFalse(g.isSorted());
    }

    @Test
    public void fourNegative() {
        int[][] seedArray = {
                {4, 3, 2, -1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},

        };

        Grid g = new Grid(seedArray);
        assertFalse(g.isValid());
        assertFalse(g.isSorted());
    }

    @Test
    public void fourOverInvalid() {
        int[][] seedArray = {
                {1, 0, 0, 0},
                {0, 5, 0, 0},
                {0, 0, 2, 0},
                {4, 0, 0, 0},

        };

        Grid g = new Grid(seedArray);
        assertFalse(g.isValid());
        assertFalse(g.isSorted());
    }

    @Test
    public void fourVRectValid() {
        int[][] seedArray = {
                {1, 0, 0},
                {0, 0, 0},
                {0, 0, 2},
                {3, 0, 0},

        };

        Grid g = new Grid(seedArray);
        assertTrue(g.isValid());
        assertTrue(g.isSorted());
    }
    @Test
    public void tenUnsorted() {
        int[][] seedArray = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 10},
                {0, 0, 0, 0, 0, 6, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 8, 0, 0},
                {0, 0, 0, 0, 0, 0, 7, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 9, 0},
                {0, 0, 0, 4, 0, 0, 0, 0, 0, 0},
                {0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 2, 0, 0, 5, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},

        };

        Grid g = new Grid(seedArray);
        assertTrue(g.isValid());
        assertFalse(g.isSorted());
    }

    @Test
    public void tenSorted() {
        int[][] seedArray = {
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 2, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 3, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 4, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 5},
                {0, 0, 0, 0, 0, 0, 0, 0, 6, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 7, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 8, 0, 0, 0, 0, 0, 0, 0},
                {9, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 10},

        };

        Grid g = new Grid(seedArray);
        assertTrue(g.isValid());
        assertTrue(g.isSorted());
    }
}
