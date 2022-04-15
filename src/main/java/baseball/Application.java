package baseball;

import baseball.controller.GameController;
import baseball.controller.GameController.GameControllerBuilder;
import baseball.model.NumberGenerator;
import baseball.model.NumberMatcher;
import baseball.model.NumberValidator;
import baseball.view.GameView;

public class Application {

    static final int LENGTH = 3;
    static final int MINIMUM_NUMBER = 1;
    static final int MAXIMUM_NUMBER = 9;

    public static void main(String[] args) {
        GameController gameController = new GameControllerBuilder()
            .matcher(NumberMatcher.of(LENGTH))
            .validator(NumberValidator.of(LENGTH))
            .numberGenerator(NumberGenerator.of(LENGTH, MINIMUM_NUMBER, MAXIMUM_NUMBER))
            .gameView(GameView.of(LENGTH))
            .build();

        gameController.run();
    }
}