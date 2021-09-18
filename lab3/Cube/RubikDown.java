/**
 * Author: Chen YiJia
 * Date: 14/9/21
 */

class RubikDown extends Rubik {
    RubikDown(int[][][] grid) {
        super(grid);
    }

    RubikDown(Rubik rubik) {
        super(rubik.toIntArray());
    }

    @Override
    public Rubik clone() {
        return new RubikDown(this);
    }

    @Override
    Rubik right() {
        return new RubikDown(super.downView().rightTurnArray()).upView();
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
