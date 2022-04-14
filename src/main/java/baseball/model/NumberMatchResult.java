package baseball.model;

public class NumberMatchResult {

    private final int strike;
    private final int ball;
    private final int length;

    private NumberMatchResult(int strike, int ball, int length) {
        this.strike = strike;
        this.ball = ball;
        this.length = length;
    }

    static public NumberMatchResult of(int strike, int ball, int length){
        return new NumberMatchResult(strike, ball, length);
    }

    public boolean isFullStrike() {
        return strike == length;
    }

    public int getStrike() {
        return this.strike;
    }

    public int getBall() {
        return this.ball;
    }
}
