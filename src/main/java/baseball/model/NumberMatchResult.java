package baseball.model;

public class NumberMatchResult {

    private final int strike;
    private final int ball;
    private final int length;

    /**
     * NumberMatchResult 내부 생성자
     *
     * @param strike 두 수의 strike 갯수
     * @param ball 두 수의 ball 갯수
     * @param length 입력 값의 길이
     */
    private NumberMatchResult(int strike, int ball, int length) {
        this.strike = strike;
        this.ball = ball;
        this.length = length;
    }

    /**
     * NumberMatchResult 객체 생성 함수
     *
     * @param strike 두 수의 strike 갯수
     * @param ball 두 수의 ball 갯수
     * @param length 입력 값의 길이
     * @return 두 수의 strike, ball 결과를 담고 있는 NumberMatchResult 객체
     */
    static public NumberMatchResult of(int strike, int ball, int length){
        return new NumberMatchResult(strike, ball, length);
    }

    /**
     * 모든 수가 동일한 full strike 여부를 반환하는 함수
     *
     * @return 완전 동일한 지 여부 (같음 = true, 다름 = false)
     */
    public boolean isFullStrike() {
        return strike == length;
    }

    /**
     * 스트라이크 갯수를 반환하는 함수
     *
     * @return strike 갯수
     */
    public int getStrike() {
        return this.strike;
    }

    /**
     * 볼 갯수를 반환하는 함수
     *
     * @return ball 갯수
     */
    public int getBall() {
        return this.ball;
    }
}
