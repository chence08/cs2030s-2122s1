/open Cloneable.java
/open Face.java
/open Rubik.java
/open RubikFront.java
int[][][] grid = new int[6][4][4];
int d = 1
for (int k = 0; k < 6; k++)
    for (int i = 0; i < 4; i++)
        for (int j = 0; j < 4; j++) grid[k][i][j] = d++;
Rubik r = new RubikFront(grid)
r.upView()
r.rightView()
r.downView()
r.leftView()
r.backView()
r.frontView()
