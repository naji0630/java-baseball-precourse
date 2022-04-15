package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.model.NumberGenerator;
import org.junit.jupiter.api.Test;

public class NumberGeneratorTest {

    @Test
    void 생성기_테스트() {
        Integer randomNumber = NumberGenerator.of(3, 1, 9).getRandomNumber();
        String [] arr = String.valueOf(randomNumber).split("");
        assertThat(arr.length == 3);
        assertThat(arr[0]!=arr[1]).isTrue();
        assertThat(arr[1]!=arr[2]).isTrue();
        assertThat(arr[0]!=arr[2]).isTrue();
    }
}
