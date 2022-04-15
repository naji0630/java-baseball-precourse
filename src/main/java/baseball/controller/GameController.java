package baseball.controller;

import baseball.model.CommandType;
import baseball.model.NumberGenerator;
import baseball.model.NumberMatchResult;
import baseball.model.NumberMatcher;
import baseball.model.NumberValidator;
import baseball.view.GameView;

public class GameController {

    final private NumberMatcher numberMatcher;
    final private NumberValidator numberValidator;
    final private NumberGenerator numberGenerator;
    final private GameView gameView;

    /**
     * 게임 컨트롤러 내부 생성자
     *
     * @param gameControllerBuilder 게임 컨트롤러 생성 빌더
     */
    private GameController(GameControllerBuilder gameControllerBuilder) {
        this.numberMatcher = gameControllerBuilder.numberMatcher;
        this.numberValidator = gameControllerBuilder.numberValidator;
        this.numberGenerator = gameControllerBuilder.numberGenerator;
        this.gameView = gameControllerBuilder.gameView;
    }

    /**
     * 게임 컨트롤러 실행 함수
     */
    public void run() {
        do {
            play(numberGenerator.getRandomNumber());
        } while (!CommandType.EXIT.equals(CommandType.parse(gameView.queryContinue())));
    }

    /**
     * 게임 진행 함수
     *
     * @param randomNumber 게임에서 사용할 랜덤 값
     */
    public void play(Integer randomNumber) {
        NumberMatchResult numberMatchResult;
        do {
            String prediction = gameView.queryPrediction();
            numberValidator.validatePrediction(prediction);
            numberMatchResult = numberMatcher.match(randomNumber.toString(), prediction);
            gameView.printResult(numberMatchResult.getStrike(), numberMatchResult.getBall());
        } while (!numberMatchResult.isFullStrike());
        gameView.printEnding();
    }

    public static class GameControllerBuilder {

        private NumberMatcher numberMatcher;
        private NumberValidator numberValidator;
        private NumberGenerator numberGenerator;
        private GameView gameView;

        public GameControllerBuilder matcher(NumberMatcher numberMatcher) {
            this.numberMatcher = numberMatcher;
            return this;
        }

        public GameControllerBuilder validator(NumberValidator numberValidator) {
            this.numberValidator = numberValidator;
            return this;
        }

        public GameControllerBuilder numberGenerator(NumberGenerator numberGenerator) {
            this.numberGenerator = numberGenerator;
            return this;
        }

        public GameControllerBuilder gameView(GameView gameView) {
            this.gameView = gameView;
            return this;
        }

        public GameController build() {
            return new GameController(this);
        }
    }
}
