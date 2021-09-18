class RubikUp extends Rubik {
    RubikUp(int[][][] grid) {
        super(grid);
    }

    RubikUp(Rubik rubik) {
        super(rubik.toIntArray());
    }

    @Override
    public Rubik clone() {
        return new RubikUp(this);
    }

    @Override
    Rubik right() {
        return new RubikUp(super.upView().rightTurnArray()).downView();
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
