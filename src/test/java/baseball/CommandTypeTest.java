package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.model.CommandType;
import org.junit.jupiter.api.Test;

public class CommandTypeTest {

    @Test
    void 타입_파싱_테스트() {
        assertThat(CommandType.parse("1").equals(CommandType.CONTINUE)).isTrue();
        assertThat(CommandType.parse("2").equals(CommandType.EXIT)).isTrue();
        assertThatThrownBy(() -> CommandType.parse("12321")).isInstanceOf(IllegalArgumentException.class);
    }
}
