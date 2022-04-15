package baseball.model;

import java.util.HashSet;
import java.util.Set;

public class NumberValidator {

    private final int length;

    /**
     * 숫자 검증기 내부 생성자
     *
     * @param length 검증할 숫자의 길이
     */
    private NumberValidator(int length) {
        this.length = length;
    }

    /**
     * 숫자 검증기 생성자 함수
     *
     * @param length 검증할 숫자의 길이
     * @return 생성된 NumberValidator 객체
     */
    static public NumberValidator of(int length) {
        return new NumberValidator(length);
    }

    /**
     * 숫자 검증 함수
     *
     * @param target 검증할 숫자
     */
    public void validatePrediction(String target) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < target.length(); i++) {
            set.add(target.charAt(i));
        }
        if (target.length() != length || set.size() != length) {
            throw new IllegalArgumentException();
        }
    }
}
