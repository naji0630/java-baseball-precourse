package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.Set;

public class NumberGenerator {

    private final int length;
    private final int min;
    private final int max;

    /**
     * 숫자 생성 객체 내부 생성자
     *
     * @param length 생성할 숫자의 길이
     * @param min 생성할 숫자를 구성하는 숫자의 최소값
     * @param max 생성할 숫자를 구성하는 숫자의 최대값
     */
    private NumberGenerator(int length, int min, int max) {
        this.length = length;
        this.min = min;
        this.max = max;
    }

    /**
     * 숫자 생성 객체 생성 함수
     *
     * @param length 생성할 숫자의 길이
     * @param min 생성할 숫자를 구성하는 숫자의 최소값
     * @param max 생성할 숫자를 구성하는 숫자의 최대값
     * @return 생성된 NumberGenerator 객체
     */
    static public NumberGenerator of(int length, int min, int max) {
        return new NumberGenerator(length, min, max);
    }

    /**
     * 숫자 생성 함수
     *
     * @return 생성된 랜덤 숫자
     */
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

    /**
     * 비복원 무작위 추출 함수
     *
     * @param sampled 이미 추출된 값의 집합
     * @param min 추출할 숫자의 최소값
     * @param max 추출할 숫자의 최대값
     * @return 비복원 추출로 추출된 무작위 수
     */
    private Integer samplingWithoutReplacement(Set<Integer> sampled, int min, int max) {
        Integer pick;
        do {
            pick = Randoms.pickNumberInRange(min, max);
        } while (sampled.contains(pick));
        return pick;
    }
}
