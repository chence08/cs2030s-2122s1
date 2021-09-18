/**
 * Author: Chen YiJia
 * Date: 14/9/21
 */

abstract class Rubik implements Cloneable {
    private final Face[] faces;
    // Top, Left, Front, Right, Down, Back
    private static final int UP = 0;
    private static final int LEFT = 1;
    private static final int FRONT = 2;
    private static final int RIGHT = 3;
    private static final int DOWN = 4;
    private static final int BACK = 5;

    private final int sideLength;

    Rubik(int[][][] grid) {
        faces = new Face[grid.length];
        for (int i = 0; i < grid.length; i++) {
            faces[i] = new Face(grid[i]);
        }
        sideLength = grid[UP].length;
    }

    int[][][] toIntArray() { // deepcopy
        int[][][] result = new int[faces.length][sideLength][sideLength];
        for (int i = 0; i < faces.length; i++) {
            result[i] = faces[i].clone().toIntArray();
        }
        return result;
    }

    @Override
    public abstract Rubik clone();

    int[][][] rightTurnArray() {
        int[][][] oldFaces = toIntArray();
        int[][][] newFaces = toIntArray();
        newFaces[FRONT] = faces[FRONT].right().toIntArray();

        for (int i = 0; i < sideLength; i++) {
            newFaces[RIGHT][i][0] = oldFaces[UP][sideLength - 1][i]; // U-R
            newFaces[DOWN][0][i] = oldFaces[RIGHT][sideLength - 1 - i][0]; // R-D
            newFaces[LEFT][i][sideLength - 1] = oldFaces[DOWN][0][i]; // D-L
            newFaces[UP][sideLength - 1][i] = 
                oldFaces[LEFT][sideLength - 1 - i][sideLength - 1]; // L-U
        }
        return newFaces;
    }

    abstract Rubik right();

    abstract Rubik left();

    abstract Rubik half();

    // Level 3
    Rubik upView() {
        Rubik tempRubik = clone();
        Rubik newRubik = clone();
        newRubik.faces[UP] = tempRubik.faces[BACK];
        newRubik.faces[LEFT] = tempRubik.faces[LEFT].right();
        newRubik.faces[FRONT] = tempRubik.faces[UP];
        newRubik.faces[RIGHT] = tempRubik.faces[RIGHT].left();
        newRubik.faces[DOWN] = tempRubik.faces[FRONT];
        newRubik.faces[BACK] = tempRubik.faces[DOWN];
        return newRubik;
    }
    
    Rubik rightView() {
        Rubik tempRubik = clone();
        Rubik newRubik = clone();
        newRubik.faces[UP] = tempRubik.faces[UP].right();
        newRubik.faces[LEFT] = tempRubik.faces[FRONT];
        newRubik.faces[FRONT] = tempRubik.faces[RIGHT];
        newRubik.faces[RIGHT] = tempRubik.faces[BACK].half();
        newRubik.faces[DOWN] = tempRubik.faces[DOWN].left();
        newRubik.faces[BACK] = tempRubik.faces[LEFT].half();
        return newRubik;
    }

    Rubik downView() {
        return this.upView().upView().upView();
    }

    Rubik leftView() {
        return this.backView().rightView();
    }

    Rubik backView() {
        return this.rightView().rightView();
    }
    
    Rubik frontView() {
        return this;
    }

    // String formatting
    String faceWithDots(Face face) {
        String output = "";
        String filler = "..".repeat(sideLength);
        int[][] array = face.toIntArray();

        for (int i = 0; i < sideLength; i++) {
            output += filler;
            for (int j = 0; j < sideLength; j++) {
                output += String.format("%02d", array[i][j]);
            }
            output += filler + "\n";
        }
        return output;
    }

    @Override
    public String toString() {
        String output = "\n";
        
        output += faceWithDots(faces[UP]);

        int[][] left = faces[LEFT].toIntArray();
        int[][] front = faces[FRONT].toIntArray();
        int[][] right = faces[RIGHT].toIntArray();
        for (int i = 0; i < sideLength; i++) {
            for (int j = 0; j < sideLength; j++) {
                output += String.format("%02d", left[i][j]);
            }
            for (int j = 0; j < sideLength; j++) {
                output += String.format("%02d", front[i][j]);
            }
            for (int j = 0; j < sideLength; j++) {
                output += String.format("%02d", right[i][j]);
            }
            output += "\n";
        }

        output += faceWithDots(faces[DOWN]) + faceWithDots(faces[BACK]);
        return output;
    }
}
