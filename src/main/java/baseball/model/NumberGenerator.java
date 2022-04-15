package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.Set;

public class NumberGenerator {

    private final int length;
    private final int min;
    private final int max;

    private NumberGenerator(int length, int min, int max) {
        this.length = length;
        this.min = min;
        this.max = max;
    }

    static public NumberGenerator of(int length, int min, int max) {
        return new NumberGenerator(length, min, max);
    }

    public Integer getRandomNumber() {
        Set<Integer> sampled = new HashSet<>();
        int result = 0;
        while (sampled.size() < length) {
            Integer num = samplingWithoutReplacement(sampled, min, max);
            sampled.add(num);
            result += Math.pow(10, length - sampled.size()) * num;
        }
        return result;
    }

    private Integer samplingWithoutReplacement(Set<Integer> sampled, int min, int max) {
        Integer pick;
        do {
            pick = Randoms.pickNumberInRange(min, max);
        } while (sampled.contains(pick));
        return pick;
    }
}
