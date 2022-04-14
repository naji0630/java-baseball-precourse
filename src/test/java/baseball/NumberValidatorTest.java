package baseball;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.model.NumberValidator;
import org.junit.jupiter.api.Test;

public class NumberValidatorTest {

    @Test
    void 검증기_테스트() {
        NumberValidator numberValidator = NumberValidator.of(3);
        assertThatThrownBy(() -> numberValidator.validatePrediction("112")).isInstanceOf(IllegalArgumentException.class);
    }
}
