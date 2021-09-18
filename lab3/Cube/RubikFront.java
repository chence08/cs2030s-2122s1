/**
 * Author: Chen YiJia
 * Date: 14/9/21
 */

class RubikFront extends Rubik {
    RubikFront(int[][][] grid) {
        super(grid);
    }

    RubikFront(Rubik rubik) {
        super(rubik.toIntArray());
    }

    @Override
    public Rubik clone() {
        return new RubikFront(this);
    }

    @Override
    Rubik right() {
        return new RubikFront(super.rightTurnArray());
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
