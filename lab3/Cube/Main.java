/**
 * Author: Chen YiJia
 * Date: 14/9/21
 */

import java.util.Scanner;

class Main {
    static final int NFACES = 6;
    static final int NROWS = 3;
    static final int NCOLS = 3;

    static Rubik oneMove(Rubik rubik, String move) {
        switch (move.charAt(0)) {
            case 'R': rubik = new RubikRight(rubik);
                      break;
            case 'U': rubik = new RubikUp(rubik);
                      break;
            case 'L': rubik = new RubikLeft(rubik);
                      break;
            case 'B': rubik = new RubikBack(rubik);
                      break;
            case 'D': rubik = new RubikDown(rubik);
                      break;
            default: // checkstyle
        }

        if (move.length() == 1) {
            rubik = rubik.right();
        } else {
            if (move.charAt(1) == '\'') {
                rubik = rubik.left();
            } else {
                rubik = rubik.half();
            }
        }

        return new RubikFront(rubik);
    }


    public static void main(String[] args) {
        int[][][] grid = new int[NFACES][NROWS][NCOLS];

        Scanner sc = new Scanner(System.in);
        for (int k = 0; k < NFACES; k++) {
            for (int i = 0; i < NROWS; i++) {
                for (int j = 0; j < NCOLS; j++) {
                    grid[k][i][j] = sc.nextInt();
                }
            }
        }
        Rubik rubik = new RubikFront(grid);

        while (sc.hasNext()) {
            rubik = oneMove(rubik, sc.next());
        }
        System.out.println(rubik);
    }
}
