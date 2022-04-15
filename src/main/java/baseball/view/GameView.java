package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class GameView {

    private final int length;

    /**
     * 게임 인터페이스 내부 생성자
     *
     * @param length 입력 값의 길이
     */
    private GameView(int length) {
        this.length = length;
    }

    /**
     * 게임 인터페이스 객체 생성 함수
     *
     * @param length 입력 값의 길이
     * @return 생성된 GameView 객체
     */
    static public GameView of(int length) {
        return new GameView(length);
    }

    /**
     * 예측 결과 출력 함수
     *
     * @param strike strike 수
     * @param ball ball 수
     */
    public void printResult(int strike, int ball) {
        print(ball, "볼");
        print(strike, "스트라이크");
        if (strike < 1 && ball < 1) {
            System.out.println("낫싱");
        }
        System.out.println();
    }

    /**
     * 갯수와 단위를 출력하는 출력 함수
     *
     * @param count 갯수
     * @param unit 단위
     */
    public void print(int count, String unit) {
        if (count > 0) {
            System.out.print(count + unit + " ");
        }
    }

    /**
     * 게임을 성공하여 종료를 출력하는 함수
     *
     */
    public void printEnding() {
        System.out.println(length + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    /**
     * 게임을 지속할지 여부를 묻는 함수
     *
     * @return 사용자 입력 값
     */
    public String queryContinue() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }

    /**
     * 예측 값을 묻는 함수
     *
     * @return 사용자 입력 값
     */
    public String queryPrediction() {
        System.out.println("숫자를 입력해주세요.");
        return Console.readLine();
    }
}
