/**
 * Author: Chen YiJia
 * Date: 14/9/21
 */

class Face implements Cloneable {
    private final int[][] grid;

    Face(int[][] grid) {
        this.grid = grid;
    }

    @Override
    public Face clone() {
        int[][] newGrid = new int[grid.length][grid.length];
        for (int i = 0; i < grid.length; i++) {
            newGrid[i] = grid[i].clone();
        }
        return new Face(newGrid);
    }

    // works for any size
    Face right() {
        Face newFace = clone();
        int lastIndex = newFace.grid.length - 1;
        for (int i = 0; i <= lastIndex / 2; i++) {
            for (int j = i; j < lastIndex - i; j++) {
                
                // Moving clockwise from top left.
                //int p1 = newFace.grid[i][j]; // Top left
                //int p2 = newFace.grid[j][lastIndex - i]; // Top right
                //int p3 = newFace.grid[lastIndex - i][lastIndex - j]; // Bottom right
                //int p4 = newFace.grid[lastIndex - j][i]; // Bottom left

                // Swap values clockwise 90 degrees
                newFace.grid[j][lastIndex - i] = grid[i][j];
                newFace.grid[lastIndex - i][lastIndex - j] = grid[j][lastIndex - i];
                newFace.grid[lastIndex - j][i] = grid[lastIndex - i][lastIndex - j];
                newFace.grid[i][j] = grid[lastIndex - j][i];
            }
        }
        return newFace;
    }

    Face left() {
        return right().right().right();
    }

    Face half() {
        return right().right();
    }

    int[][] toIntArray() {
        return grid;
    }

    @Override
    public String toString() {
        String output = "\n";
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                output += String.format("%02d", grid[i][j]);
            }
            output += "\n";
        }
        return output;
    }
}
