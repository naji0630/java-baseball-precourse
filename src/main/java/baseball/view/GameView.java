package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class GameView {

    private final int length;

    private GameView(int length) {
        this.length = length;
    }

    static public GameView of(int length) {
        return new GameView(length);
    }

    public void printResult(int strike, int ball) {
        print(ball, "볼");
        print(strike, "스트라이크");
        if (strike < 1 && ball < 1) {
            System.out.println("낫싱");
        }
        System.out.println();
    }

    public void print(int count, String unit) {
        if (count > 0) {
            System.out.print(count + unit + " ");
        }
    }

    public void printEnding() {
        System.out.println(length + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public String queryContinue() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }

    public String queryPrediction() {
        System.out.println("숫자를 입력해주세요.");
        return Console.readLine();
    }
}
