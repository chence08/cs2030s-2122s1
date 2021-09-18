/**
 * Author: Chen YiJia
 * Date: 14/9/21
 */

class RubikBack extends Rubik {
    RubikBack(int[][][] grid) {
        super(grid);
    }

    RubikBack(Rubik rubik) {
        super(rubik.toIntArray());
    }

    @Override
    public Rubik clone() {
        return new RubikBack(this);
    }

    @Override
    Rubik right() {
        return new RubikBack(super.backView().rightTurnArray()).backView();
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
