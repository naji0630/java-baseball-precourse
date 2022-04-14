package baseball;


import baseball.model.NumberMatchResult;
import baseball.model.NumberMatcher;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class NumberMatcherTest {
    @Test
    void 비교기_테스트(){
        NumberMatchResult result = NumberMatcher.of(3).match("425", "123");
        assertThat(result.getBall()).isEqualTo(0);
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.isFullStrike()).isFalse();

        result = NumberMatcher.of(3).match("425", "456");
        assertThat(result.getBall()).isEqualTo(1);
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.isFullStrike()).isFalse();

        result = NumberMatcher.of(3).match("425", "789");
        assertThat(result.getBall()).isEqualTo(0);
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.isFullStrike()).isFalse();

        result = NumberMatcher.of(3).match("425", "425");
        assertThat(result.getBall()).isEqualTo(0);
        assertThat(result.getStrike()).isEqualTo(3);
        assertThat(result.isFullStrike()).isTrue();
    }
}
