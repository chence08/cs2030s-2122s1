/**
 * Author: Chen YiJia
 * Date: 14/9/21
 */

class RubikLeft extends Rubik {
    RubikLeft(int[][][] grid) {
        super(grid);
    }

    RubikLeft(Rubik rubik) {
        super(rubik.toIntArray());
    }

    @Override
    public Rubik clone() {
        return new RubikLeft(this);
    }

    @Override
    Rubik right() {
        return new RubikLeft(super.leftView().rightTurnArray()).rightView();
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
