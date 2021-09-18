/**
 * Author: Chen YiJia
 * Date: 14/9/21
 */

class RubikRight extends Rubik {
    RubikRight(int[][][] grid) {
        super(grid);
    }

    RubikRight(Rubik rubik) {
        super(rubik.toIntArray());
    }

    @Override
    public Rubik clone() {
        return new RubikRight(this);
    }

    @Override
    Rubik right() {
        return new RubikRight(super.rightView().rightTurnArray()).leftView();
    }

    @Override
    Rubik left() {
        return right().right().right();
    }

    @Override
    Rubik half() {
        return right().right();
    }
}
